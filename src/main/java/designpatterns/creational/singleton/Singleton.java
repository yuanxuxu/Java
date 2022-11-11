package designpatterns.creational.singleton;

/**
 * An enum type is a special type of class.
 *
 * */
public enum Singleton {
    INSTANCE;


    private Singleton() {
        System.out.println("Initialed only once at the first time used");
    }

    /*
    Your enum will actually be compiled to something like

    public final class MySingleton {
        public final static MySingleton INSTANCE = new MySingleton();
        private MySingleton(){}
    }

    */
}
