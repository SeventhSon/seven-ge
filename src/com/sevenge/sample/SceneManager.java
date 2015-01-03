
package com.sevenge.sample;

import com.sevenge.ecs.Entity;
import com.sevenge.ecs.PositionComponent;
import java.math.*;

public class SceneManager {

	private Entity root = new Entity();

	public Entity getRoot () {
		return root;
	}

	public void update () {

		traverse(root);

	}

	private void traverse (Entity entity) {

		if (entity.isRelative) {

			PositionComponent positionComponent = (PositionComponent)entity.mComponents[0];
			PositionComponent parentPositionComponent = (PositionComponent)entity.parent.mComponents[0];
			
			float rotRad = (-1)*(float) Math.toRadians(parentPositionComponent.rotation);
			float cos = (float)Math.cos(rotRad);
			float sin = (float)Math.sin(rotRad);
			float x =  (entity.relativeX *cos - entity.relativeY *sin);
			float y =  (entity.relativeY *cos + entity.relativeX *sin);
			
			positionComponent.x = parentPositionComponent.x + x;
			positionComponent.y = parentPositionComponent.y + y;
			positionComponent.rotation = parentPositionComponent.rotation + entity.relativeRotation;

		}

		for (Entity e : entity.children) {

			traverse(e);
		}

	}

}
