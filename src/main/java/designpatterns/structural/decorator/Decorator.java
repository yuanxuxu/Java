package designpatterns.structural.decorator;

/**
 *
 * Allows behavior to be added to an individual object,
 * dynamically, without affecting the behavior of other
 * objects from the same class
 *
 */
public class Decorator {

    public static void main(String[] args) {
        Window window = new Horizontal(new VerticalDecorator(
                new SimpleWindow()));

        System.out.println(window.getDescription());
    }

}

interface Window {
    void draw();

    String getDescription();
}

class SimpleWindow implements Window {
    @Override
    public void draw() {

    }

    @Override
    public String getDescription() {
        return "Simple Window";
    }
}

abstract class WindowDecorator implements Window {
    private final Window window;

    public WindowDecorator(Window window) {
        this.window = window;
    }

    @Override
    public void draw() {
        window.draw();
    }

    @Override
    public String getDescription() {
        return window.getDescription();
    }
}

class VerticalDecorator extends WindowDecorator {

    public VerticalDecorator(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        super.draw();
        drawVertical();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + "includeing vertical";
    }

    private void drawVertical() {

    }
}

class Horizontal extends WindowDecorator {
    public Horizontal(Window window) {
        super(window);
    }

    @Override
    public void draw() {
        super.draw();
        drawHorizontal();
    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", " + "including horizontal";
    }

    private void drawHorizontal() {

    }
}
