import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class Sigh_Up extends JFrame implements ActionListener {

   static JLabel Form_number;

    long random;

    JLabel Name_label;
    JTextField Name_Filed;

    JLabel Father_label;
    JTextField Father_Filed;

    JLabel Gmail_label;
    JTextField Gmail_Field;

    JLabel Drop_label;
    JComboBox dropbox;

    JLabel Address_label;
    JTextField Address_Field;

    JLabel State_label;
    JTextField State_Field;

    JLabel pin_label;
    JTextField pin_Field;

    JLabel Gender_label;
    JRadioButton Gender;
    JRadioButton Other;
    JRadioButton Female;
    JRadioButton Male;

    JLabel DOB_label;
    JDateChooser dateChooser;

    JPanel panel;

    JButton Next_pg;

    Sigh_Up() {


        panel = new JPanel();

        Random ran = new Random();

        random = Math.abs((ran.nextLong() % 9000L) + 1000);
/*
        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg)); */

        Form_number = new JLabel("The Applicatation no. is " + random);
        Form_number.setBounds(140, 20, 600, 40);
        Form_number.setFont(new Font("railway", Font.BOLD, 21));
        add(Form_number);

        JLabel Personal_Details = new JLabel("Page 1 ");
        Personal_Details.setBounds(200, 80, 400, 30);
        Personal_Details.setFont(new Font("railway", Font.ITALIC, 32));
        add(Personal_Details);

        Name_label = new JLabel("Name");
        Name_label.setBounds(100, 140, 200, 30);
        Name_label.setFont(new Font("railway", Font.BOLD, 21));
        add(Name_label);

        Name_Filed = new JTextField();
        Name_Filed.setBounds(240, 140, 400, 30);
        Name_Filed.setFont(new Font("railway", Font.BOLD, 21));
        add(Name_Filed);

        Father_label = new JLabel("Father Name");
        Father_label.setBounds(100, 190, 200, 30);
        Father_label.setFont(new Font("railway", Font.BOLD, 21));
        add(Father_label);

        Father_Filed = new JTextField();
        Father_Filed.setBounds(240, 190, 400, 30);
        Father_Filed.setFont(new Font("railway", Font.BOLD, 21));
        add(Father_Filed);

        DOB_label = new JLabel("DATE OF BIRTH ");
        DOB_label.setBounds(100, 240, 200, 30);
        DOB_label.setFont(new Font("railway", Font.BOLD, 21));
        add(DOB_label);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 200, 30);
        add(dateChooser);


        Gender_label = new JLabel("Gender");
        Gender_label.setBounds(100, 290, 200, 30);
        Gender_label.setFont(new Font("railway", Font.BOLD, 21));
        add(Gender_label);

        Male = new JRadioButton("Male ");
        Male.setBounds(250, 290, 90, 30);
        Male.setFont(new Font("Railway", Font.PLAIN, 16));
        Male.setForeground(Color.black);
        add(Male);

        Female = new JRadioButton("Female ");
        Female.setBounds(360, 290, 90, 30);
        Female.setFont(new Font("Railway", Font.PLAIN, 16));
        Female.setForeground(Color.black);
        add(Female);

        Other = new JRadioButton("Other ");
        Other.setBounds(470, 290, 90, 30);
        Other.setFont(new Font("Railway", Font.PLAIN, 16));
        Other.setForeground(Color.black);
        add(Other);

        ButtonGroup BG = new ButtonGroup();
        BG.add(Male);
        BG.add(Female);
        BG.add(Other);

        Gmail_label = new JLabel("Gmail ID : ");
        Gmail_label.setBounds(100, 340, 200, 30);
        Gmail_label.setFont(new Font("railway", Font.BOLD, 21));
        add(Gmail_label);

        Gmail_Field = new JTextField();
        Gmail_Field.setBounds(240, 340, 300, 30);
        Gmail_Field.setFont(new Font("railway", Font.BOLD, 21));
        add(Gmail_Field);

        Drop_label = new JLabel("fav animal ");
        Drop_label.setBounds(100, 390, 200, 30);
        Drop_label.setFont(new Font("railway", Font.BOLD, 21));
        add(Drop_label);


        String[] animal = {" ","dog", "cat", "human", "bird"};
        JComboBox dropbox = new JComboBox(animal);
        dropbox.setBounds(240, 390, 100, 30);
        add(dropbox);

        Address_label = new JLabel("Address ");
        Address_label.setBounds(100, 440, 200, 30);
        Address_label.setFont(new Font("railway", Font.BOLD, 21));
        add(Address_label);

        Address_Field = new JTextField();
        Address_Field.setBounds(240, 440, 400, 30);
        Address_Field.setFont(new Font("railway", Font.BOLD, 21));
        add(Address_Field);

        State_label = new JLabel("State");
        State_label.setBounds(100, 490, 200, 30);
        State_label.setFont(new Font("railway", Font.BOLD, 21));
        add(State_label);

        State_Field = new JTextField();
        State_Field.setBounds(240, 490, 300, 30);
        State_Field.setFont(new Font("railway", Font.BOLD, 21));
        add(State_Field);

        pin_label = new JLabel("Pin Number");
        pin_label.setBounds(100, 540, 200, 30);
        pin_label.setFont(new Font("railway", Font.BOLD, 21));
        add(pin_label);

        pin_Field = new JTextField();
        pin_Field.setBounds(240, 540, 400, 30);
        pin_Field.setFont(new Font("railway", Font.BOLD, 21));
        add(pin_Field);

        Next_pg = new JButton("NEXT PAGE ");
        Next_pg.setFocusable(false);
        Next_pg.setForeground(Color.WHITE);
        Next_pg.setBackground(Color.BLACK);
        Next_pg.setBounds(600, 590, 100, 30);
        add(Next_pg);
        Next_pg.addActionListener(this);
        panel.setBounds(0, 0, 800, 480);
        add(panel);

        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setSize(800, 680);
        setLocation(300, 90);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Next_pg) {

        java.lang.String Formno = "" + random;
        java.lang.String Name = Name_Filed.getText();
        java.lang.String Father_name = Father_Filed.getText();
        java.lang.String BOD = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        java.lang.String Gender = null;

        if (Male.isSelected()) {
            Gender = "Male";
        }
        if (Female.isSelected()) {
            Gender = "Female";
        }
        if (Other.isSelected()) {
            Gender = "Other ";
        }

        java.lang.String email = Gmail_Field.getText();
        java.lang.String Address = Address_Field.getText();
        java.lang.String State = State_Field.getText();
        java.lang.String Pin_no = pin_Field.getText();


        if (Name_Filed.equals("")) {
            JOptionPane.showMessageDialog(null, "Name Requared");
        } else if (Father_name.equals("")) {
            JOptionPane.showMessageDialog(null, "Father_name Requared");

        } else if (email.equals("")) {
            JOptionPane.showMessageDialog(null, "email Requared");

        } else if (Address.equals("")) {
            JOptionPane.showMessageDialog(null, "Address Requared");

        } else if (State.equals("")) {
            JOptionPane.showMessageDialog(null, "State Requared");

        } else if (Pin_no.equals("")) {
            JOptionPane.showMessageDialog(null, "Pin no Requared");

        } else {
            try {


                DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();

                String q = "insert into sigh1up Values('" + Formno + "', '" + Name + "', '" + Father_name + "', '" + BOD + "', '" + Gender + "', '" + email + "', '" + Address + "', '" + State + "','" + Pin_no + "' )";

                c.s.executeUpdate(q);

                setVisible(false);

                sighup2_pg p2g = new sighup2_pg(Formno);

            } catch (Exception exception) {
                System.out.println(e);

            }

            }

        }
    }
    public static void main(String[] args) {
        Sigh_Up s = new Sigh_Up();

    }
}