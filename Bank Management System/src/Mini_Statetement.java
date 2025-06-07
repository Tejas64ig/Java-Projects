import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Mini_Statetement extends JFrame implements ActionListener {
        String pinnumber;
    JButton Back_b;
        Mini_Statetement( String pinnumber){
        this.pinnumber= pinnumber;

        JPanel p = new JPanel();

            ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
            JLabel Bg_Label = new JLabel(Bg);
            Bg_Label.setBounds(0, 0, 400, 500);
            setContentPane(new JLabel(Bg));
            ImageIcon img =  new ImageIcon(" C:\\Users\\HP\\OneDrive\\Desktop\\Bank background_Zoro.jpg");
            JLabel img_lb = new JLabel(img);
            img_lb.setBounds(510, 420, 350, 400);
            p.add(img_lb);
        setTitle("Mini Statetement");

        JLabel mini = new JLabel();
        mini.setBounds(100,140,400,200);
            mini.setForeground(Color.WHITE);
            mini.setBackground(Color.black);
        p.add(mini);

        JLabel t = new JLabel(" bro's bank");
        t.setForeground(Color.WHITE);
        t.setBounds(150,20,100,20);
        p.add(t);

            JLabel card = new JLabel();
            card.setForeground(Color.WHITE);
            card.setBounds(20,80,300,20);
            p.add(card);

try{
    DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
    ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
    while (rs.next()) {
   card.setText("Card Number:"+ rs.getString("cardNum").substring(0,4)+ "XXXXXXXX"+rs.getString("cardNum").substring(12));

    }
}catch (Exception e){
    System.out.println(e);
}

            try{
                DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");
                while (rs.next()) {

                    mini.setText(mini.getText() + "<html>"+rs.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;+&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amo") +"<br><br>" );
        }
}catch (Exception ex){
                ex.printStackTrace();
            }
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

            p.setBounds(0, 0, 800, 720);
            p.setOpaque(false);
            p.setLayout(null);
            setLayout(null);
            add(p);
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
        Mini_Statetement p = new Mini_Statetement( "");
    }
}
