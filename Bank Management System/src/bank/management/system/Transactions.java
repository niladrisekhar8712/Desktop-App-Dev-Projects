package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    String pinNumber;
    JButton deposit,cashWithdrawal,miniStatement,changePIN,fastCash,balanceEnquiry,exit;
    Transactions(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(172,416,150,30);
        deposit.setFont(new Font("Arial",Font.BOLD,16));
        deposit.addActionListener(this);
        image.add(deposit);

        cashWithdrawal = new JButton("Cash Withdrawal");
        cashWithdrawal.setBounds(333,416,170,30);
        cashWithdrawal.setFont(new Font("Arial",Font.BOLD,16));
        cashWithdrawal.addActionListener(this);
        image.add(cashWithdrawal);

        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(172,451,150,30);
        fastCash.setFont(new Font("Arial",Font.BOLD,16));
        fastCash.addActionListener(this);
        image.add(fastCash);

        miniStatement = new JButton("Mini Statement");
        miniStatement.setBounds(333,451,170,30);
        miniStatement.setFont(new Font("Arial",Font.BOLD,16));
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        changePIN = new JButton("Change PIN");
        changePIN.setBounds(172,486,150,30);
        changePIN.setFont(new Font("Arial",Font.BOLD,16));
        changePIN.addActionListener(this);
        image.add(changePIN);

        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(333,486,170,30);
        balanceEnquiry.setFont(new Font("Arial",Font.BOLD,16));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("Exit");
        exit.setBounds(333,521,170,30);
        exit.setFont(new Font("Arial",Font.BOLD,16));
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == exit){
            System.exit(0);
        } else if (actionEvent.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if(actionEvent.getSource() == cashWithdrawal){
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        } else if (actionEvent.getSource()==fastCash) {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        } else if (actionEvent.getSource()==changePIN) {
            setVisible(false);
            new PINChange(pinNumber).setVisible(true);
        } else if (actionEvent.getSource()==balanceEnquiry){
            setVisible(false);
            new BalanceEnquiry(pinNumber).setVisible(true);
        } else if (actionEvent.getSource() == miniStatement) {
            new MiniStatement(pinNumber).setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Transactions("");
    }
}