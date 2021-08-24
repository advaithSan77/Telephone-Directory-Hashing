package TDHashProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

//public class insert extends JFrame implements ActionListener 
public class delete extends  JFrame implements ActionListener
{
    private JLabel name,l1;
    private JTextField name1;
    private JButton retrieval;
    private JButton goback;

    Container con = null;
    String cname="";

    delete()
    {
        super("Deletion of an entry from Telephone Book \n");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.white);

        con.setSize(275,275);
        con.setLayout(null);
        con.setVisible(true);

        l1 = new JLabel("Enter required Name");
        l1.setBounds(350,30,400,150);

        con.add(l1);

        Font font = new Font("Aries", Font.BOLD,15);
        l1.setFont(font);
        l1.setForeground(Color.DARK_GRAY);

        name=new JLabel("Enter the Name:");
        name.setBounds(150,200,150,50);
        name.setFont(font);
        name.setForeground(Color.BLACK);
        name1=new JTextField(200);
		name1.setBounds(350,200,250,40);
        name1.setFont(font);
        name1.setForeground(Color.BLACK);

        retrieval = new JButton("Delete Record \n");
        retrieval.setBounds(400,550,225,30);
        retrieval.addActionListener(this);
        retrieval.setFont(font);
        retrieval.setForeground(Color.BLACK);
        retrieval.setBackground(Color.DARK_GRAY);

        goback = new JButton("Go back to home \n");
        goback.setBounds(100,550,240,30);
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
        if(ae.getSource()==retrieval)
        {
            try
            {
                String r;
                int i=0;
                String cname=name1.getText();
                File file = new File("input_data.csv");
                BufferedReader br = new BufferedReader(new FileReader(file));
                File temp = new File("temp.txt");
                PrintWriter pw = new PrintWriter(temp);
                while((r = br.readLine())!= null)
                {
                    String [] result = r.split(",");
                    String ch1 = result[0];
                    if (cname.equals(ch1))
                    {
                        showMessageDialog(null, "An entry exists for the name that will be deleted: "+result[0]);
                        continue;
                    }
                    else
                    {
                        pw.println(r);
                    }
                }
                pw.flush();
                pw.close();
                br.close();
                file.delete();
                temp.renameTo(file);
                showMessageDialog(null,"Record Deleted");

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
        delete ac = new delete();
        ac.setSize(700,700);
        ac.setVisible(true);
    }
}