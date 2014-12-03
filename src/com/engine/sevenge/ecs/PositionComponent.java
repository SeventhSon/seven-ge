
package com.engine.sevenge.ecs;

public class PositionComponent extends Component {
	public static int MASK = 1 << 0; // 0x01
	public float x;
	public float y;
	public float px;
	public float py;
	public float rotation;
	public float[] scaleMatrix = new float[16];
	public float[] transform = new float[16];
}
