
package com.engine.sevenge.input;

import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

import com.engine.sevenge.input.Input.Gesture;

public class GestureHandler implements OnGestureListener, OnDoubleTapListener {

	Input input;

	public GestureHandler (Input input) {
		this.input = input;
	}

	@Override
	public boolean onDoubleTap (MotionEvent me) {

		Gesture g = input.gesturePool.newObject();
		g.type = Gesture.DOUBLETAP;
		g.motionEvent1 = me;
		input.gestures.add(g);

		return false;
	}

	@Override
	public boolean onDoubleTapEvent (MotionEvent me) {
		return false;
	}

	@Override
	public boolean onSingleTapConfirmed (MotionEvent me) {

		Gesture g = input.gesturePool.newObject();
		g.type = Gesture.TAP;
		g.motionEvent1 = me;
		input.gestures.add(g);

		return false;
	}

	@Override
	public boolean onDown (MotionEvent arg0) {
		// do not add code here !!!
		return false;
	}

	@Override
	public boolean onFling (MotionEvent me1, MotionEvent me2, float vx, float vy) {

		Gesture g = input.gesturePool.newObject();
		g.type = Gesture.FLING;
		g.motionEvent1 = me1;
		g.motionEvent1 = me2;
		g.velX = vx;
		g.velY = vy;
		input.gestures.add(g);

		return false;
	}

	@Override
	public void onLongPress (MotionEvent me1) {

		Gesture g = input.gesturePool.newObject();
		g.type = Gesture.LONGPRESS;
		g.motionEvent1 = me1;
		input.gestures.add(g);

	}

	@Override
	public boolean onScroll (MotionEvent me1, MotionEvent me2, float dx, float dy) {

		Gesture g = input.gesturePool.newObject();
		g.type = Gesture.SCROLL;
		g.motionEvent1 = me1;
		g.motionEvent2 = me2;
		g.distX = dx;
		g.distY = dy;
		input.gestures.add(g);

		return false;
	}

	@Override
	public void onShowPress (MotionEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean onSingleTapUp (MotionEvent arg0) {
		// do not add code here !!!
		return false;
	}
}