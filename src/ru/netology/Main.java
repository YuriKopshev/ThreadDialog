package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        ThreadGroup mainGroup = new ThreadGroup("mainGroup");
        Thread thread1 = new Thread(mainGroup, new MyThread("first"));
        Thread thread2 = new Thread(mainGroup, new MyThread("second"));
        Thread thread3 = new Thread(mainGroup, new MyThread("third"));
        Thread thread4 = new Thread(mainGroup, new MyThread("fourth"));

        System.out.println("Создаю потоки...");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mainGroup.interrupt();
        System.out.println("Завершаю работу потоков...");

        //2 task
        Callable<String> myCallable = new MyCallable();
        Callable<String> myCallable1 = new MyCallable();
        Callable<String> myCallable2 = new MyCallable();
        Callable<String> myCallable3 = new MyCallable();
        ExecutorService exec = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep(1000);
                final Future<String> task = exec.submit(myCallable);
                final Future<String> task1 = exec.submit(myCallable1);
                final Future<String> task2 = exec.submit(myCallable2);
                final Future<String> task3 = exec.submit(myCallable3);

                System.out.println(task.get());
                System.out.println(task1.get());
                System.out.println(task2.get());
                System.out.println(task3.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        exec.shutdown();
    }

}
