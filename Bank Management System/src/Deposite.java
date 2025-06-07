import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener {


    JLabel amo_l;
    JTextField amo_t;

    JButton Deposite_b;
    JButton Back_b;

  String pinnumber;

    Deposite(String pinnumber ) {

        this.pinnumber = pinnumber;
        JPanel p = new JPanel();

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        JLabel te_l = new JLabel("Deposite Amount");
        te_l.setBounds(80, 170, 200, 30);
        te_l.setForeground(Color.WHITE);
        te_l.setBackground(Color.BLACK);
        te_l.setFont(new Font("railway", Font.ITALIC, 21));
        p.add(te_l);

        amo_t = new JTextField();
        amo_t.setBounds(280, 170, 150, 30);
        p.add(amo_t);

        Deposite_b = new JButton("Deposite ");
        Deposite_b.setBounds(370, 390, 90, 30);
        Deposite_b.setForeground(Color.WHITE);
        Deposite_b.setBackground(Color.black);
        Deposite_b.setFocusable(false);
        Deposite_b.addActionListener(this);
        p.add(Deposite_b);

        Back_b = new JButton("Back  ");
        Back_b.setBounds(370, 430, 90, 30);
        Back_b.setForeground(Color.WHITE);
        Back_b.setBackground(Color.BLACK);
        Back_b.setFocusable(false);

        Back_b.addActionListener(this);
        p.add(Back_b);

        p.setBounds(0, 0, 800, 720);
        p.setOpaque(false);
        p.setLayout(null);
        // add(logo);
        add(p);

        setLayout(null);
        setSize(800, 720);
        setLocation(300, 60);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Deposite_b) {
            String amo = amo_t.getText();

            Date fate = new Date();
            if (amo.equals("")) {
                JOptionPane.showMessageDialog(null, "Krupa amo enter karo ree ");

            }
            else {
                try {
                    DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
                   // java.sql.Timestamp sqlDate = new java.sql.Timestamp(fate.getTime());
                    String q = "insert into bank values('"+pinnumber+"', '"+fate+"', 'Deposit', '"+amo+"')";
                     c.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Rs. "+amo+" Deposited Successfully");
                    setVisible(false);
                    new Trans(pinnumber).setVisible(true);
 } catch (Exception ex) {
                    ex.printStackTrace();
                    setVisible(false);
                    new Trans(  pinnumber).setVisible(true);
                }
            }
        }
        else if (e.getSource() == Back_b) {
            setVisible(false);
             new Trans(  pinnumber).setVisible(true);

        }
    }
    public static void main(String[] args) {
        Deposite P= new Deposite( "");

}

}