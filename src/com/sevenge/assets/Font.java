
package com.sevenge.assets;

/** Class holding information about font for drawing text in OpenGL */
public class Font extends Asset {

	public int fontPadX;
	public int fontPadY;
	public int cellWidth;
	public int cellHeight;
	public float scaleY = 1.f;
	public float scaleX = 1.f;
	public TextureRegion[] charRgn;
	public float[] charWidths;
	public float spaceX = 0;
}