package com.company;

public class ThreadOperationsExample {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(new SeparateThread());
        t.setName("separate-thread");
        t.start();

        //!!        Thread border       !!

        //Эй, main, подожди separate-thread!
        t.join(); //main: ЖДУ!

        //join -> синхронизация потоков -> сделай их опять последовательными

        for (int i = 0; i < 5; i++) {
            Thread.sleep(1000);
            System.out.println("My name is " + Thread.currentThread().getName());
        }
    }
}

class SeparateThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("My name is " + Thread.currentThread().getName());
        }

        System.out.println(Thread.currentThread().getName() + " is done!");
    }
}
