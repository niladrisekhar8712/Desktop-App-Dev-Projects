package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton signIn,signUp,clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image image = imageIcon.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(image);

        JLabel jLabel = new JLabel(i3);
        jLabel.setBounds(70,10,100,100);
        add(jLabel);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setBounds(200,40,700,40);
        text.setFont(new Font("Oswald",Font.BOLD,38));
        add(text);

        JLabel cardno = new JLabel("Card No: ");
        cardno.setBounds(120,140,150,40);
        cardno.setFont(new Font("Raleway",Font.PLAIN,30));
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300,147,230,30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN: ");
        pin.setBounds(120,210,200,40);
        pin.setFont(new Font("Raleway",Font.PLAIN,30));
        add(pin);

        pinTextField = new JPasswordField();
        pinTextField.setBounds(300,217,230,30);
        add(pinTextField);

        signIn = new JButton("SIGN IN");
        signIn.setBounds(300,300,100,30);
        signIn.setBackground(Color.BLUE);
        signIn.setForeground(Color.WHITE);
        signIn.setFont(new Font("Raleway",Font.PLAIN,15));
        signIn.addActionListener(this);
        add(signIn);

        clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLUE);
        clear.setForeground(Color.WHITE);
        clear.setFont(new Font("Raleway",Font.PLAIN,15));
        clear.addActionListener(this);
        add(clear);

        signUp = new JButton("SIGN UP");
        signUp.setBounds(300,350,230,30);
        signUp.setBackground(Color.BLUE);
        signUp.setForeground(Color.WHITE);
        signUp.setFont(new Font("Raleway",Font.PLAIN,15));
        signUp.addActionListener(this);
        add(signUp);

        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
        setTitle("Automated Teller Machine");
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (actionEvent.getSource() == signIn) {
            Conn conn = new Conn();
            String cardNo = cardTextField.getText();
            String pinNo = pinTextField.getText();
            String query = "select * from login where cardNumber = '"+cardNo+"' and pin = '"+pinNo+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinNo).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
        } else if (actionEvent.getSource() == signUp) {
            setVisible(false);
            SignUpOne signUpOne = new SignUpOne();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}