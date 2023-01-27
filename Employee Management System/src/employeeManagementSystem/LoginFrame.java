package employeeManagementSystem;

import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.*;

//create login page
public class LoginFrame extends JFrame implements ActionListener {
    JTextField  inputBox_userName;
    JTextField  password_textField;

    //constructor
    LoginFrame(){

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel user_name=new JLabel("User Name");
        user_name.setBounds(40,20,100,30);
        add(user_name);

        //taking input username
        inputBox_userName=new JTextField();
        inputBox_userName.setBounds(150,20,150,30);
        add(inputBox_userName);

        //input for password
        JLabel password_text=new JLabel("Password");
        password_text.setBounds(40,70,100,30);
        add(password_text);

        //addind textfield (for input)
        password_textField=new JTextField();
        password_textField.setBounds(150,70,150,30);
        add(password_textField);

        JButton submit_button=new JButton("Log in");
        submit_button.setBounds( 150,140,150,30);
        submit_button.setBackground(Color.BLACK);
        submit_button.setForeground(Color.WHITE);
        submit_button.addActionListener(this);
        add(submit_button);
        //adding image on frame
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image setImage1= image1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(setImage1);
        JLabel image=new JLabel(image3);
        image.setBounds(350,0,200,200);
        add(image);



        setSize(600,300);
        setLocation(450,200);
        setVisible(true);
    }

    //override method

    public void actionPerformed(ActionEvent ae){
        try{
            String get_username=inputBox_userName.getText();
            String get_password=password_textField.getText();

            databaseConnection con=new databaseConnection();
            //create  query(sql)
            String query="select * from login where username='"+get_username+"'and password='"+get_password+"'";

            ResultSet rs=con.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                //value enetered
                //move to next frame which is home
                new HomePage();
            }
            else{
                JOptionPane.showMessageDialog(null,"Invalid username or password");
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        new LoginFrame();
    }

}
