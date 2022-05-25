package com.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;

class MyThreadFactory implements ThreadFactory {
   int i = 1;
    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "Gaurav-"+i++);
    }
}

class Task implements Runnable {

    private Semaphore semaphore;
    private String name;

    Task(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }



    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.err.println("Acquired By : " + Thread.currentThread().getName() + " for " + name);
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            System.err.println("Some Error");
        } finally {
            semaphore.release();
            System.out.println("Released By : " + Thread.currentThread().getName() + " for " + name);
        }
        System.out.println("--------------------------------------------");
    }
}

public class MySemaphore {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getThreadGroup().getName());
        System.out.println(Thread.currentThread().getThreadGroup().getParent().getName());
//        System.out.println(Thread.currentThread().getThreadGroup().getParent().getParent().getName());

        Semaphore semaphore = new Semaphore(2);

        ExecutorService executorService = Executors.newFixedThreadPool(9, new MyThreadFactory());
        for (int i=1; i<10; i++) {
            executorService.execute(new Task(semaphore, "Task-"+i));
        }

    }



}
