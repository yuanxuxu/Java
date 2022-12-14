package javabasic.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE, ElementType.METHOD }) // what element it can be used, Type(class)/method/field
@Retention(RetentionPolicy.RUNTIME) // 99% use cases, keep it alive during runtime so other code can use it, e.g.,
                                    // Reflection
public @interface VeryImportant { // to create cumstom annotation

}
