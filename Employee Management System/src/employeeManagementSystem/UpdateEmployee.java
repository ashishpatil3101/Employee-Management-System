package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;


import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.*;
import  java.util.*;

public class UpdateEmployee extends JFrame implements ActionListener {

    JButton add_details,back;
    JTextField tf_education,tfname,tf_father_name,tf_salary,tf_address,tf_email,tf_phone,tf_aadhar,tf_designation;


    JLabel lbl_emid;
    String EMID;

    UpdateEmployee(String EMID){
        this.EMID=EMID;
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        //
        JLabel heading =new JLabel("Update Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.BOLD,25));
        add(heading);

        //employees details will fill here
        JLabel label_name=new JLabel("Name");
        label_name.setBounds(50,150,150,30);
        label_name.setFont(new Font("serif",Font.PLAIN,20));
        add(label_name);

        //
        JLabel lbl_name=new JLabel();
        lbl_name.setBounds(250,150,150,30);
        add(lbl_name);
        //father name
        JLabel Father_name=new JLabel("Father's Name");
        Father_name.setBounds(450,150,150,30);
        Father_name.setFont(new Font("serif",Font.PLAIN,20));
        add(Father_name);


        tf_father_name=new JTextField();
        tf_father_name.setBounds(650,150,150,30);
        add(tf_father_name);

        //dob
        JLabel label_dob=new JLabel("Date Of Birth");
        label_dob.setBounds(50,200,150,30);
        label_dob.setFont(new Font("serif",Font.PLAIN,20));
        add(label_dob);

        JLabel lbl_dcdob=new JLabel();
        lbl_dcdob.setBounds(250,200,150,30);
        add(lbl_dcdob);

        //salary
        JLabel label_salary=new JLabel("Salary");
        label_salary.setBounds(450,200,150,30);
        label_salary.setFont(new Font("serif",Font.PLAIN,20));
        add(label_salary);


        tf_salary=new JTextField();
        tf_salary.setBounds(650,200,150,30);
        add(tf_salary);

        //address

        JLabel label_address=new JLabel("Address");
        label_address.setBounds(50,250,150,30);
        label_address.setFont(new Font("serif",Font.PLAIN,20));
        add(label_address);


        tf_address=new JTextField();
        tf_address.setBounds(250,250,150,30);
        add(tf_address);

        //Phone no
        JLabel label_phone=new JLabel("Phone No");
        label_phone.setBounds(450,250,150,30);
        label_phone.setFont(new Font("serif",Font.PLAIN,20));
        add(label_phone);


        tf_phone=new JTextField();
        tf_phone.setBounds(650,250,150,30);
        add(tf_phone);

        //email
        JLabel label_email=new JLabel("Email");
        label_email.setBounds(50,300,150,30);
        label_email.setFont(new Font("serif",Font.PLAIN,20));
        add(label_email);

        tf_email=new JTextField();
        tf_email.setBounds(250,300,150,30);
        add(tf_email);

        //education qualification
        JLabel label_education=new JLabel("Education");
        label_education.setBounds(450,300,150,30);
        label_education.setFont(new Font("serif",Font.PLAIN,20));
        add(label_education);

        String[] courses={"BTECH","MBA","BBA","BSC","MSC"};
        tf_education=new JTextField();
        tf_education.setBackground(Color.WHITE);
        tf_education.setBounds(650,300,150,30);
        add(tf_education);

        //designation
        JLabel label_designation=new JLabel("Designation");
        label_designation.setBounds(50,350,150,30);
        label_designation.setFont(new Font("serif",Font.PLAIN,20));
        add(label_designation);


        tf_designation=new JTextField();
        tf_designation.setBounds(250,350,150,30);
        add(tf_designation);

        //Aadhar no
        JLabel label_aadhar=new JLabel("Aadhar Number");
        label_aadhar.setBounds(450,350,150,30);
        label_aadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(label_aadhar);

        JLabel lbl_aadhar=new JLabel();
        lbl_aadhar.setBounds(650,350,150,30);
        add(lbl_aadhar);

        //employee id
        JLabel label_emid=new JLabel("Employee ID");
        label_emid.setBounds(50,400,150,30);
        label_emid.setFont(new Font("serif",Font.PLAIN,20));
        add(label_emid);

        lbl_emid=new JLabel();
        lbl_emid.setBounds(250,400,150,30);
        label_designation.setFont(new Font("serif",Font.PLAIN,20));
        add(lbl_emid);
        try{
            databaseConnection con=new databaseConnection();
            String query="select * from employee where emid='"+EMID+"'";
            ResultSet rs=con.s.executeQuery(query);

            while(rs.next()){
                lbl_name.setText(rs.getString("name"));
                tf_father_name.setText(rs.getString("fname"));
                lbl_dcdob.setText(rs.getString("dob"));
                tf_salary.setText(rs.getString("salary"));
                tf_address.setText(rs.getString("adress"));
                tf_education.setText(rs.getString("education"));
                tf_email.setText(rs.getString("email"));
                lbl_aadhar.setText(rs.getString("aadhar"));
                tf_phone.setText(rs.getString("phone"));
                tf_designation.setText(rs.getString("designation"));
                lbl_emid.setText(rs.getString("emid"));



            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


        //buttons after adding details
        add_details=new JButton("Update Details");
        add_details.setBounds(250,500,150,40);
        add_details.setBackground(Color.BLACK);
        add_details.setForeground(Color.WHITE);
        add_details.addActionListener(this);
        add(add_details);

        back=new JButton("BACK");
        back.setBounds(450,500,150,40);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        setSize(900,600);
        setLocation(300,50);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==add_details){

            String Father_name=tf_father_name.getText();

            String salary=tf_salary.getText();
            String address=tf_address.getText();
            String phone=tf_phone.getText();
            String email=tf_email.getText();
           String education=tf_education.getText();
            String designation=tf_designation.getText();



            try{

                databaseConnection conn=new databaseConnection();
                String query="update  employee  set  fname='"+Father_name+"',salary='"+salary+"',adress='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',designation='"+designation+"' where emid='"+EMID+"'";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Details Update succesfully");
                setVisible(false);
                new HomePage();
            }
            catch (Exception e){
                e.printStackTrace();

            }


        }else {
            setVisible(false);
            new HomePage();
        }

    }
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}

