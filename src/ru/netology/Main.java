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


    }

}
