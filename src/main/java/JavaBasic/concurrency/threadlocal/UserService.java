package javabasic.concurrency.threadlocal;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserService {

    private static ExecutorService executorService = Executors.newFixedThreadPool(10);

    // Moved out of birthDate function, so all threads can share it
    // However, the class is not a thread safe class, if two or more threads
    // is going to acess this obj, there can be data integrity issue
    private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) throws InterruptedException {
        // 1. Create a thread
        new Thread(() -> {
            String birthDate = new UserService().birthDate(10);
            System.out.println(birthDate);
        }).start();

        new Thread(() -> {
            String birthDate = new UserService().birthDate(10);
            System.out.println(birthDate);
        }).start();

        // 2. Create threads using for loop
        for (int i = 0; i < 10; i++) {
            int id = i;
            new Thread(() -> {
                String birthDate = new UserService().birthDate(id);
                System.out.println(birthDate);
            }).start();
        }

        // 3. Create lots of runnable tasks, impractical due to using
        // too much memory, using thread pool instead
        for (int i = 0; i < 1000; i++) {
            int id = i;
            executorService.submit(() -> {
                String birthDate = new UserService().birthDate(id);
                System.out.println(birthDate);
            });
        }

        Thread.sleep(1000);
    }

    public String birthDate(int userId) {
        LocalDateTime localDateTime = birthDateFromDB(userId);
        // Each thread get its own copy
        SimpleDateFormat df = ThreadSafeFormatter.dateFormatter.get();
        return df.format(localDateTime);
    }

    private LocalDateTime birthDateFromDB(int userId) {
        LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
                DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
        return dt;
    }
}
