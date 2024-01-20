package diningphilosopher;

import java.util.concurrent.Semaphore;

public class Philosopher implements Runnable{

    int index;
    private Semaphore leftFork;
    private Semaphore rightFork;

    public Philosopher(int index, Semaphore leftFork, Semaphore rightFork) {
        this.index = index;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run(){
        try {
            while(true){
                if(index == 4){
                    System.out.println("Before acquiring right semaphore for Philosopher:- " + index);
                    rightFork.acquire();
                    System.out.println("Before acquiring left semaphore for Philosopher:- " + index);
                    leftFork.acquire();
                }
                else{
                    System.out.println("Before acquiring left semaphore for Philosopher:- " + index);
                    leftFork.acquire();
                    System.out.println("Before acquiring right semaphore for Philosopher:- " + index);
                    rightFork.acquire();
                }
                System.out.println("Inside semaphore for Philosopher:- " + index);
                leftFork.release();
                System.out.println("After releasing left semaphore for Philosopher:- " + index);
                rightFork.release();
                System.out.println("After releasing right semaphore for Philosopher:- " + index);
            }
        } catch (Exception e){

        }
    }
}
