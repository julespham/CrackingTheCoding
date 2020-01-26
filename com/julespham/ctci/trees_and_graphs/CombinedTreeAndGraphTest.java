package com.julespham.ctci.stacks_and_queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

  @Test
  public void testStack() {
    Stack stack = new Stack(10);
    stack.push(1);

    assertEquals(1, stack.pop());
  }

  @Test
  public void testSortedStack() {
    SortStack stack = new SortStack();
    stack.push(10);
    stack.push(2);
    stack.push(5);
    stack.push(11);
    assertEquals(2, stack.pop());
    assertEquals(5, stack.pop());
    assertEquals(10, stack.peek());
    assertEquals(10, stack.pop());
    assertEquals(11, stack.pop());
    assertTrue(stack.isEmpty());
  }

  @Test
  public void testAnimalShelter() {
    AnimalShelter animalShelter = new AnimalShelter();
  
    try {
        animalShelter.enqueue(new Animal("Alfred", "dog"));
        animalShelter.enqueue(new Animal("Bailey", "cat"));
        animalShelter.enqueue(new Animal("Chris", "cat"));
        animalShelter.enqueue(new Animal("Denver", "cat"));
        animalShelter.enqueue(new Animal("Emily", "dog"));
        animalShelter.enqueue(new Animal("Fredrick", "dog"));

        assertEquals("Alfred", animalShelter.dequeueAny().name);
        assertEquals("Bailey", animalShelter.dequeueBananaCat().name);
        assertEquals("Emily", animalShelter.dequeueDoggo().name);
    } catch(Exception e) {
        fail("Unexpected exception was thrown: " + e.toString());
    }
    
  }
}