package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;


    SignUpThree(String formno){
        this.formno = formno;
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(290, 50, 300, 30);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway",Font.BOLD,22));
        type.setBounds(90, 100, 300, 30);
        add(type);

        r1 = new JRadioButton("Savings Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(90,150,200,20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(310,150,200,20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(90,200,200,20);
        add(r3);

        r4 = new JRadioButton("Recurring Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(310,200,200,25);
        add(r4);

        ButtonGroup accountType = new ButtonGroup();
        accountType.add(r1);
        accountType.add(r2);
        accountType.add(r3);
        accountType.add(r4);

        JLabel cardNo = new JLabel("Card Number");
        cardNo.setFont(new Font("Raleway",Font.BOLD,22));
        cardNo.setBounds(90, 300, 150, 25);
        add(cardNo);

        JLabel cardNoDescription = new JLabel("Your 16 digit card number");
        cardNoDescription.setFont(new Font("Raleway",Font.PLAIN,12));
        cardNoDescription.setBounds(90, 330, 150, 12);
        add(cardNoDescription);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(300, 300, 300, 30);
        add(number);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(90, 360, 150, 30);
        add(pin);

        JLabel pinDescription = new JLabel("Your 4 digit PIN");
        pinDescription.setFont(new Font("Raleway",Font.PLAIN,12));
        pinDescription.setBounds(90, 395, 150, 12);
        add(pinDescription);

        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Raleway",Font.BOLD,22));
        pinNumber.setBounds(300, 360, 300, 30);
        add(pinNumber);

        JLabel servicesRequired = new JLabel("Services Required");
        servicesRequired.setFont(new Font("Raleway",Font.BOLD,22));
        servicesRequired.setBounds(90, 450, 200, 25);
        add(servicesRequired);

        c1 = new JCheckBox("ATM Card");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(90,490,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(320,490,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(540,490,200,30);
        add(c3);

        c4 = new JCheckBox("E-Mail & SMS Alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(90,540,200,30);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(320,540,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statements");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(540,540,200,30);
        add(c6);

        c7 = new JCheckBox("I, hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(90,580,800,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(675,625,125,35);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(530,625,125,35);
        cancel.addActionListener(this);
        add(cancel);

        setLayout(null);
        setVisible(true);
        setTitle("NEW ACCOUNT FORM : PAGE 3");
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Savings Account";
            } else if (r2.isSelected()) {
                accountType = "FD Account";
            } else if (r3.isSelected()) {
                accountType = "Current Account";
            } else if (r4.isSelected()) {
                accountType = "Recurring Account";
            }

            Random random = new Random();
            String cardNumber = "" +Math.abs(random.nextLong()%90000000L + 5040936000000000L);
            String pinNumber = "" + Math.abs(random.nextLong()%9000L+1000L);
            String services = "";
            if(c1.isSelected()){
                services = services + "ATM Card ";
            }
            if(c2.isSelected()){
                services = services + "Internet Banking ";
            }
            if(c3.isSelected()){
                services = services + "Mobile Banking ";
            }
            if(c4.isSelected()){
                services = services + "E-Mail & SMS Alerts ";
            }
            if(c5.isSelected()){
                services = services + "Cheque Book ";
            }
            if(c6.isSelected()){
                services = services + "E-Statements";
            }
            try {
                if (accountType == null||services == null || !c7.isSelected()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the required fields before submission");
                } else {
                    Conn c = new Conn();
                    String query1 = "insert into signupthree values('" + formno + "', '" + accountType + "', '" + cardNumber + "', '" + pinNumber + "', '" + services + "')";
                    String query2 = "insert into login values('" + formno + "', '" + cardNumber + "', '" + pinNumber + "')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"CardNumber: "+cardNumber+"\nPIN: "+pinNumber);
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        } else if (actionEvent.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new SignUpThree("");
    }
}
