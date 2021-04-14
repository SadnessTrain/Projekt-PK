import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class Kalkulator {

    private static DecimalFormat df = new DecimalFormat("0.00");
    private JPanel gui;
    //notatnik stuff
    private JPanel notatnik;
    private JTextArea t;
    private JButton breset;

    //waluty stuff
    private double fundusze = 100;         //starting money
    private int posiadaneusd = 0;
    private int posiadaneeur = 0;
    private int posiadanegbp = 0;
    private double usd=3.84;
    private double eur=4.56;
    private double gbp=5.24;
    private JPanel waluty;
    private JTextField Fundusze;
    //usd
    private JTextField usdTfield;
    private JButton usdsell10Button;
    private JButton usdbuy10Button;
    private JButton usdbuy1Button;
    private JButton usdsell1Button;
    private JTextField usdposiadaneTfield;
    //eur
    private JTextField eurTfield;
    private JButton eursell10Button;
    private JButton eurbuy10Button;
    private JButton eurbuy1Button;
    private JButton eursell1Button;
    private JTextField eurposiadaneTfield;
    //gbp
    private JTextField gbpTfield;
    private JButton gbpsell10Button;
    private JButton gbpbuy10Button;
    private JButton gbpbuy1Button;
    private JButton gbpsell1Button;
    private JTextField gbpposiadaneTfield;


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

    //hasło stuff
    private JLabel title;
    private JPasswordField haslo;
    private JPanel passwordscreen;
    private JButton blogin;
    private JLabel wrong;
    private JScrollPane tscroll;
    private JTextArea byAgnieszkaLechSzymonTextArea;

    private void getOperator(String btxt){
        znak = btxt.charAt(0);
        total = total + Double.parseDouble(pole.getText( ));
        pole.setText("");
    }

    public Kalkulator() {
        //panel z hasłem i przycisk logowania
        Kalkulator.setVisible(false);
        wrong.setVisible(false);
        t.setLineWrap(true);
        blogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                char[] password = haslo.getPassword();
                char[] correctPass = new char[] {'h','a','s','ł','o','t','e','s','t','1','2','3'};

                if (Arrays.equals(password, correctPass)) {
                    passwordscreen.setVisible(false);
                    Kalkulator.setVisible(true);
                }else{
                    wrong.setVisible(true);
                }
            }
        });
        //przycisk notatnika
        breset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                t.setText("");
            }
        });
        //waluty
        //usd
        String u = String.valueOf(usd);
        usdTfield.setText("Kurs USD: "+ u);
        //eur
        String e = String.valueOf(eur);
        eurTfield.setText("Kurs EUR: "+ e);
        //gbp
        String g = String.valueOf(gbp);
        gbpTfield.setText("Kurs GBP: "+ g);
        Fundusze.setText("Posiadane fundusze: " + fundusze);
        Fundusze.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        usdposiadaneTfield.setText("Posiadane USD: " + posiadaneusd);
        usdposiadaneTfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        eurposiadaneTfield.setText("Posiadane EUR: " + posiadaneeur);
        eurposiadaneTfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        gbpposiadaneTfield.setText("Posiadane GBP: " + posiadanegbp);
        gbpposiadaneTfield.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        doWork();

        //action listenery walut
        //buy1
        usdbuy1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fundusze > usd) {
                    fundusze = fundusze - usd;
                    posiadaneusd = posiadaneusd + 1;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    usdposiadaneTfield.setText("Posiadane USD: " + posiadaneusd);
                }
            }
        });
        eurbuy1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fundusze > eur) {
                    fundusze = fundusze - eur;
                    posiadaneeur = posiadaneeur + 1;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    eurposiadaneTfield.setText("Posiadane EUR: " + posiadaneeur);
                }
            }
        });
        gbpbuy1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fundusze>gbp){
                    fundusze = fundusze - gbp;
                    posiadanegbp = posiadanegbp + 1;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    gbpposiadaneTfield.setText("Posiadane GBP: " + posiadanegbp);
                }
            }
        });
        //buy10
        usdbuy10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fundusze > 10*usd) {
                    fundusze = fundusze - 10*usd;
                    posiadaneusd = posiadaneusd + 10;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    usdposiadaneTfield.setText("Posiadane USD: " + posiadaneusd);
                }
            }
        });
        eurbuy10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fundusze > 10*eur) {
                    fundusze = fundusze - 10*eur;
                    posiadaneeur = posiadaneeur + 10;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    eurposiadaneTfield.setText("Posiadane EUR: " + posiadaneeur);
                }
            }
        });
        gbpbuy10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fundusze > 10*gbp){
                    fundusze = fundusze - 10*gbp;
                    posiadanegbp = posiadanegbp + 10;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    gbpposiadaneTfield.setText("Posiadane GBP: " + posiadanegbp);
                }
            }
        });
        //sell1
        usdsell1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posiadaneusd > 0) {
                    posiadaneusd = posiadaneusd - 1;
                    fundusze = fundusze + usd;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    usdposiadaneTfield.setText("Posiadane USD: " + posiadaneusd);
                }
            }
        });
        eursell1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posiadaneeur > 0) {
                    posiadaneeur = posiadaneeur - 1;
                    fundusze = fundusze + eur;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    eurposiadaneTfield.setText("Posiadane EUR: " + posiadaneeur);
                }
            }
        });
        gbpsell1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posiadanegbp > 0) {
                    posiadanegbp = posiadanegbp - 1;
                    fundusze = fundusze + gbp;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    gbpposiadaneTfield.setText("Posiadane GBP: " + posiadanegbp);
                }
            }
        });
        //sell10
        usdsell10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posiadaneusd > 9) {
                    posiadaneusd = posiadaneusd - 10;
                    fundusze = fundusze + 10*usd;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    usdposiadaneTfield.setText("Posiadane USD: " + posiadaneusd);
                }
            }
        });
        eursell10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posiadaneeur > 9) {
                    posiadaneeur = posiadaneeur - 10;
                    fundusze = fundusze + 10*eur;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    eurposiadaneTfield.setText("Posiadane EUR: " + posiadaneeur);
                }
            }
        });
        gbpsell10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (posiadanegbp > 9) {
                    posiadanegbp = posiadanegbp - 10;
                    fundusze = fundusze + 10*gbp;
                    Fundusze.setText("Posiadane fundusze: " + df.format(fundusze));
                    gbpposiadaneTfield.setText("Posiadane GBP: " + posiadanegbp);
                }
            }
        });

        //action listenery kalkulatora
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String b1txt = pole.getText() + b1.getText();
                pole.setText(b1txt);
                notatnik.setVisible(false);
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
    }
    protected void doWork() {
        SwingWorker<Void, Integer> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
                while(true) {
                    Random r = new Random();
                    double random = 0.1 + r.nextDouble() * (5 - 1);


                    if (Math.random() > 0.5) {
                        usd = usd + random;
                        usdTfield.setText("Kurs USD: "+ df.format(usd));
                        Thread.sleep(5000);
                    } else {
                        usd = usd - random;
                        usdTfield.setText("Kurs USD: "+ df.format(usd));
                        Thread.sleep(5000);
                    }
                    if (Math.random() > 0.5) {
                        eur = eur + random;
                        eurTfield.setText("Kurs EUR: "+ df.format(eur));
                        Thread.sleep(5000);
                    } else {
                        eur = eur - random;
                        eurTfield.setText("Kurs EUR: "+ df.format(eur));
                        Thread.sleep(5000);
                    }
                    if (Math.random() > 0.5) {
                        gbp = gbp + random;
                        gbpTfield.setText("Kurs GBP: "+ df.format(gbp));
                        Thread.sleep(5000);
                    } else {
                        gbp = gbp - random;
                        gbpTfield.setText("Kurs GBP: "+ df.format(gbp));
                        Thread.sleep(5000);
                    }

                }
            }
        };
        worker.execute();
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Calculator++");
        frame.setContentPane(new Kalkulator().gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}