import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class CashWithdraw extends JFrame implements ActionListener {

    String pinnumber;

    JTextField amo_filed;

    JButton Submit_vutton;
    JButton Back_b;

    CashWithdraw(String pinnumber) {

        this.pinnumber = pinnumber;

        JPanel p = new JPanel();
        setTitle("Withdraw Your cash ");

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        JLabel te_l = new JLabel("Withdrawal Amount ");
        te_l.setBounds(80, 170, 200, 30);
        te_l.setForeground(Color.WHITE);
        te_l.setBackground(Color.BLACK);
        te_l.setFont(new Font("railway", Font.ITALIC, 21));
        p.add(te_l);

        amo_filed = new JTextField();
        amo_filed.setBounds(280, 170, 150, 30);
        p.add(amo_filed);

        Submit_vutton = new JButton("Withdraw");
        Submit_vutton.setBounds(370, 390, 90, 30);
        Submit_vutton.setForeground(Color.WHITE);
        Submit_vutton.setBackground(Color.black);
        Submit_vutton.setFocusable(false);
        Submit_vutton.addActionListener(this);
        p.add(Submit_vutton);


        Back_b = new JButton("Back");
        Back_b.setBounds(370, 430, 90, 30);
        Back_b.setForeground(Color.WHITE);
        Back_b.setBackground(Color.BLACK);
        Back_b.setFocusable(false);
        Back_b.addActionListener(this);
        p.add(Back_b);
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
        if (e.getSource() == Submit_vutton) {
            String amo = amo_filed.getText();
            Date fate = new Date();
            if (amo.equals("")) {
                JOptionPane.showMessageDialog(null, "Krupa amo daloo  ree ");

            } else {
                try {
                    DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
                    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amo"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amo"));
                        }
                    }
                    if (balance < Integer.parseInt(amo)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c.s.executeUpdate("insert into bank values('" + pinnumber + "', '" + fate + "', 'Withdrawl', '" + amo + "')");
                    JOptionPane.showMessageDialog(null, "Rs. " + amo + " Debited Successfully");

                    setVisible(false);
                    Trans tr = new Trans(pinnumber);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
            }


        else if (e.getSource() == Back_b) {
            setVisible(false);
            new Trans(  pinnumber).setVisible(true);

        }
    }

    public static void main(String[] args) {
        new CashWithdraw("");
    }
}