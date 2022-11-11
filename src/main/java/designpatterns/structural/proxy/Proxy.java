package designpatterns.structural.proxy;

/**
 * A proxy, in its most general form, is a class
 * functioning as an interface to something else
 *
 * Use of the proxy can simply be forwarding to the
 * real object, or can provide additional logic
 * 
 * The proxy could interface to anything: a network connection, a large object
 * in memory, a file, or some other resource that is expensive or impossible to
 * duplicate. In short, a proxy is a wrapper or agent object that is being
 * called by the client to access the real serving object behind the scenes. Use
 * of the proxy can simply be forwarding to the real object, or can provide
 * additional logic. In the proxy, extra functionality can be provided, for
 * example caching when operations on the real object are resource intensive, or
 * checking preconditions before operations on the real object are invoked. For
 * the client, usage of a proxy object is similar to using the real object,
 * because both implement the same interface.
 */

public class Proxy {

    public static void main(String[] args) {
        Image image = new ProxyImage("file1");
        image.display();

        image.display();
    }

}

// can be class
interface Image {
    public void display();
}

class RealImage implements Image {

    private final String name;

    public RealImage(String name) {
        this.name = name;
        load();
    }

    private void load() {
        System.out.println("Loading " + name);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + name);
    }
}

class ProxyImage implements Image {

    private final String name;
    private RealImage realImage;

    public ProxyImage(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(name);
        }
        realImage.display();
    }
}