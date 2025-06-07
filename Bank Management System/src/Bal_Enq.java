import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bal_Enq extends JFrame implements ActionListener {

    JButton Back_Button;

    String pinnumber;

    Bal_Enq( String pinnumber)  {
        this.pinnumber = pinnumber;
    JPanel p = new JPanel();

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        Back_Button = new JButton();
        Back_Button.setBounds(355,520,150,30);
        Back_Button.setFocusable(false);
        Back_Button.setForeground(Color.WHITE);
        Back_Button.setBackground(Color.black);
        Back_Button.addActionListener(this);
        p.add(Back_Button);


        DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
        int balance = 0;
try {
    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
    while (rs.next()) {
        if (rs.getString("type").equals("Deposit")) {
            balance += Integer.parseInt(rs.getString("amo"));
        } else {
            balance -= Integer.parseInt(rs.getString("amo"));
        }
    }
}
   catch (Exception ex ){
       ex.printStackTrace();
}

 JLabel text = new JLabel("you'r current balance is "+balance+" "+"rs");
   text.setBounds(170,300,400,30);
   text.setForeground(Color.WHITE);
    p.add(text);

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
  setVisible(false);
  new Trans(pinnumber).setVisible(true);

    }

    public static void main(String[] args) {

        Bal_Enq p = new Bal_Enq( "");
    }
}

