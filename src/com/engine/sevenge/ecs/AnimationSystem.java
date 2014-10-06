
package com.engine.sevenge.ecs;

import java.util.List;

import com.engine.sevenge.GameActivity;

public class AnimationSystem extends System {
	private static int SYSTEM_MASK = SpriteComponent.MASK | AnimationComponent.MASK;

	@Override
	public void process (List<Entity> entities) {
		for (Entity entity : entities) {
			if ((SYSTEM_MASK & entity.mask) == SYSTEM_MASK) {
				AnimationComponent ca = (AnimationComponent)entity.components.get(4);

				if (ca.isPlaying) {
					SpriteComponent cs = (SpriteComponent)entity.components.get(2);
					ca.currentFrameTick++;
					if (ca.currentFrameTick * GameActivity.FRAME_TIME > ca.durations[ca.currentFrame]) {

						ca.currentFrame = (ca.currentFrame + 1) % ca.durations.length;

						ca.currentFrameTick = 1;
						cs.subTexture = ca.frameList[ca.currentFrame];
					}
				}
			}
		}

	}

	@Override
	public void handleMessage (Message m, Entity e) {
		// TODO Auto-generated method stub

	}
}