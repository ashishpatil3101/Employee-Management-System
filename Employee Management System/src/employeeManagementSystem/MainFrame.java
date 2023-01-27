package employeeManagementSystem;

import javax.swing.*;
import  java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {
    //constructor will be called here
    MainFrame(){

        //build Opening Frame
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);


        //content  on Opening Frame
        JLabel heading=new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        //where should the component place
        //(left,top,(components width,heigh));
        heading.setBounds(80,30,1200,60);
        //content font style
        heading.setFont(new Font("serif",Font.PLAIN,60));
        heading.setForeground(Color.RED);
        //adding every component we must use add  method
        add(heading);


        //placing background (img)
        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image setImage1= image1.getImage().getScaledInstance(1100,700,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(setImage1);
        JLabel image=new JLabel(image3);
        image.setBounds(50,100,1050,500);
        add(image);

        //adding buttonns
        JButton continue_button=new JButton("CLICK HERE TO CONTINUE");
        continue_button.setBounds(400,400,300,70);
        continue_button.setBackground(Color.BLACK);
        continue_button.setForeground(Color.WHITE);
        continue_button.addActionListener(this);
        image.add(continue_button);

        setSize(1170,650);
        setVisible(true);

        //where should the frame will open on window
        //(from left,from top)
        setLocation(100,50);


    }
    public  void actionPerformed(ActionEvent ae){
        //we will erase the opening frame as admin clicks the continue button
        setVisible(false);
        //jump to next frame
        new LoginFrame();

    }

    public static void main(String[] args) {


        new MainFrame();

    }
}
