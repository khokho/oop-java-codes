package seminar15;

import java.util.concurrent.*;

public class experiments {

    private static CountDownLatch latch;
    private static CyclicBarrier cb;
    private static Semaphore sm;
    private static BlockingQueue<Integer> bq;

    public static void main(String[] args) throws InterruptedException {
        latch = new CountDownLatch(10);
        sm = new Semaphore(1);
        bq = new ArrayBlockingQueue<Integer>(10);
        cb = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("okkkkk");

            }
        });
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                try {
                    sm.acquire();
                    sm.acquire();
                    sm.acquire();
                    sm.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    cb.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
            }
        });

        t1.start();
        t2.start();
        Thread.sleep(100);
        for(int i=0; i<10; i++)
            latch.countDown();
        latch.await();
        System.out.println(Thread.currentThread().getName());
    }
}
