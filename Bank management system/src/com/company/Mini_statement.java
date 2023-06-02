package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini_statement  extends JFrame implements ActionListener {
    String pinnum;
    Mini_statement(String pinnum){
        this.pinnum=pinnum;
        setTitle("Mini statement");



        JLabel mini=new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);

        JLabel tbalance=new JLabel();
        tbalance.setBounds(20,500,200,20);
        add(tbalance);

        JLabel bank =new JLabel("Indian bank");
        bank.setBounds(150,30,100,20);
        add(bank);

        JLabel card=new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try{
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select *from login where pin_num='"+pinnum+"'");
            while(rs.next()){
                card.setText("Card number : "+rs.getString("card_num").substring(0,4)+"-XXXX-XXXX-"+rs.getString("card_num").substring(12));
            }

        }
        catch (Exception e){
            System.out.println(e);
        }


        try{
            int balance=0;
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("Select *from bank where pin = '"+pinnum+"'");
            while(rs.next()){
                mini.setText(mini.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance =balance+Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance=balance-Integer.parseInt(rs.getString("amount"));
                }
            }
            tbalance.setText("Your account balance is :"+balance);

        }
        catch (Exception e){
            System.out.println(e);
        }

        JButton exit=new JButton("Exit");
        exit.setBounds(280,500,100,20);
        exit.addActionListener(this);
        add(exit);





        setSize(400,600);
        setLayout(null);
        setLocation(0,0);
        setBackground(Color.white);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        setVisible(false);
    }





    public static void main(String[] args) {
        new Mini_statement(" ");
    }
}
