package conway;

import javax.swing.*;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Conway {

    boolean running = false;

    public int getSize() {
        return size;
    }

    public void setListener(JPanel listener) {
        this.listener = listener;
    }

    JPanel listener = null;

    int size;
    public boolean[][] grid;
    private boolean[][] updated;
    CyclicBarrier waiter;

    public Conway(int size) {
        this.size = size;
        grid = new boolean[size][size];
        updated = new boolean[size][size];
        waiter = new CyclicBarrier(size * size, new Runnable() {
            @Override
            public void run() {
                boolean[][] tmp = grid;
                grid = updated;
                updated = tmp;
                if(listener != null)
                    listener.repaint();
                else {
                    System.out.println("new iteration:");
                    System.out.println(Conway.this.toString());
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < size; i++){
            for (int j = 0; j < size; j++) {
                if (grid[i][j])
                    sb.append("X");
                else
                    sb.append("o");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void set(int x, int y, boolean v){
        grid[x][y]=v;
        if(listener != null)
            listener.repaint();
    }

    public boolean get(int x,int y){
        return grid[x][y];
    }


    public void start(){
        if(!running) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    Spot sp = new Spot(i, j);
                    sp.start();
                }
            }

            running = true;
        }
        else {
            waiter.reset();
            running = false;
        }
    }

    private boolean inBounds(int x,int y){
        return 0<=x&&x<size&&0<=y&&y<size;
    }

    private class Spot extends Thread{
        private int x;
        private int y;

        public Spot(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public void run() {
            super.run();
            while(true) {
                int cnt = 0;
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0) continue;
                        if (inBounds(x + i, y + j) && grid[x + i][y + j])
                            cnt++;
                    }
                }
                if (grid[x][y])
                    updated[x][y] = cnt == 2 || cnt == 3;
                else
                    updated[x][y] = cnt == 3;
                try {
                    waiter.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    return;
                }
            }
        }
    }


}
