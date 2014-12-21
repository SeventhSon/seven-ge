package com.engine.sevenge.test;

import java.util.ArrayList;
import java.util.Arrays;

import junit.framework.TestCase;

import com.sevenge.utils.Pool;
import com.sevenge.utils.Pool.PoolObjectFactory;

public class PoolTest extends TestCase {

  PoolObjectFactory<Object> objectFactory;
  Pool<Object> objectPool;
  private static final int POOL_SIZE = 20;

  @Override
  protected void setUp() throws Exception {
    objectFactory = new PoolObjectFactory<Object>() {
      @Override
      public Object createObject() {
        return new Object();
      }
    };

    objectPool = new Pool<Object>(objectFactory, POOL_SIZE);

  }

  public void testExceedPoolSize() {

    ArrayList<Object> objects = new ArrayList<Object>();

    for (int i = 0; i < POOL_SIZE + 2; i++) {
      objects.add(objectPool.newObject());
    }

    assertEquals(objects.size(), POOL_SIZE + 2);

  }

  public void testFreePool() {

    ArrayList<Object> objects = new ArrayList<Object>();

    for (int i = 0; i < POOL_SIZE + 2; i++) {
      objects.add(objectPool.newObject());
    }
    for (Object o : objects)
      objectPool.free(o);

    assertEquals(objects.size(), POOL_SIZE + 2);
    assertFalse(Arrays.asList(objects).contains(null));

  }

}
