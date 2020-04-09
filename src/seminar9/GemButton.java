package seminar9;

import javax.swing.*;
import java.awt.*;

public class GemButton extends JButton{

    static private String modify(String s){
        s+="wow";
        return s;
    }

    public GemButton(String s){
        super(modify(s));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
    }

}

