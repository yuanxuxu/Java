package javabasic.concurrency.executorSer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExecutorT {

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
        // CPU intensive: coreCount;
        // IO intensive: much higher count, e.g.100
        int coreCount = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(coreCount);

        ExecutorService service2 = new ThreadPoolExecutor(
                10,
                100,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(300),
                // Executors.defaultThreadFactory(),
                // new SimpleThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 100; i++) {
            service.execute(new Task());
        }

        List<Future> allFutures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            // submit can be used for Runnable and Callable
            Future<Integer> future = service.submit(new TaskCallable());
            allFutures.add(future);
        }

        // perform some other operations

        for (int i = 0; i < 100; i++) {
            Future<Integer> future = allFutures.get(i); // blocking
            // max wait time 1 second, if no result return, throw timeout exception
            Integer result = future.get(1, TimeUnit.SECONDS);
        }

        System.out.println("Thread name: " +
                Thread.currentThread().getName());

    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread name: " +
                    Thread.currentThread().getName());
        }
    }

    // Base on the type cast to Callable, it will be the return type
    static class TaskCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            // TODO Auto-generated method stub
            return null;
        }

    }

    private static class CustomRejectionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            // logging / operations to perform on rejection
        }
    }

    /**
     * This factory is used when the executor creates a new thread.
     * Using ThreadFactory you can customize the threads created by
     * executor so that they have proper thread names, priority or
     * even they can be set to be daemon also.
     */
    private static class SimpleThreadFactory implements ThreadFactory {
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }
}