package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class FastCash extends JFrame implements ActionListener {
    String pinNumber;
    JButton rs100, rs500, rs1000, rs2000, rs5000, rs10000, back;
    FastCash(String pinNumber){
        this.pinNumber = pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("Select withdrawal amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);

        rs100 = new JButton("Rs 100");
        rs100.setBounds(172,416,150,30);
        rs100.setFont(new Font("Arial",Font.BOLD,16));
        rs100.addActionListener(this);
        image.add(rs100);

        rs500 = new JButton("Rs 500");
        rs500.setBounds(333,416,170,30);
        rs500.setFont(new Font("Arial",Font.BOLD,16));
        rs500.addActionListener(this);
        image.add(rs500);

        rs5000 = new JButton("Rs 1000");
        rs5000.setBounds(172,451,150,30);
        rs5000.setFont(new Font("Arial",Font.BOLD,16));
        rs5000.addActionListener(this);
        image.add(rs5000);

        rs1000 = new JButton("Rs 2000");
        rs1000.setBounds(333,451,170,30);
        rs1000.setFont(new Font("Arial",Font.BOLD,16));
        rs1000.addActionListener(this);
        image.add(rs1000);

        rs2000 = new JButton("Rs 5000");
        rs2000.setBounds(172,486,150,30);
        rs2000.setFont(new Font("Arial",Font.BOLD,16));
        rs2000.addActionListener(this);
        image.add(rs2000);

        rs10000 = new JButton("Rs 10000");
        rs10000.setBounds(333,486,170,30);
        rs10000.setFont(new Font("Arial",Font.BOLD,16));
        rs10000.addActionListener(this);
        image.add(rs10000);

        back = new JButton("Back");
        back.setBounds(333,521,170,30);
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
        if(actionEvent.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        } else{
            String amount =((JButton) actionEvent.getSource()).getText().substring(3);
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(actionEvent.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,((JButton) actionEvent.getSource()).getText()+" withdraw successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }

        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}