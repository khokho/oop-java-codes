package seminar14_2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OurDS {

    int limit;
    int count;
    Object[] storage;
    Lock lock;
    Condition newWaiter;
    Condition spaceWaiter;

    OurDS(int limit){
        this.limit = limit;
        count = 0;
        storage = new Object[limit];
        lock = new ReentrantLock();
        newWaiter = lock.newCondition();
        spaceWaiter = lock.newCondition();
    }

    public void put(Object obj)  {
        lock.lock();
        if(count == limit){
            try {
                spaceWaiter.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
                return;
            }
        }
        storage[count]=obj;
        count++;
        newWaiter.signal();
        lock.unlock();
    }

    public Object get()  {
        lock.lock();
        if(count == 0){
            try {
                newWaiter.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
                lock.unlock();
                return null;
            }
        }

        Object ret = storage[count-1];
        count -- ;
        spaceWaiter.signal();
        lock.unlock();
        return ret;
    }

}
