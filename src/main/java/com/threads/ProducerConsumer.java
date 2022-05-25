package com.threads;

import java.util.Stack;

class Account {
    private final Stack<Double> stack = new Stack<>();
    public void deposit(double amount) {
        stack.push(amount);
    }

    public Double withdraw() {
        return stack.pop();
    }
}

class Producer implements Runnable {
    private final Account account;
    public Producer(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        double i=10.0;
        while (true) {
            account.deposit(i);
            i = i + 10;
            synchronized (account) {
                account.notify();
                System.out.println("I have Deposited Money and notified to consumer, now going to wait state");
                try {
                    account.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer implements Runnable {
    private final Account account;
    public Consumer(Account account) {
        this.account = account;
    }
    @Override
    public void run() {
        while (true) {
            synchronized (account) {
                account.notify();
                System.err.println("I have Withdraw Money and notified to producer, now going to wait state");
                try {
                    account.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            double amount = account.withdraw();
        }
    }
}

public class ProducerConsumer {
    public static void main(String[] args) {
        Account account = new Account();
        Thread producer = new Thread(new Producer(account), "Producer Thread");
        producer.start();
        // Sleeping for 1 sec before starting consumer as producer has to produce first...
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Thread consumer = new Thread(new Consumer(account), "Consumer Thread");
        consumer.start();
        System.out.println("All Threads Started");
    }
}
