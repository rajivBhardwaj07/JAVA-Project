
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    
    JButton withdrawl1,withdrawl2,withdrawl3,withdrawl4,withdrawl5,withdrawl6,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber = pinnumber; 
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font ("System",Font.BOLD,16));
        image.add(text);
        
        withdrawl1 = new JButton("Rs 100");
        withdrawl1.setBounds(170,415,150,30);
        withdrawl1.addActionListener(this);
        image.add(withdrawl1);
        
        withdrawl2 = new JButton("Rs 500");
        withdrawl2.setBounds(355,415,150,30);
        withdrawl2.addActionListener(this);
        image.add(withdrawl2);
        
        withdrawl3 = new JButton("Rs 1000");
        withdrawl3.setBounds(170,450,150,30);
        withdrawl3.addActionListener(this);
        image.add(withdrawl3);
        
        withdrawl4 = new JButton("Rs 2000");
        withdrawl4.setBounds(355,450,150,30);
        withdrawl4.addActionListener(this);
        image.add(withdrawl4);
        
        withdrawl5 = new JButton("Rs 5000");
        withdrawl5.setBounds(170,485,150,30);
        withdrawl5.addActionListener(this);
        image.add(withdrawl5);
        
        withdrawl6 = new JButton("Rs 10000");
        withdrawl6.setBounds(355,485,150,30);
        withdrawl6.addActionListener(this);
        image.add(withdrawl6);
        
        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
        
    }
    
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select*from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                        
                    }
                    
                }
                
                if(ae.getSource() != back && balance < Integer.parseInt(amount) ){
                    JOptionPane.showMessageDialog(null,"Insufficent Balance");
                    return;
                    
                }
                
                Date date = new Date();
                String query = "insert into bank values ('"+pinnumber+"','"+date+"','Withdrawl','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+"Debited Succesfully");
                
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
                
                        
                
            }catch(Exception e){
                System.out.println(e);
                
            }
            
        }
        
    }
    
    public static void main(String args[]){
        
        new FastCash("");
        
    }
    
}
