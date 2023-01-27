package employeeManagementSystem;

import com.mysql.cj.protocol.Resultset;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ViewEmployee extends JFrame implements ActionListener {

    JTable table;
    Choice cemployee_id;
    JButton Search,print,update,back;



    //constructor
    ViewEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel search=new JLabel("Search by employee id");
        search.setBounds(20,20,150,20);
        add(search);

        cemployee_id=new Choice();
        cemployee_id.setBounds(180,20,150,20);
        add(cemployee_id);
        try {
            databaseConnection con = new databaseConnection();


            ResultSet rs =con.s.executeQuery("select * from employee");

            while(rs.next()){
                cemployee_id.add(rs.getString("emid"));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }


        table=new JTable();
        try {
            databaseConnection con = new databaseConnection();


            ResultSet rs =con.s.executeQuery("select * from employee");

            table.setModel(DbUtils.resultSetToTableModel(rs));

        }
        catch (Exception e){
            e.printStackTrace();
        }
        //to make content visible proeprly
        JScrollPane  jsp=new JScrollPane(table);
        jsp.setBounds(0,100,900,600);
        add(jsp);

        //buttons
        Search =new JButton("Search");
        Search.setBounds(20,70,80,20);
        Search.addActionListener(this);
        add(Search);

        print =new JButton("Print");
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        update =new JButton("Update");
        update.setBounds(220,70,80,20);
        update.addActionListener(this);
        add(update);

        back =new JButton("Back");
        back.setBounds(320,70,80,20);
        back.addActionListener(this);
        add(back);




        setSize(900,700);
        setLocation(300,100);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == Search){

            //query
            String query="select * from employee where emid='"+ cemployee_id.getSelectedItem()+"'";
            try{
                databaseConnection conn=new databaseConnection();
                ResultSet rs=conn.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));

            }
            catch(Exception e){
                e.printStackTrace();
            }

        }
        else if(ae.getSource()==update){
            setVisible(false);
            new UpdateEmployee(cemployee_id.getSelectedItem());

        }
        else if(ae.getSource()==back){
            setVisible(false);
            new HomePage();
        }
        else{
            try{
                table.print();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        new ViewEmployee();

    }
}
