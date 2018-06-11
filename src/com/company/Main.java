package com.company;

public class Main {

    /**
     * Поток
     * 1. Stream API
     * 2. Input/Output Stream
     * 3. Multi-threading
     *
     */
    public static void main(String[] args) {
        //2 GHz - 1000$
        //4 GHz - 3000$ vs 1000$ two years later
        //4.4 GHz

        //16 GHz???

        //2 cores 2.2 GHz
        //4 cores
        //8 cores....

        //16 cores



        //Process vs Thread

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true);
//            }
//        }).start();
//
//
//        while (true);

        //since Java 1.0
        //class Thread
        //interface Runnable


        //since Java 1.5
        //interface Callable




        //parallel, async -> connected to multithreading

        Thread thread = new Thread(); //управление потоком: start, stop, interrupt, kill
        Runnable r = () -> {}; //что параллелить: our code


        thread.start();
        thread.run();















    }
}
