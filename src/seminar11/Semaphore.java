package seminar11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Semaphore {

    int value = 0;
    ReentrantLock lock;
    Queue<Condition> conditions;
    //
    Semaphore(int limit){
        value = limit;
        lock = new ReentrantLock();
        conditions = new LinkedList<>();
    }

    void acquire(){
        lock.lock();
        if(value > 0){
            value --;
            lock.unlock();
        }
        else {
            Condition current = lock.newCondition();
            conditions.add(current);
            try {
                System.out.println("Waiting: " + Thread.currentThread() + "\n");
                current.await();
            } catch (InterruptedException e) {
                //e.printStackTrace();
                lock.unlock(); //only when interrupted
                System.out.println("I was interrupted:" + Thread.currentThread() + "\n");
                return;
            }

            if(value<=0)
                throw new RuntimeException("This should not happen");
            value --;
            System.out.println("Acquired after wait: " + Thread.currentThread() + "\n");
            lock.unlock();
        }
    }

    void release(){
        lock.lock();
        value++;
        System.out.println("Released by: " + Thread.currentThread() + "\n");
        if(!conditions.isEmpty()) {
            conditions.poll().signal(); // POLL = POP
        }
        lock.unlock();
    }

}
