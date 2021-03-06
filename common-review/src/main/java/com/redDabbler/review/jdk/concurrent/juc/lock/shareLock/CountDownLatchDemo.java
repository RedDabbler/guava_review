package com.redDabbler.review.jdk.concurrent.juc.lock.shareLock;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatch是通过“共享锁”实现的。
 * CountDownLatch一般用于某个线程A等待若干个其他线程执行完任务之后，它才执行；
 * 在创建CountDownLatch中时，会传递一个int类型参数count，
 * 该参数是“锁计数器”的初始状态，表示该“共享锁”最多能被count给线程同时获取。
 * 当某线程调用该CountDownLatch对象的await()方法时，该线程会等待“共享锁”可用时，
 * 才能获取“共享锁”进而继续运行。而“共享锁”可用的条件，就是“锁计数器”的值为0！
 * 而“锁计数器”的初始值为count，每当一个线程调用该CountDownLatch对象的countDown()方法时，
 * 才将“锁计数器”-1；通过这种方式，
 * 必须有count个线程调用countDown()之后，“锁计数器”才为0，而前面提到的等待线程才能继续运行！
 *
 *
 *
 * void await()
 */
public class CountDownLatchDemo {

    private static int latch_size = 5;
    static CountDownLatch countDownLatch;

    public static void main(String[]args){
        countDownLatch = new CountDownLatch(latch_size);
        try{
            for (int i = 0;i<latch_size;i++){
                new InnerThread().start();
            }
            System.out.println("main await begin");
            countDownLatch.await();
            System.out.println("main await finished.");
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    static class InnerThread extends Thread{

        public void run(){
            try{
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+"  1000 ms");
                countDownLatch.countDown();
            } catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
