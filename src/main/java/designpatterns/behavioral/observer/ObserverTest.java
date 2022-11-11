package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Good exmaple:
 * 
 * The observer pattern is a software design pattern in which an object, named
 * the subject, maintains a list of its dependents, called observers, and
 * notifies them automatically of any state changes, usually by calling one of
 * their methods.
 * 
 * The Observer Pattern defines a one-to-many dependency between
 * objects so that
 * when one object changes state, all of its dependents are notified and updated
 * automatically.
 */

public class ObserverTest {
    public static void main(String[] args) {
        Random rand = new Random();

        Event event = new Event();

        Observer A = Observer.A();
        Observer B = Observer.B();

        event.addObserver(A);
        event.addObserver(B);

        event.notifyObservers(rand.nextInt(100));
        event.notifyObservers(rand.nextInt(100));
    }
}

interface Observer {
    void update(int event);

    static Observer A() {
        return a -> System.out.println(a);
    }

    static Observer B() {
        return a -> System.out.println(a + 1);
    }
}

class Event {

    private final List<Observer> observers = new ArrayList<>();

    public void notifyObservers(int event) {
        observers.forEach(observer -> observer.update(event));
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}
