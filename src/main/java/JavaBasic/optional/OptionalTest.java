package javabasic.optional;

import java.util.Optional;

/**
 * Optional is intend to be a return type that address possible null return
 */
public class OptionalTest {

    public static void main(String[] args) {
        // DB call, what should it return if no name call Fred? return null
        Cat cat0 = findCatByName("Fred");

        // Option 1:
        if (cat0 != null) {
            // do sth
        }

        // Option 2:
        // using Optional indicate that the return may be null
        Optional<Cat> cat = findCatByNameWithOptional("Fred");
        if (cat.isPresent()) {
            System.out.println(cat.get().getAge());
        }

        Cat catOrElse = cat.orElse(new Cat("Unknown", 0));

        Cat catOrElseGet = cat.orElseGet(() -> new Cat("UnkownSuppiler", 0));

        cat.get(); // is equivalent to below
        cat.orElseThrow();

        cat.map(Cat::getAge); // if cat is empty optional, it will return empty optional

        cat.map(Cat::getAge)
                .orElse(0);

        cat.flatMap(null);
    }

    private static Optional<Cat> findCatByNameWithOptional(String name) {
        Cat cat = new Cat(name, 3);
        Optional.of(cat);
        Optional.empty();
        return Optional.ofNullable(cat); // if null pass it, it will create an empty optional
    }

    private static Cat findCatByName(String name) {
        Cat cat = new Cat(name, 3);
        return cat;
    }
}
