package com.company;

public class ThreadCorrectExample {

    /**
     * Core 1
     */
    public static void main(String[] args) throws InterruptedException {


        Thread thread = new Thread(new MyOtherThread());
        thread.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("Привет");
        }

        System.out.println(Thread.currentThread().getName() + " ended");


    }
}


/**
 * Core 2
 */
class MyOtherThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Пока!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + " ended");

    }
}