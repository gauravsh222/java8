package com.threads;

import java.util.concurrent.CountDownLatch;

/**
 * Main thread is calling await method so it will wait until all thread do countdown,
 * but child threads can continue their work after counting down latch so main thread can proceed with its work.
 */


public class CountDownLatchSystem {

    private static CountDownLatch latch = new CountDownLatch(4);
    public static void main(String[] args) {

        System.err.println("project is going to start soon from scratch");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread development = new Thread(CountDownLatchSystem::completeDevelopment);
        development.start();
        System.out.println("project Given for development");
        Thread qa = new Thread(CountDownLatchSystem::completeQATesting);
        qa.start();
        System.out.println("project Given for QA testing");
        Thread perf = new Thread(CountDownLatchSystem::completePerfTesting);
        perf.start();
        System.out.println("project Given for Perf testing");
        Thread uat = new Thread(CountDownLatchSystem::completeUATTesting);
        uat.start();
        System.out.println("project Given for UAT testing");

        try {
            latch.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Project is ready for build & deployment, latch : " + latch.getCount());

      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        System.out.println("project went live");

    }

    public static void completeDevelopment(){
        latch.countDown();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("writing code");

    }

    public static void completeQATesting(){
        System.out.println("testing code");
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        latch.countDown();
    }

    public static void completePerfTesting(){
        System.out.println("breaking load");
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        latch.countDown();
    }

    public static void completeUATTesting(){
        System.out.println("user testing code");
        /*try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/
        latch.countDown();
    }
}
