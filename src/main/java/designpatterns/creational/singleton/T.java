package designpatterns.creational.singleton;

public class T {

    public static void main(String[] args) {
        System.out.println("First time: " + Singleton.INSTANCE);
        System.out.println("Second time: " + Singleton.INSTANCE);
    }

}
