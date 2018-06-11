package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class MultipleThreads {

    private static String[] jobs = {
            "Java development",
            "C# development",
            "Integration",
            "Deployment",
            "Team management",
            "HRing",
            "Networking"
    };
    private static String getRandomJob() {
        Random random = new Random();
        int randomIndex = random.nextInt(jobs.length - 1);
        return jobs[randomIndex];
    }

    static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        /**
         * Moore's law
         * Why do we need multi-threading OR "Free lunch is over"
         * Process vs Thread
         *
         * class Thread and interface Runnable
         * Starting threads
         * Joining threads (thread synchronization)
         *
         */


        splitTasksBetweenEmployees();
        startThreads();

//        waitForEveryoneToFinish();

        waitForEveryoneToFinishAndFire();

        System.out.println("The company has bankrupted. Good bye!");
    }

    /**
     * Фаза 1
     * Раздали задание!
     * Никто ничего не делает до команды .start()
     */
    private static void splitTasksBetweenEmployees() {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new OutsourceThread(getRandomJob()));
            threads.add(thread);
        }
    }

    /**
     * Фаза 2
     * ПОЕХАЛИ!!!!
     */
    private static void startThreads() {
        for (Thread thread : threads) {
            thread.start();
        }
    }

    private static void waitForEveryoneToFinish() {
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void waitForEveryoneToFinishAndFire() {
//        while (hasJobToDo()) {
//        }

        while (true) {
            Thread currentEmployee = getEmployeeWhoHasFinished();
            if (currentEmployee != null) {
                System.out.printf("Great job %s! You are fired. Door is out there ->> \n",
                        currentEmployee.getName());
            }


            if (currentEmployee == null && threads.size() == 0) {
                break;
            }

        }

        System.out.println("Looks like there are no employees left in our company...");
    }



    private static Thread getEmployeeWhoHasFinished() {
        Iterator<Thread> threadIterator = threads.iterator();

        while (threadIterator.hasNext()) {

            Thread t = threadIterator.next();
            if (!t.isAlive()) { //НЕ живы
                threadIterator.remove();
                return t;
            }
        }

        //null returns in two cases:
        //1. when there are no threads left in List<Thread> threads (threads.size() == 0)
        //2. when the program never entered IF block -> all threads are alive

        return null;
    }

    private static boolean hasJobToDo() {
        for (Thread t : threads) {
            if (t.isAlive()) {
                return true;
            }
        }
        return false;
    }
}

class OutsourceThread implements Runnable {

    private String job;

    public OutsourceThread(String job) {
        this.job = job;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name  + " начал работу!");
        System.out.println(name + " executing " + this.job);
        try {
            //1000ms -> 1 sec
            //500ms -> 0.5 sec
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + " has finished the job!");
    }
}