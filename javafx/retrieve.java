package TDHashProject;

import java.awt.*;

//import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.Arrays;
import java.util.*;

import static javax.swing.JOptionPane.showMessageDialog;

//public class insert extends JFrame implements ActionListener 
public class retrieve extends  JFrame implements ActionListener
{
    private JLabel name,l1;
    private JTextField name1;
    private JButton retrieval;
    private JButton goback;

    Container con = null;
    //String cname="";
    
    retrieve()
    {
        super("Retrieval of entry from Telephone Book \n");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.WHITE);

        con.setSize(350,350);
        con.setLayout(null);
        con.setVisible(true);

        l1 = new JLabel("Enter required Name");
        l1.setBounds(330,30,400,150);

        con.add(l1);

        Font font = new Font("Aries", Font.BOLD,15);
        l1.setFont(font);
        l1.setForeground(Color.DARK_GRAY);

        name=new JLabel("Enter the Name:");
        name.setBounds(50,200,250,50);
        name.setFont(font);
        name.setForeground(Color.BLACK);
        name1=new JTextField(200);
		name1.setBounds(330,200,250,30);
        name1.setFont(font);
        name1.setForeground(Color.BLACK);

        retrieval = new JButton("Retrieve Record \n");
        retrieval.setBounds(300,550,225,30);
        retrieval.addActionListener(this);
        retrieval.setFont(font);
        retrieval.setForeground(Color.BLACK);
        retrieval.setBackground(Color.DARK_GRAY);

        goback = new JButton("Go back to home \n");
        goback.setBounds(50,550,200,30);
		goback.addActionListener(this);
        goback.setFont(font);
        goback.setForeground(Color.BLACK);
        goback.setBackground(Color.LIGHT_GRAY);

        JLabel jl = new JLabel();
        jl.setBounds(750,550,150,30);

        con.add(name);
        con.add(name1);
        con.add(retrieval);
        con.add(goback);

    }

    public void actionPerformed(ActionEvent ae)
    {
        //String[] data = new String[12];
        ArrayList<String> data = new ArrayList<>();
        String[] result;
        if(ae.getSource()==retrieval)
        {
            try
            {
                String r;
                
                String cname=name1.getText();
                BufferedReader br = new BufferedReader( new FileReader("input_data.csv"));
                while((r = br.readLine())!= null)
                {
                    data.add(r);
                }
                System.out.println(data);
                boolean b = false;
                for(String line:data)
                {
                    result = line.split(",");
                    String ch1 = result[0];
                    if(cname.equals(ch1))
                    {
                        showMessageDialog(null,"Entry does exist for current"+" Name: "+ result[0]+ " Address: "+ result[1]+ " Number: "+result[2]+"\n");
                        return;
                    }           
                }
                showMessageDialog(null, "Entry does not exist for current "+"Name: "+cname);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
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
        retrieve ac = new retrieve();
        ac.setSize(650,700);
        ac.setVisible(true);
    }
}
