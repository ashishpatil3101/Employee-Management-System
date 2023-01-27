package employeeManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    JButton view_employee,add_employee,remove_employee,update_employee;

    //constructor
    HomePage(){
        setLayout(null);

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image setImage1= image1.getImage().getScaledInstance(1120,630,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(setImage1);
        JLabel image=new JLabel(image3);
        image.setBounds(0,0,1120,630);
        add(image);

        JLabel heading=new JLabel("Employee Management System");
        heading.setBounds(650,20,400,40);
        heading.setFont(new Font("serif",Font.BOLD,25));
        image.add(heading);

        //buttons add,view
        //add
        add_employee=new JButton("Add Employee");
        add_employee.setBounds(650,80,150,40);
        add_employee.addActionListener(this);
        image.add(add_employee);
        //view
        view_employee=new JButton("View Employee");
        view_employee.setBounds(820,80,150,40);
        view_employee.addActionListener(this);
        image.add(view_employee);
        //update
        update_employee=new JButton("Update Employee");
        update_employee.setBounds(650,140,150,40);
        update_employee.addActionListener(this);
        image.add(update_employee);

        //remove button
        remove_employee=new JButton("Remove Employee");
        remove_employee.setBounds(820,140,150,40);
        remove_employee.addActionListener(this);
        image.add(remove_employee);


        setSize(1120,630);
        setLocation(100,100);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        //to diff bet multiple button use getsource method
        if(ae.getSource()==add_employee){
            setVisible(false);
            new AddEmployee();

        }
        else if(ae.getSource()==view_employee){
            setVisible(false);
            new ViewEmployee();

        }
        else if(ae.getSource()==update_employee){
            setVisible(false);
            new ViewEmployee();

        }
        else{
            setVisible(false);
            new RemoveEmployee();

        }

    }
    public static void main(String[] args) {
        new HomePage();

    }
}
