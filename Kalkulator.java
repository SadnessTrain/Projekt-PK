import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kalkulator {
    //notatnik stuff
    private JPanel notatnik;
    private JTextArea t;
    private JButton breset;

    //kalkulator stuff
    private double total;
    private double total2;
    private char znak;

    private JPanel Kalkulator;
    private JTextField pole;
    private JButton b1;
    private JButton b2;
    private JButton b3;
    private JButton b4;
    private JButton b5;
    private JButton b6;
    private JButton b7;
    private JButton b8;
    private JButton b9;
    private JButton b0;
    private JButton bplus;
    private JButton bminus;
    private JButton brazy;
    private JButton bpodzielic;
    private JButton browna;
    private JButton bkropka;
    private JButton bprocent;
    private JButton bclear;
    private JPanel operatory;

    private void getOperator(String btxt){
        znak = btxt.charAt(0);
        total = total + Double.parseDouble(pole.getText( ));
        pole.setText("");
    }

    public Kalkulator() {
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b1txt = pole.getText() + b1.getText();
                pole.setText(b1txt);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b2txt = pole.getText() + b2.getText();
                pole.setText(b2txt);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b3txt = pole.getText() + b3.getText();
                pole.setText(b3txt);
            }
        });
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b4txt = pole.getText() + b4.getText();
                pole.setText(b4txt);
            }
        });
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b5txt = pole.getText() + b5.getText();
                pole.setText(b5txt);
            }
        });
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b6txt = pole.getText() + b6.getText();
                pole.setText(b6txt);
            }
        });
        b7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b7txt = pole.getText() + b7.getText();
                pole.setText(b7txt);
            }
        });
        b8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b8txt = pole.getText() + b8.getText();
                pole.setText(b8txt);
            }
        });
        b9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b9txt = pole.getText() + b9.getText();
                pole.setText(b9txt);
            }
        });
        b0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b0txt = pole.getText() + b0.getText();
                pole.setText(b0txt);
            }
        });
        bkropka.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bkropkatxt = pole.getText() + bkropka.getText();
                pole.setText(bkropkatxt);
            }
        });
        bplus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bplustxt = bplus.getText();
                getOperator(bplustxt);
            }
        });
        bminus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bminustxt = bminus.getText();
                getOperator(bminustxt);
            }
        });
        brazy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String brazytxt = brazy.getText();
                getOperator(brazytxt);
            }
        });
        bpodzielic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bpodzielictxt = bpodzielic.getText();
                getOperator(bpodzielictxt);
            }
        });
        bprocent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bprocenttxt = bprocent.getText();
                getOperator(bprocenttxt);
            }
        });
        browna.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (znak) {
                    case '+':
                        total2 = total + Double.parseDouble(pole.getText());
                        break;
                    case '-':
                        total2 = total - Double.parseDouble(pole.getText());
                        break;
                    case 'x':
                        total2 = total * Double.parseDouble(pole.getText());
                        break;
                    case '÷':
                        total2 = total / Double.parseDouble(pole.getText());
                        break;
                    case '%':
                        total2 = (total * Double.parseDouble(pole.getText()))/100;
                        break;
                }
                pole.setText( Double.toString(total2) );
                total = 0;

            }
        });
        bclear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                total2 = 0;
                pole.setText("");
            }
        });
        breset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculator++");
        frame.setContentPane(new Kalkulator().Kalkulator);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}