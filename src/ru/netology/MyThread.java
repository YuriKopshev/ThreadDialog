package ru.netology;


public class MyThread extends Thread {

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                Thread.sleep(2000);
                System.out.println("Я поток " + getName() + ". Всем привет!");
            }
        } catch (InterruptedException e) {
            return;


        } finally {
            System.out.printf("%s завершен \n", getName());
        }
    }
}

