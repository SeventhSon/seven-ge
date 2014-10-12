
package com.engine.sevenge.sample;

import static android.opengl.Matrix.multiplyMM;
import static android.opengl.Matrix.orthoM;
import static android.opengl.Matrix.setLookAtM;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.view.MotionEvent;

import com.engine.sevenge.GameActivity;
import com.engine.sevenge.GameState;
import com.engine.sevenge.SevenGE;
import com.engine.sevenge.audio.Music;
import com.engine.sevenge.ecs.AnimationComponent;
import com.engine.sevenge.ecs.AnimationSystem;
import com.engine.sevenge.ecs.CameraComponent;
import com.engine.sevenge.ecs.CameraSystem;
import com.engine.sevenge.ecs.Entity;
import com.engine.sevenge.ecs.PositionComponent;
import com.engine.sevenge.ecs.RendererSystem;
import com.engine.sevenge.ecs.SpriteComponent;
import com.engine.sevenge.graphics.SubTexture2D;
import com.engine.sevenge.input.GestureProcessor;
import com.engine.sevenge.input.InputProcessor;
import com.engine.sevenge.utils.Log;

public class SampleGameState extends GameState implements InputProcessor, GestureProcessor {

	private final String TAG = "InputTest";

	private Music music;
	private RendererSystem rendererSystem;
	private CameraSystem cameraSystem;
	private AnimationSystem animationSystem;
	private List<Entity> entities;

	public SampleGameState (GameActivity gameActivity) {
		super(gameActivity);

		SevenGE.input.addInputProcessor(this);
		SevenGE.input.addGestureProcessor(this);

		SevenGE.assetManager.loadAssets(SevenGE.io.asset("sample.pkg"));

		rendererSystem = new RendererSystem();
		cameraSystem = new CameraSystem();
		animationSystem = new AnimationSystem();

		Random rng = new Random();
		entities = new ArrayList<Entity>();
		Entity cam = new Entity();
		entities.add(cam);
		for (int i = 0; i < 350; i++) {
			Entity e = new Entity();
			SpriteComponent cs = new SpriteComponent();
			PositionComponent cp = new PositionComponent();
			float rnd = rng.nextFloat();
			if (rnd < 0.5f)
				cs.subTexture = (SubTexture2D)SevenGE.assetManager.getAsset("meteorBrown_big1");
			else if (rnd < 0.7f)
				cs.subTexture = (SubTexture2D)SevenGE.assetManager.getAsset("meteorBrown_small2");
			else if (rnd < 0.95f)
				cs.subTexture = (SubTexture2D)SevenGE.assetManager.getAsset("meteorBrown_tiny2");
			else {
				cs.subTexture = (SubTexture2D)SevenGE.assetManager.getAsset("enemyRed1");
				AnimationComponent ca = new AnimationComponent();
				ca.frameList = new SubTexture2D[] {(SubTexture2D)SevenGE.assetManager.getAsset("enemyBlack1"),
					(SubTexture2D)SevenGE.assetManager.getAsset("enemyBlack2"),
					(SubTexture2D)SevenGE.assetManager.getAsset("enemyBlack3"),
					(SubTexture2D)SevenGE.assetManager.getAsset("enemyBlack4"),
					(SubTexture2D)SevenGE.assetManager.getAsset("enemyBlack5")};
				ca.durations = new int[] {500, 1000, 2000, 234, 666};
				ca.isPlaying = true;
				e.add(ca, 4);
			}

			cp.rotation = rng.nextFloat() * 360.0f;
			cp.x = rng.nextFloat() * 1000f;
			cp.y = rng.nextFloat() * 1000f;
			cs.scale = 1.0f;

			e.add(cp, 1);
			e.add(cs, 2);
			entities.add(e);
		}

		music = (Music)SevenGE.assetManager.getAsset("music1");
		music.setLooping(true);
		music.play();

	}

	@Override
	public void onSurfaceChange (int width, int height) {
		Entity e = entities.get(0);
		CameraComponent cc = new CameraComponent();
		cc.height = height;
		cc.width = width;
		cc.scale = 0.7f;
		PositionComponent cp = new PositionComponent();
		cp.x = 500;
		cp.y = 500;
		setLookAtM(cc.viewMatrix, 0, cp.x, cp.y, 1f, cp.x, cp.y, 0f, 0f, 1.0f, 0.0f);
		orthoM(cc.projectionMatrix, 0, -width / cc.scale / 2, width / cc.scale / 2, -height / cc.scale / 2, height / cc.scale / 2,
			0f, 1f);
		multiplyMM(cc.viewProjectionMatrix, 0, cc.projectionMatrix, 0, cc.viewMatrix, 0);
		e.add(cp, 1);
		e.add(cc, 8);
	}

	@Override
	public void update () {
		SevenGE.input.process();

		animationSystem.process(entities);
		cameraSystem.process(entities);
	}

	@Override
	public void draw () {
		rendererSystem.process(entities);
	}

	@Override
	public void dispose () {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause () {
		music.pause();

	}

	@Override
	public void resume () {
		music.play();

	}

	@Override
	public boolean onDoubleTap (MotionEvent me) {
		Log.d(TAG, "onDoubleTap");
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed (MotionEvent arg0) {
		Log.d(TAG, "onSingleTapConfirmed");
		return false;
	}

	@Override
	public boolean onFling (MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
		Log.d(TAG, "onFling");
		return false;
	}

	@Override
	public void onLongPress (MotionEvent arg0) {
		Log.d(TAG, "onLongPress");

	}

	@Override
	public boolean onScroll (MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
		Log.d(TAG, "onScroll");
		return false;
	}

	@Override
	public boolean touchDown (int x, int y, int pointer, int button) {
		Log.d(TAG, "touchDown" + " x : " + x + " , y : " + y + " , pointerid : " + pointer);
		return false;
	}

	@Override
	public boolean touchUp (int x, int y, int pointer, int button) {
		Log.d(TAG, "touchUp" + " x : " + x + " , y : " + y + " , pointerid : " + pointer);
		return false;
	}

	@Override
	public boolean touchMove (int x, int y, int pointer) {
		Log.d(TAG, "touchMove" + " x : " + x + " , y : " + y + " , pointerid : " + pointer);
		return false;
	}

}
