package javabasic.concurrency.interrupt;

import java.util.concurrent.Callable;

public class Interrupt {
    public static void main(String[] args) {
        Thread taskThread = new Thread(new Task());
        taskThread.start();
        System.out.println("Long running task started");

        taskThread.interrupt(); // no guarantee to stop

        System.out.println("Asking politely to stop");
    }

    static Runnable task2 = () -> {
    };

    static class Integer implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {

            for (int i = 0; i < 1000; i++) {
                process(0);

                // callable allow throw interrupt exception
                if (Thread.currentThread().isInterrupted()) {
                    throw new InterruptedException();
                }
            }

            return null;
        }

    }

    static class Task implements Runnable {

        @Override
        public void run() {

            for (int i = 0; i < 1000; i++) {
                // perform few subset of steps
                process(i);

                // polls for interrupts
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Stopping the task");
                    return;
                }

                if (Thread.currentThread().isInterrupted()) {
                    // if you don't care, and want current thread to continue
                    // check and reset the flag value to false
                    Thread.interrupted();
                }
            }

        }

    }

    private static void process(int i) {
    };
}
