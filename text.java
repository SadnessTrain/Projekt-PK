package notepad;

import java.awt.event.*;

import javax.swing.*;
class text extends JFrame implements ActionListener {
    static JFrame f;
    static JTextField t;
    static JButton b;
    
    
    public static void main(String[] args)
    {
        f = new JFrame("Notepad");
        b = new JButton("Reset");
  
        text x = new text();
        b.addActionListener(x);
        t = new JTextField(16);

        JPanel p = new JPanel();

        p.add(t);
        p.add(b);
  
        f.add(p);
        f.setSize(300, 300);
        f.show();
    }
  
    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Reset")) {
            t.setText("  ");
        }
    }
}