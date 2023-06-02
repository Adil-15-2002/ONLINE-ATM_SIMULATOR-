package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signupone extends JFrame implements ActionListener {
    long random;
    JTextField  txtname,txtfname,txtemail,txtcity,txtstate,txtpin;
    JButton next;
    JRadioButton male,female,married ,unmarried;
    JDateChooser dob;
    JLabel formno,personaldetails,name,Fathername,DOB,gender,email,marital,city,state,pin;

    Signupone(){
        Random ran =new Random();
        random=(Math.abs(ran.nextLong()%9000)+1000);

        JLabel formno=new JLabel("APPLICATION FORM NO: "+random);
        formno.setBounds(120,20,600,40);
        formno.setFont(new Font("Raleway",Font.BOLD,30));
        add(formno);

        JLabel pesrsonaldetail= new JLabel("page 1:pesonal details");
        pesrsonaldetail.setBounds(220,80,300,25);
        pesrsonaldetail.setFont(new Font("raleway",Font.BOLD,20));
        add(pesrsonaldetail);

        JLabel name = new JLabel("Name:");
        name.setBounds(100,120,200,20);
        name.setFont(new Font("raleway",Font.BOLD,20));
        add(name);

        txtname= new JTextField();
        txtname.setBounds(300,120,200,20);
        txtname.setFont(new Font("raleway",Font.PLAIN,15));
        add(txtname);

        Fathername = new JLabel("Father Name:");
        Fathername.setBounds(100,160,200,20);
        Fathername.setFont(new Font("raleway",Font.BOLD,20));
        add(Fathername);

        txtfname= new JTextField();
        txtfname.setBounds(300,160,200,20);
        txtfname.setFont(new Font("raleway",Font.PLAIN,15));
        add(txtfname);

        DOB = new JLabel("Date of birth:");
        DOB.setBounds(100,200,200,20);
        DOB.setFont(new Font("raleway",Font.BOLD,20));
        add(DOB);

        dob=new JDateChooser();
        dob.setBounds(300,200,200,20);
        add(dob);

        gender = new JLabel("Gender:");
        gender.setBounds(100,240,200,20);
        gender.setFont(new Font("raleway",Font.BOLD,20));
        add(gender);

        male= new JRadioButton("MALE");
        male.setBounds(300,240,80,20);
        male.setBackground(Color.white);
        add(male);
        female= new JRadioButton("FEMALE");
        female.setBounds(400,240,80,20);
        female.setBackground(Color.white);
        add(female);


        ButtonGroup btng=new ButtonGroup();
        btng.add(male);
        btng.add(female);


        email = new JLabel("Email address:");
        email.setBounds(100,280,200,20);
        email.setFont(new Font("raleway",Font.BOLD,20));
        add(email);

        txtemail= new JTextField();
        txtemail.setBounds(300,280,200,20);
        txtemail.setFont(new Font("raleway",Font.PLAIN,15));
        add(txtemail);

        marital = new JLabel("Marital status:");
        marital.setBounds(100,320,200,20);
        marital.setFont(new Font("raleway",Font.BOLD,20));
        add(marital);

        married=new JRadioButton("MARRIED");
        married.setBounds(300,320,80,20);
        married.setBackground(Color.white);
        add(married);

        unmarried=new JRadioButton("UNMARRIED");
        unmarried.setBounds(400,320,100,20);
        unmarried.setBackground(Color.white);
        add(unmarried);

        ButtonGroup btng2=new ButtonGroup();
        btng2.add(married);
        btng2.add(unmarried);


        city = new JLabel("city:");
        city.setBounds(100,360,200,20);
        city.setFont(new Font("raleway",Font.BOLD,20));
        add(city);

        txtcity= new JTextField();
        txtcity.setBounds(300,360,200,20);
        txtcity.setFont(new Font("raleway",Font.PLAIN,15));
        add(txtcity);

        state = new JLabel("State:");
        state.setBounds(100,400,200,20);
        state.setFont(new Font("raleway",Font.BOLD,20));
        add(state);

        txtstate= new JTextField();
        txtstate.setBounds(300,400,200,20);
        txtstate.setFont(new Font("raleway",Font.PLAIN,15));
        add(txtstate);

        pin = new JLabel("Pin code:");
        pin.setBounds(100,440,200,20);
        pin.setFont(new Font("raleway",Font.BOLD,20));
        add(pin);

        txtpin= new JTextField();

        txtpin.setBounds(300,440,200,20);
        txtpin.setFont(new Font("raleway",Font.PLAIN,15));
        add(txtpin);


        next= new JButton("NEXT");
        next.setBounds(400,480,100,30);
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.addActionListener(this);
        add(next);


        setSize(700,700);
        setLocation(320,20);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ee) {
        String formno = String.valueOf(random);
        String name = txtname.getText();
        String fathername = txtfname.getText();
        String dob = ((JTextField) new JDateChooser().getDateEditor().getUiComponent()).getText();
        String genderr=null;
        if(male.isSelected()){
            genderr="male";
        }else{
            genderr="female";
        }
        String email=txtemail.getText();
        String marital=null;
        if(married.isSelected()){
            marital="maried";
        }
        else{
            marital="unmarried";
        }
        String address=txtcity.getText();
        String state=txtstate.getText();
        String pin=txtpin.getText();
        try {
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"name is required");
            }
            else{
                Conn c= new Conn();
                String query="INSERT INTO signupone values('"+formno+"','"+name+"','"+fathername+"','"+dob+"','"+genderr+"','"+email+"','"+marital+"','"+address+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new Signuptwo(formno).setVisible(true);


            }
        }
        catch (Exception aa){
            System.out.println(aa);
        }
    }

    public static void main(String[] args) {
        new Signupone();
    }
}


