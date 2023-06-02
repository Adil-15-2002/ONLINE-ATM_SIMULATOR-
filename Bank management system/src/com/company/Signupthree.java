package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signupthree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;

    Signupthree(String formno) {
        this.formno=formno;
        setLayout(null);



        JLabel l1=new JLabel("page 3:Account detail");
        l1.setFont(new Font("raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel type=new JLabel("Account type:");
        type.setFont(new Font("raleway",Font.BOLD,22));
        type.setBounds(100,140,200,20);
        add(type);

        r1=new JRadioButton(" saving account ");
        r1.setFont(new Font("raleway",Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.white);
        add(r1);
        r2=new JRadioButton(" current account ");
        r2.setFont(new Font("raleway",Font.BOLD,16));
        r2.setBounds(250,180,150,20);
        r2.setBackground(Color.white);
        add(r2);

        r3=new JRadioButton(" FD account ");
        r3.setFont(new Font("raleway",Font.BOLD,16));
        r3.setBounds(100,220,150,20);
        r3.setBackground(Color.white);
        add(r3);
        r4=new JRadioButton(" RD account ");
        r4.setFont(new Font("raleway",Font.BOLD,16));
        r4.setBounds(250,220,150,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup accountbox=new ButtonGroup();
        accountbox.add(r1);
        accountbox.add(r2);
        accountbox.add(r3);
        accountbox.add(r4);

        JLabel card=new JLabel(" Card Number:");
        card.setFont(new Font("raleway",Font.BOLD,22));
        card.setBounds(100,280,200,25);
        add(card);
        JLabel carddetail=new JLabel(" This is your Card Number");
        carddetail.setFont(new Font("raleway",Font.BOLD,15));
        carddetail.setBounds(110,305,200,25);
        add(carddetail);


        JLabel cardnum=new JLabel(" XXXX XXXX XXXX 1216");
        cardnum.setFont(new Font("raleway",Font.BOLD,22));
        cardnum.setBounds(300,280,300,25);
        add(cardnum);

        JLabel pinnum=new JLabel("Pin number:");
        pinnum.setFont(new Font("raleway",Font.BOLD ,22));
        pinnum.setBounds(100,360,300,25);
        add(pinnum);
        JLabel pindetail=new JLabel(" This is your PIN");
        pindetail.setFont(new Font("raleway",Font.BOLD,15));
        pindetail.setBounds(110,385,200,15);
        add(pindetail);

        JLabel pinn=new JLabel("XXXX:");
        pinn.setFont(new Font("raleway",Font.BOLD ,22));
        pinn.setBounds(300,360,300,25);
        add(pinn);

        JLabel services=new JLabel("Services required:");
        services.setFont(new Font("raleway",Font.BOLD,22));
        services.setBounds(100,430,200,25);
        add(services);

        c1=new JCheckBox("ATM card");
        c1.setFont(new Font("raleway", Font.BOLD,15));
        c1.setBounds(100,470,100,30);
        c1.setBackground(Color.white);
        add(c1);
        c2=new JCheckBox("Internet  Banking");
        c2.setFont(new Font("raleway", Font.BOLD,15));
        c2.setBounds(300,470,100,30);
        c2.setBackground(Color.white);
        add(c2);
        c3=new JCheckBox("Mobile banking");
        c3.setFont(new Font("raleway", Font.BOLD,15));
        c3.setBounds(100,510,100,30);
        c3.setBackground(Color.white);
        add(c3);
        c4=new JCheckBox("SMS Alert");
        c4.setFont(new Font("raleway", Font.BOLD,15));
        c4.setBounds(300,510,100,30);
        c4.setBackground(Color.white);
        add(c4);
        c5=new JCheckBox("Check book");
        c5.setFont(new Font("raleway", Font.BOLD,15));
        c5.setBounds(100,550,100,30);
        c5.setBackground(Color.white);
        add(c5);
        c6=new JCheckBox("E-statement");
        c6.setFont(new Font("raleway", Font.BOLD,15));
        c6.setBounds(300,550,100,30);
        c6.setBackground(Color.white);
        add(c6);
        c7=new JCheckBox("I hereby declare that the above enterd details are correct to the best of my knowledge");
        c7.setFont(new Font("raleway", Font.BOLD,15));
        c7.setBounds(100,600,700,30);
        c7.setBackground(Color.white);
        add(c7);

        submit=new JButton("SUBMIT");
        submit.setBounds(250,650,100,30);
        submit.setFont(new Font("raleway",Font.BOLD,14));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("CANCEL");
        cancel.setBounds(400,650,100,30);
        cancel.setFont(new Font("raleway",Font.BOLD,14));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850,820);
        setLocation(250,0);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit){
            String type=null;
            if(r1.isSelected()){
                type="saving account";
            }
            if(r2.isSelected()){
                type="current account";
            }
            if(r3.isSelected()){
                type="FD account";
            }
            if(r4.isSelected()){
                type="RD account";
            }

            Random rand = new Random();
            long r1=rand.nextLong()%90000000L+5040936000000000L;
            String cardnum=""+Math.abs(r1);
            long r2=rand.nextLong() %9000L+1000L;
            String pinnum=""+ Math.abs(r2);

            String services=" ";
            if(c1.isSelected()){
                services=services+"ATM card";
            }if(c2.isSelected()){
                services=services+"Internet banking";
            }if(c3.isSelected()){
                services=services+"Mobile banking";
            }if(c4.isSelected()){
                services=services+"SMS alert";
            }if(c5.isSelected()){
                services=services+"Check book";
            }if(c6.isSelected()){
                services=services+"E-statement";
            }
            try{
                if (type.equals(" ")){
                    JOptionPane.showMessageDialog(null,"ACOUNT TYPE IS REQUIRED");
                }
                Conn c=new Conn();
                String qeury ="INSERT INTO signupthree values('"+formno+"','"+type+"','"+cardnum+"','"+pinnum+"','"+services+"')";
                String qeury2 ="INSERT INTO login values('"+formno+"','"+cardnum+"','"+pinnum+"')";



                c.s.executeUpdate(qeury);
                c.s.executeUpdate(qeury2);



                JOptionPane.showMessageDialog(null,"Your card number :"+cardnum+"\n your pin number :"+pinnum);
                setVisible(false);
                new Deposit(pinnum).setVisible(true);


            }
            catch (Exception l){
                System.out.println(l);
            }





        }
        else if (e.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }

    }



    public static void main(String[] args) {
        new Signupthree(" ");

    }


}