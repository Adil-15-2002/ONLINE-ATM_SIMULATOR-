package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.Callable;

public class Deposit extends JFrame implements ActionListener {
    JButton depositbtn,back;
    JTextField deposittext;
    String pinnum;


    Deposit(String pinnum){
        this.pinnum=pinnum;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel deposit= new JLabel("Enter your amount to deposit");
        deposit.setBounds(200,230,300,25);
        deposit.setFont(new Font("calibari",Font.BOLD,20));
        deposit.setForeground(Color.white);
        image.add(deposit);

        deposittext=new JTextField();
        deposittext.setBounds(200,270,200,25);
        deposit.setFont(new Font("calibari",Font.PLAIN,15));
        image.add(deposittext);

        depositbtn =new JButton("Deposit");
        depositbtn.setBackground(Color.white);
        depositbtn.setForeground(Color.black);
        depositbtn.setBounds(360,380,150,21);
        depositbtn.addActionListener(this);
        image.add(depositbtn);

        back =new JButton("Back");
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
    public void actionPerformed(ActionEvent w){
        if(w.getSource()==depositbtn){
            String amount =deposittext.getText();
            Date date=new Date();
            if(amount.equals(" ")){
                JOptionPane.showMessageDialog(null,"Please enter the amount");
            }
            else{
                Conn c=new Conn();
                String qeury = "insert into bank values('"+pinnum+"','"+date+"','Deposit','"+amount+"')";
                try{
                    c.s.executeUpdate(qeury);
                    JOptionPane.showMessageDialog(null,"Amount: "+amount+" Deposit succesfully");
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }


        }
        else if(w.getSource()==back){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);

        }

    }



    public static void main(String[] args) {
        new Deposit(" ");
    }
}
