package test1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ThreadSafeee {



    public static void main(String[] args) {
        List<String> cl = Collections.synchronizedList(new ArrayList<>());
        cl.add("Hi!");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                if(!cl.isEmpty()){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cl.remove(0);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cl.remove(0);

            }
        });
        t1.start();
        t2.start();


    }
}
