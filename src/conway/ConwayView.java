package conway;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ConcurrentModificationException;
import java.util.Random;

public class ConwayView {

    private static class GameBoard extends JPanel implements MouseListener, KeyListener {
        private static final int BLOCK_SIZE = 20;
        Conway cw;

        public GameBoard(Conway cw) {
            this.cw = cw;
            setPreferredSize(new Dimension(BLOCK_SIZE*cw.getSize(), BLOCK_SIZE*cw.getSize()));
            this.setBorder(new EmptyBorder(new Insets(0,0,0,0)));
            addMouseListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(int i=0; i<cw.getSize(); i++){
                for(int j=0; j<cw.getSize(); j++) {
                    if(cw.get(i,j))
                        g.setColor(Color.BLUE);
                    else
                        g.setColor(Color.WHITE);
                    g.fillRect((BLOCK_SIZE*i), (BLOCK_SIZE*j), BLOCK_SIZE, BLOCK_SIZE);
                }
            }
        }

        private void changePoint(MouseEvent me){
            int x = me.getPoint().x/BLOCK_SIZE;
            int y = me.getPoint().y/BLOCK_SIZE;
            System.out.println(x+", "+y);
            cw.set(x,y,!cw.get(x,y));
        }

        @Override
        public void mouseClicked(MouseEvent mouseEvent) {
            changePoint(mouseEvent);

        }

        @Override
        public void mousePressed(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseReleased(MouseEvent mouseEvent) {
        }

        @Override
        public void mouseEntered(MouseEvent mouseEvent) {

        }

        @Override
        public void mouseExited(MouseEvent mouseEvent) {

        }

        @Override
        public void keyTyped(KeyEvent keyEvent) {

        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {

        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            System.out.println(keyEvent.getKeyChar());
            if(keyEvent.getKeyChar()==' ')
                cw.start();
        }
    }

    public static void main(String[] args) {
        int size = 40;
        Conway cw = new Conway(size);
        Random rd = new Random();
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                cw.set(i,j,rd.nextBoolean());
            }
        }
        JFrame frm = new JFrame();
        GameBoard gb = new GameBoard(cw);
        frm.add(gb);
        frm.pack();
        frm.setVisible(true);
        frm.addKeyListener(gb);
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cw.setListener(gb);
        //cw.start();
    }



}
