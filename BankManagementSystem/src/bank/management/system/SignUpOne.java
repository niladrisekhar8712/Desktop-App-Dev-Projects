package bank.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SignUpOne extends JFrame implements ActionListener {
    long random;
    JTextField nameField,fathersNameField,emailField,addressField,cityField,stateField,pincodeField;
    JButton next;
    JRadioButton male,female,married,unmarried,other;
    JDateChooser dateChooser;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String formno = "" + random;
        String name = nameField.getText();
        String fathersName = fathersNameField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        } else if(female.isSelected()){
            gender = "Female";
        }
        String email = emailField.getText();
        String maritalStatus = null;
        if(married.isSelected()){
            maritalStatus = "Married";
        } else if(unmarried.isSelected()){
            maritalStatus = "Unmarried";
        }
        else {
            maritalStatus = "Other";
        }
        String address = addressField.getText();
        String city = cityField.getText();
        String state = stateField.getText();
        String pin = pincodeField.getText();
        try{
            if(name == null || fathersName == null ||dob == null ||gender == null ||email == null ||maritalStatus == null ||address == null ||city == null ||state == null ||pin == null){
                JOptionPane.showMessageDialog(null,"Please fill all the required fields before continuing");
            } else {
                Conn c = new Conn();
                String start = "use bankmanagementsystem";
                c.s.executeQuery(start);
                String query = "insert into signup values('"+formno+"', '"+name+"', '"+fathersName+"', '"+dob+"', '"+gender+"', '"+email+"', '"+maritalStatus+"', '"+address+"', '"+city+"', '"+pin+"', '"+state+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    SignUpOne(){
        setLayout(null);
        setTitle("NEW ACCOUNT FORM : PAGE 1");
        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L + 1000L);

        JLabel formNo = new JLabel("APPLICATION FORM NO: "+random);
        formNo.setFont(new Font("Times New Roman",Font.BOLD,38));
        formNo.setBounds(140,20,600,40);
        add(formNo);

        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Arial",Font.BOLD,22));
        personalDetails.setBounds(290,70,300,30);
        add(personalDetails);

        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial",Font.BOLD,18));
        name.setBounds(100,120,100,30);
        add(name);

        nameField = new JTextField();
        nameField.setFont(new Font("Arial",Font.PLAIN,14));
        nameField.setBounds(400,120,350,25);
        add(nameField);

        JLabel fathersName = new JLabel("Father's Name: ");
        fathersName.setFont(new Font("Arial",Font.BOLD,18));
        fathersName.setBounds(100,170,150,30);
        add(fathersName);

        fathersNameField = new JTextField();
        fathersNameField.setFont(new Font("Arial",Font.PLAIN,14));
        fathersNameField.setBounds(400,170,350,25);
        add(fathersNameField);

        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Arial",Font.BOLD,18));
        dob.setBounds(100,220,150,30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(400,220,350,30);
        add(dateChooser);

        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial",Font.BOLD,18));
        gender.setBounds(100,270,150,30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(400,270,75,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(550,270,75,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        ButtonGroup genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(male);
        genderButtonGroup.add(female);

        JLabel email = new JLabel("Email Address: ");
        email.setFont(new Font("Arial",Font.BOLD,18));
        email.setBounds(100,320,150,30);
        add(email);

        emailField = new JTextField();
        emailField.setFont(new Font("Arial",Font.PLAIN,14));
        emailField.setBounds(400,320,350,25);
        add(emailField);

        JLabel maritalStatus = new JLabel("Marital Status: ");
        maritalStatus.setFont(new Font("Arial",Font.BOLD,18));
        maritalStatus.setBounds(100,370,150,30);
        add(maritalStatus);

        married = new JRadioButton("Married");
        married.setBounds(400,370,75,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(550,370,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(680,370,75,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritalButtonGroup = new ButtonGroup();
        maritalButtonGroup.add(married);
        maritalButtonGroup.add(unmarried);
        maritalButtonGroup.add(other);

        JLabel address = new JLabel("Address: ");
        address.setFont(new Font("Arial",Font.BOLD,18));
        address.setBounds(100,420,150,30);
        add(address);

        addressField = new JTextField();
        addressField.setFont(new Font("Arial",Font.PLAIN,14));
        addressField.setBounds(400,420,350,25);
        add(addressField);

        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Arial",Font.BOLD,18));
        city.setBounds(100,470,150,30);
        add(city);

        cityField = new JTextField();
        cityField.setFont(new Font("Arial",Font.PLAIN,14));
        cityField.setBounds(400,470,350,25);
        add(cityField);

        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Arial",Font.BOLD,18));
        state.setBounds(100,520,150,30);
        add(state);

        stateField = new JTextField();
        stateField.setFont(new Font("Arial",Font.PLAIN,14));
        stateField.setBounds(400,520,350,25);
        add(stateField);

        JLabel pincode = new JLabel("Pincode: ");
        pincode.setFont(new Font("Arial",Font.BOLD,18));
        pincode.setBounds(100,570,150,30);
        add(pincode);

        pincodeField = new JTextField();
        pincodeField.setFont(new Font("Arial",Font.PLAIN,14));
        pincodeField.setBounds(400,570,350,25);
        add(pincodeField);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(675,625,75,35);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850,800);
        setLocation(350,10);
        setVisible(true);

    }
    public static void main(String[] args) {
        new SignUpOne();
    }
}