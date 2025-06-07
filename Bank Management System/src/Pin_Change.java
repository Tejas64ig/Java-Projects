import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin_Change extends JFrame implements ActionListener {
    JPanel p;
    JLabel Tittle_label;

    JLabel pin_lb;
    JPasswordField pin_passfield;

    JLabel Re_new_pinLabel;
    JPasswordField Re_new_pinTextFiled;

    JButton Change_Button;
    JButton Back_Button;

    String pinnumber;

    Pin_Change(String pinnumber) {

        this.pinnumber = pinnumber;

        p = new JPanel();
        setTitle("reset PIN ");

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        Tittle_label = new JLabel("Reset your pin ");
        Tittle_label.setBounds(200, 170, 500, 35);
        Tittle_label.setForeground(Color.white);
        Tittle_label.setBackground(Color.black);
        Tittle_label.setFont(new Font("Railway", Font.ITALIC, 22));
        p.add(Tittle_label);

        pin_lb = new JLabel("New Pin ");
        pin_lb.setBounds(80, 230, 200, 30);
        pin_lb.setForeground(Color.white);
        pin_lb.setBackground(Color.black);
        pin_lb.setFont(new Font("Railway", Font.ITALIC, 22));
        p.add(pin_lb);

        pin_passfield = new JPasswordField();
        pin_passfield.setBounds(240, 230, 130, 25);
        p.add(pin_passfield);

        Re_new_pinLabel = new JLabel("Re-Enter PIN");
        Re_new_pinLabel.setBounds(80, 300, 200, 30);
        Re_new_pinLabel.setForeground(Color.white);
        Re_new_pinLabel.setBackground(Color.black);
        Re_new_pinLabel.setFont(new Font("Railway", Font.ITALIC, 22));
        p.add(Re_new_pinLabel);

        Re_new_pinTextFiled = new JPasswordField();
        Re_new_pinTextFiled.setBounds(240, 300, 180, 25);
        p.add(Re_new_pinTextFiled);

        Change_Button = new JButton("Submit");
        Change_Button.setBounds(370, 390, 90, 30);
        Change_Button.setFocusable(false);
        Change_Button.setForeground(Color.WHITE);
        Change_Button.setBackground(Color.black);
        Change_Button.addActionListener(this);
        p.add(Change_Button);

        Back_Button = new JButton("Back");
        Back_Button.setBounds(370, 430, 90, 30);
        Back_Button.setFocusable(false);
        Back_Button.setForeground(Color.WHITE);
        Back_Button.setBackground(Color.black);
        Back_Button.addActionListener(this);
        p.add(Back_Button);

        p.setBounds(0, 0, 800, 720);
        p.setOpaque(false);
        p.setLayout(null);
        add(p);

        setLayout(null);
        setSize(800, 720);
        setLocation(300, 60);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Change_Button) {
            try {
                String New_pin = pin_passfield.getText();
                String Re_NEW_pin = Re_new_pinTextFiled.getText();

                if (!New_pin.equals(Re_NEW_pin)) {
                    JOptionPane.showMessageDialog(null, "The Entered pin does not match");
                    return;
                }
                if (New_pin.equals("")) {

                    JOptionPane.showMessageDialog(null, " Entered a pin ");
                } else {


                    DATA_BASE_CONNECTIVITY db = new DATA_BASE_CONNECTIVITY();

                    String query1 = " update bank set pin = '" + New_pin + "' where pin='" + pinnumber + "'";
                    String query2 = " update login set pin = '" + New_pin + "' where pin='" + pinnumber + "'";
                    String query3 = " update Sighup_3pg set pin = '" + New_pin + "' where pin='" + pinnumber + "'";
                    db.s.executeUpdate(query1);
                    db.s.executeUpdate(query2);
                    db.s.executeUpdate(query3);
                    JOptionPane.showMessageDialog(null, "Pin changed sucessfully ");
                    setVisible(false);
                    new Trans(New_pin).setVisible(true);
                }
            } catch (Exception ae) {
                System.out.println(ae);
            }
        }

        if (e.getSource() == Back_Button) {
            setVisible(false);
            new Trans(pinnumber).setVisible(true);
        }
    }


    public static void main(String[] args) {
        Pin_Change p = new Pin_Change( "");
        }


}
