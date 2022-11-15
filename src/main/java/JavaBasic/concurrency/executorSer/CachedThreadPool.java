package javabasic.concurrency.executorSer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    public static void main(String[] args) {
        // for many short live tasks
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executorService.submit(new Task());
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            // short lived task
        }

    }
}
