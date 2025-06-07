import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JPanel panel;

    JButton Sigh_button ;
    JButton Loginbutton ;
    JButton Reset_button ;

    JLabel IDlabel ;
    JTextField IDfiled ;

    JLabel passlabel ;
    JPasswordField passwordField ;

    JLabel Backgroundlabel;

    Login(){

        panel = new JPanel();

        ImageIcon icon = new ImageIcon("C:\\Users\\HP\\Downloads\\logo.jpg ") ;
        JLabel iconelabel = new JLabel();
        iconelabel.setBounds(70,10,100,100);

        ImageIcon background = new ImageIcon(" C:\\Users\\HP\\Downloads\\atm.jpg");
        Backgroundlabel = new JLabel(background);
        Backgroundlabel.setBounds(0,0,800,450);
        panel.add(Backgroundlabel);

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        IDlabel = new JLabel("CARD Number");
        IDlabel.setBounds(100, 110, 150, 40);
        IDlabel.setForeground(Color.WHITE);
        IDlabel.setBackground(Color.black);
        IDlabel.setFont(new Font("COWRED",Font.BOLD,14));
        panel.add(IDlabel);

        IDfiled = new JTextField();
        IDfiled.setBounds(210, 110, 250, 30);
        panel.add(IDfiled);

        passlabel = new JLabel("PASSWORD");
        passlabel.setBounds(100, 190, 200, 40);
        passlabel.setForeground(Color.WHITE);
        passlabel.setBackground(Color.black);
        passlabel.setFont(new Font("COWRED",Font.BOLD,14));
        panel.add(passlabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 190, 250, 30);
        panel.add(passwordField);

        Sigh_button = new JButton("SIGH UP ");
        Sigh_button.setBounds(220,290,230,30);
        Sigh_button.setForeground(Color.white);
        Sigh_button.setBackground(Color.black);
        Sigh_button.setFocusable(false);
        Sigh_button.addActionListener(this);
        panel.add(Sigh_button);

        Loginbutton = new JButton("LOGIN IN ");
        Loginbutton.setBounds(220,250,100,30);
        Loginbutton.setBackground(Color.black);
        Loginbutton.setForeground(Color.WHITE);
        Loginbutton.setFocusable(false);
        Loginbutton.addActionListener(this);
        panel.add(Loginbutton);

        Reset_button = new JButton("RESET ");
        Reset_button.setBounds(350,250,100,30);
        Reset_button.setForeground(Color.WHITE);
        Reset_button.setBackground(Color.black);
        Reset_button.setFocusable(false);
        Reset_button.addActionListener(this);
        panel.add(Reset_button);

        JLabel Textlabel = new JLabel(" Enter Your details ");
        Textlabel.setBounds(180,40,400,40);
        Textlabel.setFont(new Font("Osword",Font.ITALIC,20));
        Textlabel.setForeground(Color.WHITE);
        Textlabel.setBackground(Color.black);
        panel.add(Textlabel);

        panel.setBounds(0, 0, 800, 480);
        panel.setOpaque(false); // Make the panel transparent
        panel.setLayout(null);
        add(panel);

        setSize(800,480);
        setTitle("Umm Bank Management");
        setLocation(300,150);
        // getContentPane().setBackground(Color.black);


        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Sigh_button){
            setVisible(false);
            Sigh_Up sigh = new Sigh_Up();
        } else if (e.getSource()==Reset_button) {
            IDfiled.setText(" ");
            passwordField.setText(" ");
        } else if (e.getSource()==Loginbutton) {

            DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
            java.lang.String cardNum = IDfiled.getText();
            java.lang.String pin = passwordField.getText();
            String q = "SELECT * FROM LOGIN_1 WHERE cardNum = '" + cardNum + "' AND pin = '" + pin + "'";

            try {
                ResultSet rs = c.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new Trans( pin).setVisible(true);
                }
             else {
                 JOptionPane.showMessageDialog(null,"Incorrect Cardnumber  or pin");
                }
            }catch (Exception ae){
                System.out.println(ae);
            }
        }
        }

    public static void main(String[] args) {
        Login L = new Login( );
}
        }


