import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Trans extends JFrame implements ActionListener {
    JButton Deposite_b;
    JButton  CashWithdraw_b;
    JButton  FastCash_eb;
    JButton  MiniState_b;
    JButton  PinChange_b;
    JButton  BalanceEnquiry_b;
    JButton Exit_b;
    String pinnumber;
    Trans(String pinnumber){
        this.pinnumber = pinnumber;
        JPanel p= new JPanel();

        JLabel te_l = new JLabel("Please Select Your transaction");
        te_l.setBounds(120,200,400,40);
        te_l.setForeground(Color.WHITE);
        te_l.setBackground(Color.BLACK);
        te_l.setFont(new Font("railway",Font.ITALIC,21));
        p.add(te_l);

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\atm.jpg ");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        Deposite_b = new JButton(" Deposite");
        Deposite_b.setFont(new Font("raileay",Font.BOLD,21));
        // Deposite_b.setForeground(Color.BLACK);
        //  Deposite_b.setBackground(Color.white);
        Deposite_b.setFocusable(false);
        Deposite_b.setBounds(75,300,130,30);
        Deposite_b.addActionListener(this);
        p.add(Deposite_b);

        CashWithdraw_b = new JButton("Cash Withdraw");
        CashWithdraw_b.setFont(new Font("raileay",Font.BOLD,21));
        // CashWithdraw_b.setForeground(Color.BLACK);
        //  CashWithdraw_b.setBackground(Color.white);
        CashWithdraw_b.setFocusable(false);
        CashWithdraw_b.setBounds(275,300,190,30);
        CashWithdraw_b.addActionListener(this);
        p.add(CashWithdraw_b);

        FastCash_eb = new JButton("Fast Cash");
        FastCash_eb.setFont(new Font("raileay",Font.BOLD,21));
        //  FastCash_eb.setForeground(Color.BLACK);
        //  FastCash_eb.setBackground(Color.white);
        FastCash_eb.setFocusable(false);
        FastCash_eb.setBounds(75,345,140,30);
        FastCash_eb.addActionListener(this);
        p.add(FastCash_eb);

        MiniState_b = new JButton("Mini State");
        MiniState_b.setFont(new Font("raileay",Font.BOLD,21));
        //MiniState_b.setForeground(Color.BLACK);
        // MiniState_b.setBackground(Color.white);
        MiniState_b.setFocusable(false);
        MiniState_b.setBounds(310,345,150,30);
        MiniState_b.addActionListener(this);
        p.add(MiniState_b);

        PinChange_b = new JButton("Pin Change");
        PinChange_b.setFont(new Font("raileay",Font.BOLD,21));
        // PinChange_b.setForeground(Color.BLACK);
        //  PinChange_b.setBackground(Color.white);
        PinChange_b.setFocusable(false);
        PinChange_b.setBounds(75,385,160,30);
        PinChange_b.addActionListener(this);
        p.add(PinChange_b);

        BalanceEnquiry_b = new JButton("Balance Enquiry");
        BalanceEnquiry_b.setFont(new Font("raileay",Font.BOLD,21));
        //BalanceEnquiry_b.setForeground(Color.BLACK);
        // BalanceEnquiry_b.setBackground(Color.white);
        BalanceEnquiry_b.setFocusable(false);
        BalanceEnquiry_b.setBounds(250,385,210,30);
        BalanceEnquiry_b.addActionListener(this);
        p.add(BalanceEnquiry_b);

        Exit_b = new JButton(" Exit   ");
        Exit_b.setFont(new Font("raileay",Font.BOLD,21));
        //Exit_b.setForeground(Color.BLACK);
        // Exit_b.setBackground(Color.white);
        Exit_b.setFocusable(false);
        Exit_b.setBounds(320,425,140,30);
        Exit_b.addActionListener(this);
        p.add(Exit_b);


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

        if(e.getSource()==Exit_b){
            System.exit(0);
        }
        else if(e.getSource()==Deposite_b){
            setVisible(false);
           new Deposite( pinnumber).setVisible(true);

        }
        else if(e.getSource()==CashWithdraw_b){
            setVisible(false);
             new CashWithdraw(pinnumber).setVisible(true);
        }
        else if(e.getSource()==FastCash_eb){
            setVisible(false);
             new FastCash( pinnumber).setVisible(true);

        }
        else if(e.getSource()==MiniState_b){
            setVisible(false);
            new Mini_Statetement(pinnumber).setVisible(true);
        }
        else if(e.getSource()==PinChange_b){
            setVisible(false);
         new Pin_Change(pinnumber).setVisible(true);

        }
        if(e.getSource()==BalanceEnquiry_b){
            setVisible(false);
                new Bal_Enq(pinnumber).setVisible(true);


        }


    }

    public static void main(String[] args) {
        Trans p = new Trans( "");
    }
}
