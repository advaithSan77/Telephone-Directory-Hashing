package TDHashProject;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

public class homepage extends JFrame implements ActionListener
{
    private JButton b0,b1,b2,b3,b4;

    homepage()
    {
        super("Telephone Directory System");
        Container con = getContentPane();
        con.setLayout(null);
        con.setBackground(Color.white);

        JLabel label1;
        label1 = new JLabel("TELEPHONE DIRECTORY : ");
        label1.setBounds(740,100, 400,150);
        con.add(label1);
        con.setSize(300,300);
        con.setLayout(null);
        con.setVisible(true);
        Font font = new Font("Ariel", Font.BOLD, 20);
        label1.setFont(font);
        label1.setForeground(Color.BLACK);

        b0 = new JButton("Insert Telephone directory details");
        b0.addActionListener(this);
		b0.setBounds(20,350, 400,150);
        Font font1 = new Font("Verdana", Font.BOLD, 16);
        b0.setFont(font1);
        b0.setForeground(Color.BLACK);
        b0.setBackground(Color.LIGHT_GRAY);


        b1 = new JButton("Retrieve Telephone Directory Details:\n");
        b1.addActionListener(this);
		b1.setBounds(460,350, 400,150);
        //Font font1 = new Font("Verdana", Font.BOLD, 16);
        b1.setFont(font1);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.LIGHT_GRAY);

        b2= new JButton("Delete Telephone Directory Detail:\n");
        b2.addActionListener(this);
		b2.setBounds(900,350, 400,150);
        b2.setFont(font1);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.LIGHT_GRAY);

        b3 = new JButton("Display Telephone directory details");
        b3.addActionListener(this);
		b3.setBounds(1330,350, 400,150);
        b3.setFont(font1);
        b3.setForeground(Color.BLACK);
        b3.setBackground(Color.LIGHT_GRAY);

        b4 = new JButton("Exit Application");
        b4.addActionListener(this);
		b4.setBounds(700,550, 400,150);
        b4.setFont(font1);
        b4.setForeground(Color.BLACK);
        b4.setBackground(Color.LIGHT_GRAY);


        con.add(b0);
        con.add(b1);
        con.add(b2);
        con.add(b3);
        con.add(b4);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b0)
		{
			this.dispose();
			insert ac=new insert();
			ac.setSize(1000,650);
			ac.setVisible(true);
		}

        if(ae.getSource()==b1)
        {
            this.dispose();
            retrieve ac = new retrieve();
            ac.setSize(650,700);
			ac.setVisible(true);
        }
        if(ae.getSource()==b2)
        {
            this.dispose();
            delete ac = new delete();
            ac.setSize(700,700);
			ac.setVisible(true);
        }
        if(ae.getSource()==b3)
        {
            this.dispose();
            Display ac = new Display();
            ac.setSize(1500,800);
			ac.setVisible(true);
        }
        if(ae.getSource()==b4)
        {
            this.dispose();
        }
    }
    public static void main(String []args)
	{
        homepage h=new homepage();
		h.setSize(1800,790);
		h.setVisible(true);
	}

}