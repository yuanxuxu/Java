package javabasic.concurrency.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Semaphores {
    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {

        ExecutorService service = Executors.newFixedThreadPool(50);

        IntStream.of(1000).forEach(i -> service.execute(new Task()));

        service.shutdown();

        service.awaitTermination(1, TimeUnit.SECONDS);
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            semaphore.acquireUninterruptibly();
            // IO call to slow service
            semaphore.release();
        }

    }
}
