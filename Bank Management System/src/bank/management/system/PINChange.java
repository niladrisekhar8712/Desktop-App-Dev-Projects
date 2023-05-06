package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PINChange extends JFrame implements ActionListener {
    JButton change,back;
    String pinNumber;
    JPasswordField pinTextField,rePinTextField;
    PINChange(String pinNumber){
        setLayout(null);
        this.pinNumber = pinNumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(255,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,16));
        image.add(text);

        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(175,350,100,35);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("Arial",Font.BOLD,16));
        image.add(pinText);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(350,350,150,25);
        pinTextField.setFont(new Font("Arial",Font.PLAIN,16));
        image.add(pinTextField);

        JLabel rePinText = new JLabel("Re-enter new PIN:");
        rePinText.setBounds(175,400,150,35);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("Arial",Font.BOLD,16));
        image.add(rePinText);

        rePinTextField = new JPasswordField();
        rePinTextField.setBounds(350,400,150,25);
        rePinTextField.setFont(new Font("Arial",Font.PLAIN,16));
        image.add(rePinTextField);

        change = new JButton("Change");
        change.setBounds(333,486,170,30);
        change.setFont(new Font("Arial",Font.BOLD,16));
        change.addActionListener(this);
        image.add(change);

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
        if(actionEvent.getSource()==change){
            try{
                String newPin = pinTextField.getText();
                String newRePin = rePinTextField.getText();

                if(!newPin.equals(newRePin)){
                    JOptionPane.showMessageDialog(null,"Entered PIN does not match");
                    return;
                }
                if(newPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }
                if(newRePin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter PIN");
                    return;
                }

                Conn conn = new Conn();
                String query1 = "update bank set pin = '"+newRePin+"' where pin = '"+pinNumber+"'";
                String query2 = "update login set pin = '"+newRePin+"' where pin = '"+pinNumber+"'";
                String query3 = "update signupthree set PIN = '"+newRePin+"' where pin = '"+pinNumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN changed successfully");
                setVisible(false);
                new Transactions(newRePin).setVisible(true);
            } catch (Exception e){
                System.out.println(e);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PINChange("");
    }
}