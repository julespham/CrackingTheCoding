package com.julespham.ctci.stacks_and_queues;

import java.util.Queue;
import java.util.LinkedList;

class Pair<K, V> {
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    private K key;
    private V value;
}


class AnimalNotAvailableException extends Exception {
    public AnimalNotAvailableException(String errorMessage) {
        super(errorMessage);
    }
}

class InvalidAnimalException extends Exception {
    public InvalidAnimalException(String errorMessage) {
        super(errorMessage);
    }
}

public class AnimalShelter {
    private Queue<Pair<Animal, Integer>> doggos;
    private Queue<Pair<Animal, Integer>> cats;
    private int id = 0;

    public AnimalShelter() {
        doggos = new LinkedList<>();
        cats = new LinkedList<>();
    }

    public void enqueue(Animal animal) throws InvalidAnimalException {
        Pair<Animal, Integer> record = new Pair<>(animal, id++);
        switch(animal.type)  {
            case "dog":
                doggos.add(record);
                break;
            case "cat":
                cats.add(record);
                break;
            default:
              throw new InvalidAnimalException(animal.type);
        }
    }

    public Animal dequeueAny() throws AnimalNotAvailableException {
        if (doggos.isEmpty() && cats.isEmpty()) {
            throw new AnimalNotAvailableException("Sorry, no animals available at this time!");
        }
        if (doggos.isEmpty()) {
           return cats.remove().getKey();
        }
        if (cats.isEmpty()) {
           return doggos.remove().getKey();
        }
        return doggos.peek().getValue() < cats.peek().getValue() ? doggos.remove().getKey() : cats.remove().getKey();
    }

    public Animal dequeueDoggo() throws AnimalNotAvailableException {
        if (doggos.isEmpty()) {
            throw new AnimalNotAvailableException("No dog is available, opt for another animal?");
        }
        return doggos.remove().getKey();
    }

    public Animal dequeueBananaCat() throws AnimalNotAvailableException{
        if (cats.isEmpty()) {
            throw new AnimalNotAvailableException("No cat is available, opt for another animal?");
        }
        return cats.remove().getKey();
    }
}
