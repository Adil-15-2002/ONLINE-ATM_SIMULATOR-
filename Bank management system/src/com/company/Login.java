package com.company;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.sql.*;

public class Login extends JFrame   implements ActionListener {
    JButton signin,signup,clear;
    JTextField cardtext;
    JPasswordField pintext;
    Login(){

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel logo= new JLabel(i3);
        logo.setBounds(70,20,100,100);
        add(logo);

        JLabel text =new JLabel("Welcome to ATM");
        text.setBounds(200,50,300,40);
        text.setFont(new Font("osward",Font.BOLD,35));
        add(text);

        JLabel card =new JLabel("CARD No:");
        card.setBounds(150,150,200,40);
        card.setFont(new Font("RAIEWAY",Font.BOLD,25));
        add(card);
        //
        cardtext= new JTextField("");
        cardtext.setBounds(350,160,250,30);
        cardtext.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtext);

        JLabel pin =new JLabel("PIN:");
        pin.setBounds(150,200,200,40);
        pin.setFont(new Font("RAIEWAY",Font.PLAIN,25));
        add(pin);
        //
        pintext= new JPasswordField();
        pintext.setBounds(350,210,250,30);
        cardtext.setFont(new Font("Arial",Font.PLAIN,14));
        add(pintext);


        signin= new JButton("Sign in");
        signin.setBounds(350,280,100,30);
        signin.setBackground(Color.black);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        clear= new JButton("clear");
        clear.setBounds(500,280,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup= new JButton("sign up");
        signup.setBounds(350,320,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);







        setTitle("AUTOMATED  TELLER MACHINE");

        setSize(800,480);
        setLocation(280,160);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
        cardtext.setText("");
        pintext.setText("");
        }
        else if(e.getSource()==signup){
            setVisible(false);
            new Signupone().setVisible(true);
        }
        else if(e.getSource()==signin){
            Conn c= new Conn();
            String carnum=cardtext.getText();
            String pinnum =pintext.getText();

            String qeury = "SELECT *FROM login where card_num = '"+carnum+"'and Pin_num ='"+pinnum+"'";
            try{

               ResultSet result= c.s.executeQuery(qeury);
                if(result.next()){
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect credentials:");
                }
            }
            catch (Exception b){
                System.out.println(b);
            }
        }


    }


    public static void main(String[] args) {
        new Login();
    }
}
