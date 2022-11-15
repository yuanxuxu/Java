package javabasic.effectivejava.generic;

import java.io.Serializable;

// bounded generic, animal can be replaced with interface
// can extends multiple parents, classes first then interfaces
public class PrintAnimal<T extends Animal & Serializable, V> {
    T thingToPrint;
    V otherThingToPrint;

    public PrintAnimal(T thingToPrinT, V otherThingToPrint) {
        this.thingToPrint = thingToPrinT;
        this.otherThingToPrint = otherThingToPrint;
    }

    public void print() {
        thingToPrint.eat();
        System.out.println(thingToPrint.age);
        System.out.println(otherThingToPrint);
    }
}
