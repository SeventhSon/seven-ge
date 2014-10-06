
package com.engine.sevenge;

public class GameStateManager {

	private GameState currentState = null;

	public void setCurrentState (GameState currentState) {
		if (currentState == null) {
			throw new NullPointerException("Cannot set a null State");
		}

		if (this.currentState != currentState) {
			if (this.currentState != null) {
				this.currentState.pause();
				this.currentState.dispose();
			}
			currentState.resume();
			// currentState.update();
			this.currentState = currentState;
		}
	}

	public void update () {
		if (currentState != null) this.currentState.update();
	}

	public void draw () {
		if (currentState != null) this.currentState.draw();
	}

	public void pause () {
		if (currentState != null) this.currentState.pause();
	}

	public void resume () {
		if (currentState != null) this.currentState.resume();
	}

	public void dispose () {
		if (currentState != null) this.currentState.dispose();
	}

	public void onSurfaceChange (int width, int height) {
		if (currentState != null) this.currentState.onSurfaceChange(width, height);
	}

}