package com.SwingPractice;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.imageio.ImageIO;
import javax.swing.*;


public class EmployeeScreen { 
	
 public EmployeeScreen() throws IOException { 
 // TODO Auto-generated constructor stub 
	 JFrame jf = new JFrame("Employee Screen");
	 jf.setSize(1460,730);
	 
	 JLabel background=new JLabel(new ImageIcon("C:\\Users\\Abishek\\Downloads\\social-media-image-sizes-1.png"));
	 jf.add(background);
     jf.setVisible(true);
     jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
 
     JLabel empno = new JLabel("Emp ID:");
     empno.setBounds(660, 50, 80, 30);
     empno.setFont(new Font("Arial", Font.BOLD, 13));
     background.add(empno);
 
 
     JLabel empname = new JLabel("Emp Name:");
     empname.setBounds(660, 100, 80, 30);
     empname.setFont(new Font("Arial", Font.BOLD, 13));
     background.add(empname);
 
     JLabel age = new JLabel("Emp Age:");
     age.setBounds(660, 150, 80, 30);
     age.setFont(new Font("Arial", Font.BOLD, 13));
     background.add(age);
 
     JLabel salary = new JLabel("Emp Salary:");
     salary.setBounds(660, 200, 80, 30);
     salary.setFont(new Font("Arial", Font.BOLD, 13));
     background.add(salary);
 
     JButton saveButton = new JButton("Save"); 
     saveButton.setBounds(700,275, 100,30);
     saveButton.setBackground(new Color(51, 255, 255));
     background.add(saveButton);
 
     JTextField empid = new JTextField(); 
     empid.setBounds(750,50, 100,30); 
     background.add(empid);
 
 
     JTextField ename = new JTextField();
     ename.setBounds(750,100,100,30);
     background.add(ename);
 
     JTextField eage = new JTextField();
     eage.setBounds(750,150,100,30);
     background.add(eage);
 
     JTextField esalary = new JTextField();
     esalary.setBounds(750,200,100,30);
     background.add(esalary);
    
     
    
    saveButton.addActionListener(new ActionListener() { 
    	@Override 
    	public void actionPerformed(ActionEvent e) { 
    		// TODO Auto-generated method stub 
    		int empID = Integer.parseInt(empid.getText());
    		String empName = ename.getText();
    		int empAge = Integer.parseInt(eage.getText());
    		double empSalary = Double.parseDouble(esalary.getText());
    		
    		try { 
    			String Query = "insert into emp values(?,?,?,?)";
    			Class.forName("com.mysql.jdbc.Driver");
    			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Details","root","Abishek@1");
    			PreparedStatement ps = con.prepareStatement(Query);
    			ps.setInt(1, empID);
    			ps.setString(2, empName);
    			ps.setInt(3, empAge);
    			ps.setDouble(4, empSalary);
    			
    			int i = ps.executeUpdate();
    			JOptionPane.showMessageDialog(jf, "Data Stored in Database");
    			con.close();
    			
    		} catch (Exception e1) { 
    			// TODO Auto-generated catch block 
    			e1.printStackTrace();
    			} 
    		} 
    	});
    } 
 public static void main(String args[]) throws IOException { 
	 new EmployeeScreen();
	 }
 } 

