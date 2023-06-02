package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener {
    JTextField pintext1,pintext2;
    JButton back,submit;
    String pinnum;


    Pinchange(String pinnum){
        this.pinnum=pinnum;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel Heading= new JLabel("CHANGE YOUR PIN");
        Heading.setBounds(240,230,300,25);
        Heading.setFont(new Font("calibari",Font.BOLD,20));
        Heading.setForeground(Color.white);
        image.add(Heading);

        JLabel pin1=new JLabel("Enter PIN:");
        pin1.setBounds(170,270,300,22);
        pin1.setFont(new Font("calibari",Font.BOLD,15));
        pin1.setForeground(Color.white);
        image.add(pin1);

        JLabel pin2=new JLabel("RE-Enter PIN:");
        pin2.setBounds(170,300,300,22);
        pin2.setFont(new Font("calibari",Font.BOLD,15));
        pin2.setForeground(Color.white);
        image.add(pin2);

        pintext1=new JTextField();
        pintext1.setBounds(300,270,200,22);
        image.add(pintext1);

        pintext2=new JTextField();
        pintext2.setBounds(300,300,200,22);
        image.add(pintext2);

        submit=new JButton("Submit");
        submit.setBackground(Color.white);
        submit.setForeground(Color.black);
        submit.setBounds(360,377,150,21);
        submit.addActionListener(this);
        image.add(submit);


        back=new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(360,404,150,21);
        back.addActionListener(this);
        image.add(back);







        setSize(900,700);
        setLocation(200,0);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==submit) {
            try {
                String newpin = pintext1.getText();
                String newpin2 = pintext2.getText();

                if (!newpin.equals(newpin2)) {
                    JOptionPane.showMessageDialog(null, "Enter pin does not match");
                    return;
                }
                if (newpin.equals("")){
                    JOptionPane.showMessageDialog(null," Enter pin is empty");
                    return;
                }
                if(newpin2.equals("")){
                    JOptionPane.showMessageDialog(null,"Re-enter your pin");
                    return;
                }
                Conn c=new Conn();
                String q1="update bank set pin = '"+newpin2+"' where pin='"+pinnum+"'";
                String q2="update login set pin_num = '"+newpin2+"' where Pin_num='"+pinnum+"'";
                String q3="update signupthree set pin_number = '"+newpin2+"' where Pin_number='"+pinnum+"'";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);

                JOptionPane.showMessageDialog(null,"Pin change sucessfully");

                setVisible(false);
                new Transactions(newpin).setVisible(true);



            } catch (Exception ee) {
                System.out.println(ee);
            }
        }
        else {
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }
    }


    public static void main(String[] args) {
        new Pinchange(" ");
    }
}
