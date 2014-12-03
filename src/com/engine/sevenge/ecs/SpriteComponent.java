
package com.engine.sevenge.ecs;

import com.engine.sevenge.assets.TextureRegion;

public class SpriteComponent extends Component {
	public static int MASK = 1 << 1; // 0x02
	public float scale;
	public TextureRegion textureRegion;
}
