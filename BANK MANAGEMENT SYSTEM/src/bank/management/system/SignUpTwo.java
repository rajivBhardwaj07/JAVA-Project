package bank.management.system;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

public class SignUpTwo extends JFrame implements ActionListener {

    
    JTextField pan,adhar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
        
    JComboBox religion,category,occupation,education,income;
    String formno;
    

    SignUpTwo(String formno) {
        this.formno = formno;

        setLayout(null);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
       

        JLabel relegion = new JLabel("Religion:");
        relegion.setFont(new Font("Raleway", Font.BOLD, 20));
        relegion.setBounds(100, 140, 100, 30);
        add(relegion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion  = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
      

        JLabel Category = new JLabel("Category:");
        Category.setFont(new Font("Raleway", Font.BOLD, 20));
        Category.setBounds(100, 190, 200, 30);
        add(Category);
        
        String valcategory[]={"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel Income = new JLabel("Income:");
        Income.setFont(new Font("Raleway", Font.BOLD, 20));
        Income.setBounds(100, 240, 200, 30);
        add(Income);
        
        String incomecategory[]={"Null","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

      

        JLabel Educational = new JLabel("Educational:");
        Educational.setFont(new Font("Raleway", Font.BOLD, 20));
        Educational.setBounds(100, 290, 200, 30);
        add(Educational);

        JLabel Qualifications = new JLabel("Qualifications:");
        Qualifications.setFont(new Font("Raleway", Font.BOLD, 20));
        Qualifications.setBounds(100, 315, 200, 30);
        add(Qualifications);
        
        String educationValues[]={"Non-Graduate","Graduate","Post Graduate","Doctorate","Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        education.setBackground(Color.WHITE);
        add(education);

        

        JLabel Occupation = new JLabel("Occupation:");
        Occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        Occupation.setBounds(100, 390, 200, 30);
        add(Occupation);
        
        String OccupationalValues[]={"Salaried","Non Salaried","Businessman","Student","Retired","Other"};
        occupation = new JComboBox(OccupationalValues);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);


        JLabel PANNumber = new JLabel("PAN Number:");
        PANNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        PANNumber.setBounds(100, 440, 200, 30);
        add(PANNumber);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway", Font.BOLD, 14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        

        JLabel adharNumber = new JLabel("Adhar Number:");
        adharNumber.setFont(new Font("Raleway", Font.BOLD, 20));
        adharNumber.setBounds(100, 490, 200, 30);
        add(adharNumber);

        adhar = new JTextField();
        adhar.setFont(new Font("Raleway", Font.BOLD, 14));
        adhar.setBounds(300, 490, 400, 30);
        add(adhar);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        senior.setBounds(100, 540, 200, 30);
        add(senior);
        
        
        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup maritalGroup = new ButtonGroup();
        maritalGroup.add(syes);
        maritalGroup.add(sno);
       

        

        JLabel existing = new JLabel("Existing Account:");
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        existing.setBounds(100, 590, 200, 30);
        add(existing);
        
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritalGroup = new ButtonGroup();
        emaritalGroup.add(eyes);
        emaritalGroup.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String)religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome= (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String soccupation = (String) occupation.getSelectedItem();

        String seniorcitizen = null;
        if (syes.isSelected()) seniorcitizen = "Yes";
        else if (sno.isSelected()) seniorcitizen = "No";

        
        String existingaccount = null;
        if (eyes.isSelected()) existingaccount = "Yes";
        else if (eno.isSelected()) existingaccount = "No";
       

        String span = pan.getText();
        String sadhar = adhar.getText();
        

        try {
            
                Conn c = new Conn();
                String query = "INSERT INTO signupTwo VALUES('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '" + seducation + "', '" + soccupation + "', '" + span + "', '" + sadhar + "', '" + seniorcitizen+ "', '" + existingaccount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Submitted Successfully");
                
                setVisible(false);
                new SignUpThree(formno).setVisible(true);
             
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new SignUpTwo("");
    }
}


class Conn {
    Connection c;
    Statement s;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankmanagementsystem", "root", "rajiv");
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
