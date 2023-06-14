import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame implements ActionListener {
    JLabel image;
    JButton convert;
    JComboBox<String> fromTF,toTF;
    JTextField sourceTF,targetTF;
    public Frame(){
        setTitle("Temperature Converter");
        setLocation(300,100);
        setSize(800,700);
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\bg1.jpg"));
        Image i2 = i1.getImage().getScaledInstance(800,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
        image.setBounds(0,0,800,700);
        add(image);

        JLabel title = new JLabel("TEMPERATURE CONVERTER");
        title.setBounds(180,75,500,40);
        title.setFont(new Font("Segoe UI",Font.BOLD,30));
        image.add(title);

        JLabel from = new JLabel("From");
        from.setBounds(100,200,75,30);
        from.setFont(new Font("Segoe UI",1,22));
        image.add(from);

        String[] scales = {"Celsius","Fahrenheit","Kelvin","Rømer"};
        fromTF = new JComboBox<>(scales);
        fromTF.setBounds(500,200,175,30);
        fromTF.setFont(new Font("Segoe UI",0,18));
        fromTF.setBackground(Color.WHITE);
        image.add(fromTF);

        sourceTF = new JTextField();
        sourceTF.setBounds(300,200,175,30);
        image.add(sourceTF);

        JLabel to = new JLabel("To");
        to.setBounds(100,400,75,30);
        to.setFont(new Font("Segoe UI",1,22));
        image.add(to);

        toTF = new JComboBox<>(scales);
        toTF.setBounds(500,400,175,30);
        toTF.setFont(new Font("Segoe UI",0,18));
        toTF.setBackground(Color.WHITE);
        image.add(toTF);

        targetTF = new JTextField();
        targetTF.setBounds(300,400,175,30);
        image.add(targetTF);

        convert = new JButton("Convert");
        convert.setBounds(550,300,150,40);
        convert.setFont(new Font("Segoe UI",1,18));
        convert.addActionListener(this);
        image.add(convert);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == convert){
            String source = fromTF.getSelectedItem().toString();
            String target = toTF.getSelectedItem().toString();
            if(source.equals(target)){
                JOptionPane.showMessageDialog(null,"Please select a different scale");
                return;
            }
            boolean reading = checkNumber(sourceTF.getText());
            if(sourceTF == null || !reading){
                JOptionPane.showMessageDialog(null,"Please enter a valid temperature reading in the textbox");
            }
            double c,f,k,r;
            if(source.equals("Celsius")){
                c = Double.parseDouble(sourceTF.getText());
                if(target.equals("Fahrenheit")){
                    f = 1.8*c + 32;
                    targetTF.setText(""+f);
                }
                if(target.equals("Kelvin")){
                    k = c+273.15;
                    targetTF.setText("" + k);
                }
                if(target.equals("Rømer")){
                    r = 0.8*c;
                    targetTF.setText(""+r);
                }
            }

            if(source.equals("Fahrenheit")){
                f = Double.parseDouble(sourceTF.getText());
                if(target.equals("Celsius")){
                    c = (5*f-160)/9.0;
                    targetTF.setText(""+c);
                }
                if(target.equals("Kelvin")){
                    k = (5*f-160)/9.0+273.15;
                    targetTF.setText("" + k);
                }
                if(target.equals("Rømer")){
                    r = (4*f-128)/9.0;
                    targetTF.setText(""+r);
                }
            }

            if(source.equals("Kelvin")){
                k = Double.parseDouble(sourceTF.getText());
                if(target.equals("Celsius")){
                    c = k-273.15;
                    targetTF.setText(""+c);
                }
                if(target.equals("Fahrenheit")){
                    f = (9*k - 2458.35)/5.0 + 32;
                    targetTF.setText("" + f);
                }
                if(target.equals("Rømer")){
                    r = (4*k-1092.6)/5.0;
                    targetTF.setText(""+r);
                }
            }

            if(source.equals("Rømer")){
                r = Double.parseDouble(sourceTF.getText());
                if(target.equals("Celsius")){
                    c = 1.25*r;
                    targetTF.setText(""+c);
                }
                if(target.equals("Fahrenheit")){
                    f = 2.25*r + 32;
                    targetTF.setText("" + f);
                }
                if(target.equals("Kelvin")){
                    k = 1.25*r +273.15;
                    targetTF.setText(""+k);
                }
            }
        }
    }
    public boolean checkNumber(String str){
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        new Frame();
    }
}