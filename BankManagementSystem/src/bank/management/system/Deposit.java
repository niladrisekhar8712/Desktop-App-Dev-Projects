package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    String pinNumber;
    JTextField amount;
    JButton deposit,back;
    Deposit(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to deposit: ");
        text.setBounds(170,300,400,20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,350,320,30);
        amount.setFont(new Font("Arial",Font.BOLD,22));
        image.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(355,485,150,30);
        deposit.setFont(new Font("Arial",Font.BOLD,16));
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.setFont(new Font("Arial",Font.BOLD,16));
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter an amount to deposit");
            }else {
                try{
                    String start = "use bankmanagementsystem";
                    Conn conn = new Conn();
                    conn.s.executeQuery(start);
                    String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Amount Rs. "+number+" deposited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        } else if (actionEvent.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Deposit("");
    }
}
