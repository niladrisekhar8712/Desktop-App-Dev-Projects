package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpTwo extends JFrame implements ActionListener {
    JTextField nameField, fathersNameField, emailField, pan, aadhar, stateField, pincodeField;
    JButton next;
    JRadioButton syes, sno, eno,eyes;
    JComboBox religion,categoryField,incomeField,education,occupation;
    String formno;
    SignUpTwo(String formno) {
        this.formno = formno;
        setLayout(null);
        setTitle("NEW ACCOUNT FORM : PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Arial", Font.BOLD, 22));
        additionalDetails.setBounds(290, 70, 300, 30);
        add(additionalDetails);

        JLabel name = new JLabel("Religion: ");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(100, 120, 100, 30);
        add(name);

        String[] validRel = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox<>(validRel);
        religion.setBounds(400, 120, 350, 25);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fathersName = new JLabel("Category: ");
        fathersName.setFont(new Font("Arial", Font.BOLD, 18));
        fathersName.setBounds(100, 170, 150, 30);
        add(fathersName);

        String[] validCategory = {"General","OBC-A","OBC-B","SC","ST","PwD"};
        categoryField = new JComboBox<>(validCategory);
        categoryField.setBounds(400, 170, 350, 25);
        categoryField.setBackground(Color.WHITE);
        add(categoryField);

        JLabel dob = new JLabel("Income: ");
        dob.setFont(new Font("Arial", Font.BOLD, 18));
        dob.setBounds(100, 220, 150, 30);
        add(dob);

        String[] validIncome = {"Null","<1,50,000","<2,50,000","<5,00,000","<10,00,000",">10,00,000"};
        incomeField = new JComboBox<>(validIncome);
        incomeField.setBounds(400, 220, 350, 25);
        incomeField.setBackground(Color.WHITE);
        add(incomeField);

        JLabel gender = new JLabel("Educational: ");
        gender.setFont(new Font("Arial", Font.BOLD, 18));
        gender.setBounds(100, 270, 150, 30);
        add(gender);

        JLabel email = new JLabel("Qualification: ");
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setBounds(100, 305, 150, 30);
        add(email);

        String[] validEdu = {"Non-Graduate","Graduate","Post Graduate","Doctorate","Other"};
        education = new JComboBox<>(validEdu);
        education.setBounds(400, 305, 350, 25);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel maritalStatus = new JLabel("Occupation: ");
        maritalStatus.setFont(new Font("Arial", Font.BOLD, 18));
        maritalStatus.setBounds(100, 370, 150, 30);
        add(maritalStatus);

        String[] validOccupation = {"Salaried","Self-Employed","Businessman","Student","Retired","Other"};
        occupation = new JComboBox<>(validOccupation);
        occupation.setBounds(400, 370, 350, 25);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN No: ");
        address.setFont(new Font("Arial", Font.BOLD, 18));
        address.setBounds(100, 420, 150, 30);
        add(address);

        pan = new JTextField();
        pan.setFont(new Font("Arial", Font.PLAIN, 14));
        pan.setBounds(400, 420, 350, 25);
        add(pan);

        JLabel city = new JLabel("Aadhar No: ");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setBounds(100, 470, 150, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Arial", Font.PLAIN, 14));
        aadhar.setBounds(400, 470, 350, 25);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen: ");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setBounds(100, 520, 150, 30);
        add(state);

        syes = new JRadioButton("Yes");
        syes.setBounds(400,520,75,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(550,520,75,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup seniorButtonGroup = new ButtonGroup();
        seniorButtonGroup.add(syes);
        seniorButtonGroup.add(sno);

        JLabel pincode = new JLabel("Existing Account: ");
        pincode.setFont(new Font("Arial", Font.BOLD, 18));
        pincode.setBounds(100, 570, 180, 30);
        add(pincode);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(400,570,75,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(550,570,75,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup accountButtonGroup = new ButtonGroup();
        accountButtonGroup.add(eyes);
        accountButtonGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(675, 625, 75, 35);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String religionVal = (String) religion.getSelectedItem();
        String categoryVal = (String) categoryField.getSelectedItem();
        String incomeVal = (String) incomeField.getSelectedItem();
        String educationVal = (String) education.getSelectedItem();
        String occupationVal = (String) occupation.getSelectedItem();
        String seniorCitizen = null;
        if (syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorCitizen = "No";
        }
        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }
        String panVal = pan.getText();
        String aadharVal = aadhar.getText();
        try {
            if (religionVal == null||categoryVal == null||incomeVal == null||educationVal == null||occupationVal == null||seniorCitizen == null||existingAccount == null||panVal == null||aadharVal == null) {
                JOptionPane.showMessageDialog(null, "Please fill all the required fields before continuing");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values('" + formno + "', '" + religionVal + "', '" + categoryVal + "', '" + incomeVal + "', '" + educationVal + "', '" + occupationVal + "', '" + panVal + "', '" + aadharVal + "', '" + seniorCitizen+ "', '" + existingAccount + "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignUpTwo("");
    }
}