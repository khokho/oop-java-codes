package seminar14;

public class SemaphoreTest {
    static Semaphore sm;

    public static void main(String[] args) {
        sm = new Semaphore(1);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                sm.acquire();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    sm.release();
                }
                sm.release();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                sm.acquire();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    sm.release();
                }
                sm.release();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sm.acquire();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    sm.release();
                }
                sm.release();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                sm.acquire();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    sm.release();
                }
                sm.release();
            }
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.interrupt();


    }

}
