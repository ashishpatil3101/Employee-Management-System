package employeeManagementSystem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class RemoveEmployee extends JFrame implements ActionListener {
    Choice C_empid;
    JButton delete ,back;
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel label_emid=new JLabel("Employee ID");
        label_emid.setBounds(50,50,100,30);
        add(label_emid);

        C_empid=new Choice();
        C_empid.setBounds(200,50,150,30);
        add(C_empid);

        try {
            databaseConnection con=new databaseConnection();
            String query="select * from employee";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
                C_empid.add(rs.getString("emid"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        JLabel label_name=new JLabel("Name");
        label_name.setBounds(50,100,100,30);
        add(label_name);

        JLabel lbl_name=new JLabel();
        lbl_name.setBounds(200,100,100,30);
        add(lbl_name);

        JLabel label_Phone=new JLabel("Phone");
        label_Phone.setBounds(50,150,100,30);
        add(label_Phone);

        JLabel lbl_Phone=new JLabel();
        lbl_Phone.setBounds(200,150,100,30);
        add(lbl_Phone);

        JLabel label_email=new JLabel("Email");
        label_email.setBounds(50,200,100,30);
        add(label_email);

        JLabel lbl_email=new JLabel();
        lbl_email.setBounds(200,200,100,30);
        add(lbl_email);

        //
        try {
            databaseConnection con=new databaseConnection();
            String query="select * from employee where emid='"+C_empid.getSelectedItem()+"'";
            ResultSet rs=con.s.executeQuery(query);
            while(rs.next()){
                lbl_name.setText(rs.getString("name"));
                lbl_email.setText(rs.getString("email"));
                lbl_Phone.setText(rs.getString("phone"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        C_empid.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie){
                try {
                    databaseConnection con=new databaseConnection();
                    String query="select * from employee where emid='"+C_empid.getSelectedItem()+"'";
                    ResultSet rs=con.s.executeQuery(query);
                    while(rs.next()){
                        lbl_name.setText(rs.getString("name"));
                        lbl_email.setText(rs.getString("email"));
                        lbl_Phone.setText(rs.getString("phone"));
                    }
                }
                catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //buttons
        delete=new JButton("Delete");
        delete.setBounds(50,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);

        back=new JButton("Back");

        back.setBounds(200,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        //add image

        ImageIcon image1=new ImageIcon(ClassLoader.getSystemResource("icons/delete.png"));
        Image setImage1= image1.getImage().getScaledInstance(600,400,Image.SCALE_DEFAULT);
        ImageIcon image3=new ImageIcon(setImage1);
        JLabel image=new JLabel(image3);
        image.setBounds(350,0,600,400);
        add(image);

        setSize(1000,400);
        setLocation(200,150);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==delete){
            try{
                databaseConnection con=new databaseConnection();
                String query="delete from employee where emid = '"+C_empid.getSelectedItem()+"'";
                con.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Succesfully");
                setVisible(false);
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
        else{
            setVisible(false);
            new HomePage();
        }

    }
    public static void main(String[] args) {

        new RemoveEmployee();
    }
}
