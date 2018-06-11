package com.company;


public class RunVsStartExample {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
//                System.out.println("public void run()");
                System.out.println(Thread.currentThread().getName());
                while (true);
            }
        };

        Thread threadManager = new Thread(r);
        threadManager.start();

//        System.out.println("public static void main(){} ");
        System.out.println(Thread.currentThread().getName());

        //1. Зависнет
        //2. Закроется
        //3. Не закроется <--- верно!

    }
}
