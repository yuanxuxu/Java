package javabasic.concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class ReadWriteLock {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private ReadLock readLock = lock.readLock();
    private WriteLock writeLock = lock.writeLock();

    // if t1 and t2 both try to access the readLock at the same time
    // they are allowed, t3 and t4 can't same time
    public static void main(String[] args) {
        ReadWriteLock obj = new ReadWriteLock();
        Thread t1 = new Thread(() -> obj.readResource());
        t1.start();
        Thread t2 = new Thread(() -> obj.readResource());
        t2.start();
        Thread t3 = new Thread(() -> obj.writeResource());
        t3.start();
        Thread t4 = new Thread(() -> obj.writeResource());
        t4.start();
    }

    private void readResource() {
        readLock.lock();
        // view the resource
        readLock.unlock();
    }

    private void writeResource() {
        writeLock.lock();
        // update the resource
        writeLock.unlock();
    }
}
