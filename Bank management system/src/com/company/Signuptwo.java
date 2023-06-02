package com.company;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signuptwo extends JFrame implements ActionListener {
    JButton next;
    JTextField pan,aadhar;
    JRadioButton existingyes,existingno,scitizen,citizen;
    ButtonGroup siniorcitizen,existingbtn;
    JComboBox rilegon,incomebox,edu,occupations,categorybox;
    String formno;


    Signuptwo(String formno){
        this.formno=formno;
        setTitle("NEW ACCOUNT APPLICATION FORM PAGE 2");



        JLabel additonaldetail= new JLabel(" page 2: Additional details");
        additonaldetail.setBounds(220,80,300,25);
        additonaldetail.setFont(new Font("raleway",Font.BOLD,20));
        add(additonaldetail);

        JLabel religon = new JLabel("Religoun:");
        religon.setBounds(100,120,200,20);
        religon.setFont(new Font("raleway",Font.BOLD,20));
        add(religon);

        String valrilegon[]={"hindu","muslim","other"};
        rilegon = new JComboBox(valrilegon);
        rilegon.setBounds(300,120,200,20);
        rilegon.setBackground(Color.white);
        rilegon.setForeground(Color.black);
        add(rilegon);

        JLabel category = new JLabel("Category:");
        category.setBounds(100,160,200,20);
        category.setFont(new Font("raleway",Font.BOLD,20));
        add(category);

        String valcategory[]={"Genral","OBC","SC","ST"};
        categorybox = new JComboBox(valcategory);
        categorybox.setBounds(300,160,200,20);
        categorybox.setBackground(Color.white);
        categorybox.setForeground(Color.black);
        add(categorybox);


        JLabel income = new JLabel("Income:");
        income.setBounds(100,200,200,20);
        income.setFont(new Font("raleway",Font.BOLD,20));
        add(income);

        String valincome[]={"NULL","10,000 TO 50,000","50,000 TO 1,00,000","above 1,00,000"};
        incomebox=new JComboBox(valincome);
        incomebox.setBounds(300,200,200,20);
        categorybox.setBackground(Color.white);
        categorybox.setForeground(Color.black);
        add(incomebox);

        JLabel education= new JLabel("Educational");
        education.setBounds(100,240,200,20);
        education.setFont(new Font("raleway",Font.BOLD,20));
        add(education);

        JLabel qualification = new JLabel("Qualification:");
        qualification.setBounds(100,260,200,20);
        qualification.setFont(new Font("raleway",Font.BOLD,20));
        add(qualification);

        String valedu[]={"10th pass","12th pass","Graduate","post graduate","doctrate"};
        edu=new JComboBox(valedu);
        edu.setBounds(300,250,200,20);
        edu.setBackground(Color.white);
        edu.setForeground(Color.black);
        add(edu);


        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(100,320,200,20);
        occupation.setFont(new Font("raleway",Font.BOLD,20));
        add(occupation);


        String valoccupation[]={"salaried","self-employed","industralist","other"};
        occupations=new JComboBox(valoccupation);
        occupations.setBounds(300,320,200,20);
        occupations.setBackground(Color.white);
        occupations.setForeground(Color.black);
        add(occupations);




        JLabel city = new JLabel("pan number:");
        city.setBounds(100,360,200,20);
        city.setFont(new Font("raleway",Font.BOLD,20));
        add(city);

        pan= new JTextField();
        pan.setBounds(300,360,200,20);
        pan.setFont(new Font("raleway",Font.BOLD,20));
        add(pan);

        JLabel state = new JLabel("aadhar numbber:");
        state.setBounds(100,400,200,20);
        state.setFont(new Font("raleway",Font.BOLD,20));
        add(state);

        aadhar= new JTextField();
        aadhar.setBounds(300,400,200,20);
        aadhar.setFont(new Font("raleway",Font.BOLD,20));
        add(aadhar);

        JLabel pin = new JLabel("Sinior citizen:");
        pin.setBounds(100,440,200,20);
        pin.setFont(new Font("raleway",Font.BOLD,20));
        add(pin);



        scitizen=new JRadioButton("YES");
        scitizen.setBounds(300,440,100,20);
        scitizen.setFont(new Font("raleway",Font.PLAIN,20));
        scitizen.setBackground(Color.white);
        add(scitizen);

        citizen=new JRadioButton("NO");
        citizen.setBounds(400,440,100,20);
        citizen.setFont(new Font("raleway",Font.PLAIN,20));
        citizen.setBackground(Color.white);
        add(citizen);

        siniorcitizen=new ButtonGroup();
        siniorcitizen.add(scitizen);
        siniorcitizen.add(citizen);


        JLabel Existing = new JLabel("Existing account:");
        Existing.setBounds(100,480,200,20);
        Existing.setFont(new Font("raleway",Font.BOLD,20));
        add(Existing);

        existingyes=new JRadioButton("YES");
        existingyes.setBounds(300,480,100,20);
        existingyes.setFont(new Font("raleway",Font.PLAIN,20));
        existingyes.setBackground(Color.white);
        add(existingyes);

        existingno=new JRadioButton("NO");
        existingno.setBounds(400,480,100,20);
        existingno.setFont(new Font("raleway",Font.PLAIN,20));
        existingno.setBackground(Color.white);
        add(existingno);

         existingbtn=new ButtonGroup();
        existingbtn.add(existingyes);
        existingbtn.add(existingno);





        next= new JButton("NEXT");
        next.setBounds(400,520,100,30);
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
        String Sreligon=(String)rilegon.getSelectedItem();
        String Scategory=(String)categorybox.getSelectedItem();
        String sincome=(String)incomebox.getSelectedItem();
        String sedu=(String)edu.getSelectedItem();
        String soccupation=(String)occupations.getSelectedItem();
        String span= pan.getText().toUpperCase();
        String saadhar= aadhar.getText();
        String citijen=null;
        if(scitizen.isSelected()){
            citijen="yes";
        }
        else{
            citijen="no";
        }
        String existing=null;
        if(existingyes.isSelected()){
            existing="yes";
        }
        else{
            existing="no";

        }
        
        try{
            Conn c=new Conn();
            String query="INSERT INTO signuptwo values('"+formno+"','"+Sreligon+"','"+Scategory+"','"+sincome+"','"+sedu+"','"+soccupation+"','"+span+"','"+saadhar+"','"+citijen+"')";
            c.s.executeUpdate(query);




            new Signupthree(formno).setVisible(true);
            setVisible(false);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new Signuptwo(" ");
    }
}