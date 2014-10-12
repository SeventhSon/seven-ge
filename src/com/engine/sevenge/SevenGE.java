
package com.engine.sevenge;

import com.engine.sevenge.assets.AssetManager;
import com.engine.sevenge.audio.Audio;
import com.engine.sevenge.input.Input;
import com.engine.sevenge.io.IO;

/*
 *  Class exposing game engine subsystems to the world.
 */
public class SevenGE {

	public static Input input;
	public static IO io;
	public static Audio audio;
	public static AssetManager assetManager;
	public static GameStateManager stateManager;

}
