package javabasic.annotation;

public class Cat {

    @ImportantString
    String name;

    public Cat(String name) {
        this.name = name;
    }

    @RunImmediately(times = 3)
    public void meow() {
        System.out.println("Meow");
    }

    public void eat() {
        System.out.println("Munch");
    }

}
