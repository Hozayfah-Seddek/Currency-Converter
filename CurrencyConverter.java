import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CurrencyConverter extends JFrame implements ActionListener {
    String cs[] = { "USD", "EUR", "SAR", "GBP", "SYP", "TRY", "RUB" };
    JButton b;
    JComboBox<String> c = new JComboBox<>(cs);
    JComboBox<String> c2 = new JComboBox<>(cs);
    JTextField t, t2;
    JLabel l, l1, l2;
    String ic = "";

    CurrencyConverter() {
        this.setSize(800, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Currency Converter");
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\\\Codding\\\\Side-Projects\\\\Currency converter\\\\ic.png");
        this.setIconImage(icon);
        this.setResizable(false);
        this.setLayout(null); // Set layout to null for absolute positioning

        l = new JLabel("Enter the money amount");
        this.add(l);
        l.setBounds(100, 100, 500, 50);

        t = new JTextField();
        t.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        this.add(t);
        t.setBounds(100, 150, 500, 50);

        l1 = new JLabel("From");
        l1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        this.add(l1);
        l1.setBounds(150, 250, 100, 50);

        c.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c.setSelectedIndex(0);
        this.add(c);
        c.setBounds(400, 250, 100, 50);

        l2 = new JLabel("To");
        l2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        this.add(l2);
        l2.setBounds(350, 250, 100, 50);

        c2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        c2.setSelectedIndex(0);
        this.add(c2);
        c2.setBounds(230, 250, 100, 50);

        b = new JButton("Convert");
        this.add(b);
        b.addActionListener(this);
        b.setFocusable(false);
        b.setBounds(250, 500, 170, 50);
        b.setBackground(new Color(34, 231, 96));

        t2 = new JTextField();
        t2.setBackground(Color.gray);
        t2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        t2.setForeground(Color.white);
        t2.setEditable(false);
        this.add(t2);
        t2.setBounds(100, 400, 500, 50);

        this.setVisible(true); // Call setVisible(true) after adding all components
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b) {
            try {
                double amount = Double.parseDouble(t.getText());
                String from = (String) c.getSelectedItem();
                String to = (String) c2.getSelectedItem();
                switch (from) {
                    case "SAR":
                        amount *= 3.75;
                        ic = "﷼";
                        break;

                    case "EUR":
                        amount *= 0.91;
                        ic = "€";
                        break;

                    case "GBP":
                        amount *= 0.77;
                        ic = "£";
                        break;

                    case "RUB":
                        amount *= 95.68;
                        ic = "₽";
                        break;

                    case "TRY":
                        amount *= 34.31;
                        ic = "₺";
                        break;

                    case "SYP":
                        amount *= 14750;
                        ic = "£";
                        break;

                    default:
                        amount *= 1;
                        ic = "$";
                        break;
                }
            

                switch (to) {
                    case "SAR":
                        amount /= 3.75;
                        break;

                    case "EUR":
                        amount /= 0.91;
                        break;

                    case "GBP":
                        amount /= 0.77;
                        break;

                    case "RUB":
                        amount /= 95.68;
                        break;

                    case "TRY":
                        amount /= 34.31;
                        break;

                    case "SYP":
                        amount /= 14750;
                        break;

                    default:
                        amount *= 1;
                        break;
                }
                t2.setText(String.valueOf(amount) + ic);
            } catch (NumberFormatException ex) {
                t2.setText("Invalid input!");
            }
        }
    }
}