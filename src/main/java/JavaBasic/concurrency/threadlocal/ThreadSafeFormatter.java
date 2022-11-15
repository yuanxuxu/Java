package javabasic.concurrency.threadlocal;

import java.text.SimpleDateFormat;

public class ThreadSafeFormatter {

    public static ThreadLocal<SimpleDateFormat> dateFormatter = new ThreadLocal<>() {
        // Called once for each thread
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        // 1st call = initialValue(), subsequent calls
        // will return same initialized value
        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };

    public static ThreadLocal<SimpleDateFormat> dfFunctional = ThreadLocal
            .withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

}
