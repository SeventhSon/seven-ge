package com.engine.sevenge.sample;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.engine.sevenge.graphics.Camera2D;
import com.engine.sevenge.input.InputEvent;

public class InputProcessor {
	Queue<InputEvent> EventQueue;
	float[] coords1 = new float[4];
	float[] coords2 = new float[4];
	public InputProcessor() {
		EventQueue = new ConcurrentLinkedQueue<InputEvent>();
	}

	public void addEvent(InputEvent ie) {
		EventQueue.add(ie);
	}

	public void process(Camera2D cam) {
		InputEvent ie = EventQueue.poll();
		while (ie != null) {
			if(ie.type.equals("Drag"))
			{
				coords1 = cam.unProject(ie.x1, ie.y1);
				float x1 = coords1[0];
				float y1 = coords1[1];
				coords2 = cam.unProject(ie.x2, ie.y2);
				float x2 = coords2[0];
				float y2 = coords2[1];
				float[] cameraxy = cam.getCameraXY();
				cam.lookAt(cameraxy[0]-(x2-x1), cameraxy[1]-(y2-y1));
				float deltay = ie.y2-ie.y1;
				float deltax = ie.x2-ie.x1;
			}
			ie = EventQueue.poll();
		}
	}
}