package TDHashProject;
//import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class insert extends JFrame implements ActionListener 
{
    
    private  JLabel name,phone,addr,l1;
    private  JTextField name1,phone1,addr1;
    private  JButton insertion;
    private JButton goback;
    Container con=null;
    String cname="",cphno="",caddr="";

    insert() {
        super("Add Entry in Telephone Directory");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.WHITE);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        l1 = new JLabel("Add Telephone entry");
        l1.setBounds(350,30, 400,150);

        con.add(l1);

        Font font = new Font("Aries", Font.BOLD, 15);
        l1.setFont(font);
        l1.setForeground(Color.BLACK);
        
        name=new JLabel("Enter the Name:");
        name.setBounds(250,200,150,50);
        name.setFont(font);
        name.setForeground(Color.BLACK);
        name1=new JTextField(200);
		name1.setBounds(500,200,250,50);
        name1.setFont(font);
        name1.setForeground(Color.BLACK);

        addr=new JLabel("Enter Address:");
		addr.setBounds(250,300,150,50);
        addr.setFont(font);
        addr.setForeground(Color.BLACK);
		addr1=new JTextField(200);
		addr1.setBounds(500,300,250,50);
        addr1.setFont(font);
        addr1.setForeground(Color.BLACK);

        phone=new JLabel("Enter Phone Number:");
		phone.setBounds(250,400,200,50);
        phone.setFont(font);
        phone.setForeground(Color.BLACK);
		phone1=new JTextField(200);
		phone1.setBounds(500,400,250,50);
        phone1.setFont(font);
        phone1.setForeground(Color.BLACK);

        insertion=new JButton("Add Details \n ");
		insertion.setBounds(550,550,225,30);
		insertion.addActionListener(this);
        insertion.setFont(font);
        insertion.setForeground(Color.BLACK);
        insertion.setBackground(Color.LIGHT_GRAY);

        goback = new JButton("Go back to home \n");
        goback.setBounds(120,550,240,30);
		goback.addActionListener(this);
        goback.setFont(font);
        goback.setForeground(Color.BLACK);
        goback.setBackground(Color.LIGHT_GRAY);

        JLabel jl = new JLabel();
        jl.setBounds(700,500,150,30);

        con.add(name);
		con.add(name1);
		con.add(phone);
		con.add(phone1);
		con.add(addr);
		con.add(addr1);
		con.add(insertion);
        con.add(goback);
    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==insertion)
        {
            try
                {
                    String r; 
                    int i=0;
                    String cname = name1.getText();
                    String cphno = phone1.getText();
                    String caddr = addr1.getText();
                    BufferedReader br = new BufferedReader (new FileReader("input_data.csv"));
                    while((r = br.readLine())!= null) {
                        String[] result = r.split("\\|");
                        String ph1 = result[0];
                        if(cphno.equals(ph1)) {
                            showMessageDialog(null, "An entry already exits for this number with name: "+result[1]);
                        	br.close();
                            return;
                        }
                    } 
                    PrintWriter pw = new PrintWriter(new FileOutputStream(new File("input_data.csv"),true));
                    String b = cname + "," + caddr + "," + cphno;
                    pw.println(b);
                    pw.flush();
                    pw.close();
                    showMessageDialog(null, "Entry done successfully!");
                    return;
                }
            catch(Exception e)
                {System.out.println(e);}
        }  
        
        if(ae.getSource()==goback)
        {
            this.dispose();
			homepage hp=new homepage();
			hp.setSize(1800,790);
			hp.setVisible(true);
        }
    
    }
    public static void main(String args[]) {
        insert ac = new insert();
        ac.setSize(1000,650);
        ac.setVisible(true);
    }
}