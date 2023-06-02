package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    JButton Deposit,free_cash,pin_change,cancel,withdrawl,mini_statement,_balance,exit;
    String pinnum;
    Transactions (String pinnum){
        this.pinnum=pinnum;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel transaction= new JLabel("-please select your tansaction-");
        transaction.setBounds(200,230,300,25);
        transaction.setFont(new Font("calibari",Font.BOLD,20));
        transaction.setForeground(Color.white);
        image.add(transaction);

        Deposit=new JButton("Deposit");
        Deposit.setBackground(Color.white);
        Deposit.setForeground(Color.black);
        Deposit.setBounds(160,323,150,21);
        Deposit.addActionListener(this);
        image.add(Deposit);

        free_cash=new JButton("Fast cash");
        free_cash.setBackground(Color.white);
        free_cash.setForeground(Color.black);
        free_cash.setBounds(160,350,150,21);
        free_cash.addActionListener(this);
        image.add(free_cash);

        pin_change=new JButton("Pin change");
        pin_change.setBackground(Color.white);
        pin_change.setForeground(Color.black);
        pin_change.setBounds(160,377,150,21);
        pin_change.addActionListener(this);
        image.add(pin_change);

        cancel=new JButton("cancel");
        cancel.setBackground(Color.white);
        cancel.setForeground(Color.black);
        cancel.setBounds(160,404,150,21);
        cancel.addActionListener(this);
        image.add(cancel);

        withdrawl=new JButton("Widtdrawl");
        withdrawl.setBackground(Color.white);
        withdrawl.setForeground(Color.black);
        withdrawl.setBounds(360,323,150,21);
        withdrawl.addActionListener(this);
        image.add(withdrawl);


        mini_statement=new JButton("Mini statement");
        mini_statement.setBackground(Color.white);
        mini_statement.setForeground(Color.black);
        mini_statement.setBounds(360,350,150,21);
        mini_statement.addActionListener(this);
        image.add(mini_statement);

        _balance=new JButton("Balance enquiry");
        _balance.setBackground(Color.white);
        _balance.setForeground(Color.black);
        _balance.setBounds(360,377,150,21);
        _balance.addActionListener(this);
        image.add(_balance);

        exit=new JButton("Exit");
        exit.setBackground(Color.white);
        exit.setForeground(Color.black);
        exit.setBounds(360,404,150,21);
        exit.addActionListener(this);
        image.add(exit);






        setSize(900,700);
        setLocation(200,0);
        setLayout(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==exit){
            System.exit(0);
        }
        else if(e.getSource()==Deposit){
            setVisible(false);
            new Deposit(pinnum).setVisible(true);
        }

        else if (e.getSource()==withdrawl){
            setVisible(false);
            new Widtdrawl(pinnum).setVisible(true);
        }
        else if(e.getSource()==free_cash){
            setVisible(false);
            new Fast_cash(pinnum).setVisible(true);
        }
        else if(e.getSource()==pin_change){
            setVisible(false);
            new Pinchange(pinnum).setVisible(true);
        }
        else if(e.getSource()==_balance){
            setVisible(false);
            new Balance_e(pinnum).setVisible(true);
        }
        else if(e.getSource()==mini_statement){
            setVisible(false);
            new Mini_statement(pinnum).setVisible(true);
        }
    }




    public static void main(String[] args) {
        new Transactions("");
    }
}
