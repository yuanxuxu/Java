package designpatterns.behavioral.mediator;

import java.util.HashMap;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

public class Demo {

    public static void main(String[] args) {
        Medt<Integer> medt = new Medt<>();
        medt.setValue("bob", 20);
        medt.setValue("alice", 24);
        medt.getValue("alice").ifPresent(
                age -> System.out.println("age: " + age)
        );
        medt.addObserver("bob", () -> {
            System.out.println("new age for bob: " +
                    medt.getValue("bob").orElseThrow(RuntimeException::new));
        });
        medt.setValue("bob", 21);
    }

}

class Storage<T> {
    T value;

    T getValue() {
        return value;
    }

    void setValue(Medt<T> m, Storage storage, T value) {
        this.value = value;

    }
}

class Medt<T> {
    private final HashMap<String, Storage<T>>  storageHashMap =
            new HashMap<>();
    private final CopyOnWriteArrayList<Consumer<String>> observers =
            new CopyOnWriteArrayList<>();

    public void setValue(String storageName, T value) {
        Storage storage = storageHashMap.computeIfAbsent(storageName,
                name -> new Storage<>());
        storage.setValue(this, storage, value);
    }

    public Optional<T> getValue(String storageName) {
        return Optional.ofNullable(storageHashMap.get(storageName))
                .map(Storage::getValue);
    }

    public void addObserver(String storageNme, Runnable observer) {
        observers.add(eventName -> {
            if (eventName.equals(storageNme)) {
                observer.run();
            }
        });
    }

    void notifyObservers(String eventName) {
        observers.forEach(observer -> observer.accept(eventName));
    }
}