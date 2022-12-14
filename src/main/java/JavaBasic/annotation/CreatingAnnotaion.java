package javabasic.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@VeryImportant
public class CreatingAnnotaion {
    public static void main(String[] args)
            throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        @SuppressWarnings("unused")
        int unusedVariable;

        Integer a = 1;

        a.getClass().isAnnotationPresent(VeryImportant.class);

        Cat cat = new Cat("Wendy");

        for (Method method : cat.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(RunImmediately.class)) {
                RunImmediately runImmediately = method.getAnnotation(RunImmediately.class);
                int times = runImmediately.times();
                for (int i = 0; i < times; i++) {
                    method.invoke(cat);
                }
            }
        }

        for (Field field : cat.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ImportantString.class)) {
                Object objectValue = field.get(cat);
                if (objectValue instanceof String stringValue) { // Pattern matching: objectValue instanceof String
                                                                 // stringValue
                    // String stringValue = (String) objectValue;
                    System.out.println(stringValue.toUpperCase());
                }
            }
        }
    }

}
