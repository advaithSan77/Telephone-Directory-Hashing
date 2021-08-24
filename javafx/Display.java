package TDHashProject;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
//import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

public class Display extends JFrame implements ActionListener 
{
    private JLabel displayheading;
    private JTextArea output;
    private JButton display,goback;

    Container con = null;

    Display()
    {
        super("Display Telephone Database Records: ");
        con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.LIGHT_GRAY);

        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);

        Font font = new Font("Ariel", Font.BOLD, 16);

        displayheading=new JLabel("The Database records are: \n");
        displayheading.setBounds(200, 2, 700,150);
        displayheading.setFont(font);
        displayheading.setForeground(Color.BLACK);

        output=new JTextArea();
        output.setBounds(200, 150, 900,400);
        output.setFont(font);
        output.setForeground(Color.BLACK);
        output.setEditable(false);

        display = new JButton("Display");
		display.setBounds(400,600,150,40);
		display.addActionListener(this);
        display.setFont(font);
        display.setForeground(Color.BLACK);
        display.setBackground(Color.DARK_GRAY);

        goback = new JButton("Go Back");
		goback.setBounds(600,600,150,40);
		goback.addActionListener(this);
        goback.setFont(font);
        goback.setForeground(Color.BLACK);
        goback.setBackground(Color.LIGHT_GRAY);

        con.add(displayheading);
		con.add(output);
        con.add(display);
        con.add(goback);

    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==display)
        {
			try
            {
                String name="",number="",address="",r;
                File temp = new File("temp.txt");
                Boolean createNewFile1 = temp.createNewFile();
                BufferedReader br = new BufferedReader(new FileReader("input_data.csv"));
                BufferedWriter pw = new BufferedWriter(new FileWriter("temp.txt"));
                String b = "Name \t \tAddress \t\t Number \n";
                pw.write(b+"\n");
                while((r= br.readLine()) !=null)
		        {
		        	String[] result = r.split(",");
                    name = result[0];
                    address = result[1];
                    number =  result[2];
                    String bb = name+ "\t\t"+ address+ "\t" + number;
                    System.out.println(bb);
                    pw.write(bb);
                    pw.write("\n");
                }
                br.close();
                pw.close();
                File file = new File("temp.txt");
                BufferedReader br1 = new BufferedReader(new FileReader(file));
                output.read(br1,null);
                br1.close(); 
                output.requestFocus();
    
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
        Display ac = new Display();
        ac.setSize(1500,800);
        ac.setVisible(true);
    }
}
