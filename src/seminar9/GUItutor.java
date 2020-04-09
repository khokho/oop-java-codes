package seminar9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUItutor extends JFrame {

    private JTextField tf = new JTextField("salami", 30);

    public GUItutor(){
        setVisible(true);
        setSize(400,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();

        MenuBar menubar = new MenuBar();
        Menu menu = new Menu("Menu");
        MenuItem item = new MenuItem("item");
        menu.add(item);
        item.addActionListener(actionEvent -> tf.setText("new saliami"));
        JButton btn = new JButton("button");
        btn.addActionListener(actionEvent -> tf.setText("button saliami"));

        panel.add(tf);
        panel.add(btn);

        setMenuBar(menubar);
        menubar.add(menu);

        add(panel);

    }



}