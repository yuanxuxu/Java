package designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * A flyweight is an object that minimizes memory
 * usage by sharing as much data as possible with
 * other similar objects; it is a way to use objects
 * in large numbers when a simple repeated representation
 * would use an unacceptable amount of memory
 *
 * https://www.runoob.com/design-pattern/flyweight-pattern.html
 * */

public class Flyweight {

    // color: shared, x: not shared
    public static void main(String[] args) {
        String[] colors = {"red", "blue"};
        Circle circle = Factory.getCircle("red");
        circle.x = 5;

        Circle circle1 = Factory.getCircle("red");
        circle.x = 10;

    }

}

class Factory {
    private final static Map<String, Circle> map = new HashMap<>();
    public static Circle getCircle(String color) {
        Circle circle = map.get(color);
        if (circle == null) {
            circle = new Circle();
            map.put(color, circle);
        }
        return circle;
    }
}

class Circle {
    int x;
}






















