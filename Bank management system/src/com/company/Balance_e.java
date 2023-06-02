package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance_e extends JFrame implements ActionListener {
    JButton back;
    String pinnum;

    Balance_e(String pinchange) {
        this.pinnum = pinnum;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 700);
        add(image);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(360, 404, 150, 21);
        back.addActionListener(this);
        image.add(back);

        Conn c=new Conn();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("Select *from bank where pin ='"+pinnum+"'");
            while (rs.next()){
                if (rs.getString("type").equals("Deposit")){
                    balance =balance+Integer.parseInt(rs.getString("amount"));
                }
                else {
                    balance =balance-Integer.parseInt(rs.getString("amount"));
                }
            }
        }
        catch (Exception ee){
            System.out.println(ee);
        }

        JLabel text=new JLabel("YOUr balance:"+balance);
        text.setForeground(Color.white);
        text.setBounds(180,230,200,24);
        image.add(text);







        setSize(900, 700);
        setLocation(200, 0);
        setLayout(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pinnum).setVisible(true);




    }

    public static void main(String[] args) {
        new Balance_e(" ");
    }
}


