package com.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierSystem {

    private static int codeCommitValue;
    private static final CyclicBarrier barrier = new CyclicBarrier(4);

    public static void main(String[] args) {
        System.err.println("project is going to start soon from scratch");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Thread development = new Thread(CyclicBarrierSystem::completeDevelopment, "Developer-1");
        development.start();
        Thread qa = new Thread(CyclicBarrierSystem::completeDevelopment, "Developer-2");
        qa.start();
        Thread perf = new Thread(CyclicBarrierSystem::completeDevelopment, "Developer-3");
        perf.start();
        Thread uat = new Thread(CyclicBarrierSystem::completeDevelopment, "Developer-4");
        uat.start();

        while (codeCommitValue != 4) {}
        System.out.println("Project is ready for deployment");
    }
    public static void completeDevelopment(){
        try {
            System.out.println(Thread.currentThread().getName() + " is waiting for other " + barrier.getNumberWaiting() + " to complete");
            barrier.await();
            System.out.println(Thread.currentThread().getName() + " has submitted his code");
            codeCommitValue++;
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

}
