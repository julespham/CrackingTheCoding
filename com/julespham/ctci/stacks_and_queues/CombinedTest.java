package com.julespham.stacks_and_queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CombinedTest {
  @Test
  public void testMinStack() {
    MinStack stack = new MinStack();
    for (int x : new int[]{3, 2, 4, 6, 1, 9}) {
      stack.push(x);
    }

    assertEquals(1, stack.min());
    stack.pop();
    stack.pop();
    assertEquals(2, stack.min());
    stack.push(0);
    assertEquals(0, stack.min());
  }
}