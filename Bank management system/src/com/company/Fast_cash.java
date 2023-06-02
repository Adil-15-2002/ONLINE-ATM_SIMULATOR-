package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Fast_cash extends JFrame implements ActionListener {
    JButton rs_100btn,rs500btn,rs1000btn,rs1500btn,rs2000btn,rs5000btn,rs10000btn,back;
    String pinnum;
    Fast_cash (String pinnum){
        this.pinnum=pinnum;

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2= i1.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,700);
        add(image);

        JLabel transaction= new JLabel("Select widtdrawl  amount");
        transaction.setBounds(200,230,300,25);
        transaction.setFont(new Font("calibari",Font.BOLD,20));
        transaction.setForeground(Color.white);
        image.add(transaction);

        rs_100btn=new JButton("RS 100");
        rs_100btn.setBackground(Color.white);
        rs_100btn.setForeground(Color.black);
        rs_100btn.setBounds(160,323,150,21);
        rs_100btn.addActionListener(this);
        image.add(rs_100btn);

        rs500btn=new JButton("RS 500");
        rs500btn.setBackground(Color.white);
        rs500btn.setForeground(Color.black);
        rs500btn.setBounds(160,350,150,21);
        rs500btn.addActionListener(this);
        image.add(rs500btn);

        rs1000btn=new JButton("RS 1000");
        rs1000btn.setBackground(Color.white);
        rs1000btn.setForeground(Color.black);
        rs1000btn.setBounds(160,377,150,21);
        rs1000btn.addActionListener(this);
        image.add(rs1000btn);

        rs1500btn=new JButton("RS 1500");
        rs1500btn.setForeground(Color.black);
        rs1500btn.setBounds(160,404,150,21);
        rs1500btn.addActionListener(this);
        image.add(rs1500btn);

        rs2000btn=new JButton("Rs 2000");
        rs2000btn.setBackground(Color.white);
        rs2000btn.setForeground(Color.black);
        rs2000btn.setBounds(360,323,150,21);
        rs2000btn.addActionListener(this);
        image.add(rs2000btn);


        rs5000btn=new JButton("RS 5000");
        rs5000btn.setBackground(Color.white);
        rs5000btn.setForeground(Color.black);
        rs5000btn.setBounds(360,350,150,21);
        rs5000btn.addActionListener(this);
        image.add(rs5000btn);

        rs10000btn=new JButton("RS 10,000");
        rs10000btn.setBackground(Color.white);
        rs10000btn.setForeground(Color.black);
        rs10000btn.setBounds(360,377,150,21);
        rs10000btn.addActionListener(this);
        image.add(rs10000btn);

        back=new JButton("Exit");
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
        if (e.getSource()==back){
            setVisible(false);
            new Transactions(pinnum).setVisible(true);
        }

        else{
            String amount =((JButton)e.getSource()).getText().substring(3);
            try{
                Conn c=new Conn();
                String query1="select *from bank where pin='"+pinnum+"'";
                ResultSet rs=c.s.executeQuery(query1);

                int balance=0;

                while (rs.next()){
                    if (rs.getString("type").equals("Deposit")) {
                        balance = balance+Integer.parseInt(rs.getString("amount"));

                    }
                    else{
                        balance = balance-Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (e.getSource()!=back && balance< Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient balance");
                    return;
                }
                else if (e.getSource()==back){
                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }
                else {
                    java.util.Date date = new Date();
                    String query2 = "INSERT into bank values('" + pinnum + "','" + date + "','widtdrawl','" + amount + "')";
                    c.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null, "rs " + amount + " Debited ");

                    setVisible(false);
                    new Transactions(pinnum).setVisible(true);
                }


            }
            catch (Exception el){
                System.out.println(el);

            }

        }
    }




    public static void main(String[] args) {
        new Fast_cash("");
    }
}
