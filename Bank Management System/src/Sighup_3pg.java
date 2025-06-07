import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;

public class Sighup_3pg extends JFrame implements ActionListener {

    JLabel Additional_details_label;

    JLabel Account_type_label;
    JRadioButton saving_acc_checkbox;
    JRadioButton Fixed_Deposit_checkbox;
    JRadioButton Current_acc_checkbox;
    JRadioButton Recurring_acc_checkbox;

    JLabel card_no_label;
    JLabel card_label;
    JLabel cardNum_Label;

    JLabel Pin_no_label;
    JLabel Pin_label;
    JLabel PINNUM_LABEL;

    JLabel Services_Required_label;
    JCheckBox Atm_Card_checkbox;
    JCheckBox Internet_banking_checkbox;
    JCheckBox Mobile_banking_checkbox;
    JCheckBox Book_Check_checkbox;
    JCheckBox Emails_alerts_Checkbok;
    JCheckBox c7;
    JCheckBox E_Statement_checkbox;
   JPanel p;
    JButton Submit_Button;
    JButton cancel_Button;
    String formno;

    Sighup_3pg(String formno) {
        this.formno = formno;
        p = new JPanel();
/*
        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\OneDrive\\Desktop\\try2.png");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));
*/   setTitle("3 Page ");
        Additional_details_label = new JLabel("NEW ACCOUNT APPLICATION FORM " +formno+"- PAGE 3 ");
        Additional_details_label.setFont(new Font("Raleway", Font.BOLD, 22));
        Additional_details_label.setBounds(130, 40, 900, 40);
        p.add(Additional_details_label);

        Account_type_label = new JLabel("ACCOUNT TYPE :");
        Account_type_label.setBounds(100, 140, 200, 30);
        Account_type_label.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Account_type_label);

        saving_acc_checkbox = new JRadioButton("Saving Account");
        saving_acc_checkbox.setBounds(100, 180, 150, 30);
        saving_acc_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(saving_acc_checkbox);

        Fixed_Deposit_checkbox = new JRadioButton("Fixed Deposit");
        Fixed_Deposit_checkbox.setBounds(350, 180, 300, 30);
        Fixed_Deposit_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Fixed_Deposit_checkbox);

        Current_acc_checkbox = new JRadioButton("Current Account");
        Current_acc_checkbox.setBounds(100, 220, 250, 30);
        Current_acc_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Current_acc_checkbox);

        Recurring_acc_checkbox = new JRadioButton("Recurring account");
        Recurring_acc_checkbox.setBounds(350, 220, 250, 30);
        Recurring_acc_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Recurring_acc_checkbox);

        ButtonGroup BG = new ButtonGroup();
        BG.add(Recurring_acc_checkbox);
        BG.add(saving_acc_checkbox);
        BG.add(Fixed_Deposit_checkbox);
        BG.add(Current_acc_checkbox);


        card_no_label = new JLabel("Card Number ");
        card_no_label.setBounds(100, 300, 200, 30);
        card_no_label.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(card_no_label);

        card_label = new JLabel("Your 16 Digit Crad Number  ");
        card_label.setBounds(100, 330, 200, 20);
        card_label.setFont(new Font("Railway", Font.BOLD, 10));
        p.add(card_label);

        cardNum_Label = new JLabel(" XXX-XXX-XXX-456");
        cardNum_Label.setBounds(330, 300, 250, 30);
        cardNum_Label.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(cardNum_Label);


        Pin_no_label = new JLabel("Pin ");
        Pin_no_label.setBounds(100, 370, 200, 30);
        Pin_no_label.setFont(new Font("Railway", Font.BOLD, 21));
        p. add(Pin_no_label);

        Pin_label = new JLabel("Your 4 Digit Pin");
        Pin_label.setBounds(100, 400, 200, 20);
        Pin_label.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Pin_label);

        PINNUM_LABEL = new JLabel("XXXX");
        PINNUM_LABEL.setBounds(330, 370, 200, 30);
        PINNUM_LABEL.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(PINNUM_LABEL);

        Services_Required_label = new JLabel("Services Required :");
        Services_Required_label.setBounds(100, 450, 200, 30);
        Services_Required_label.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Services_Required_label);

        Atm_Card_checkbox = new JCheckBox("ATM Card ");
        Atm_Card_checkbox.setBounds(100, 500, 200, 30);
        Atm_Card_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Atm_Card_checkbox);

        Internet_banking_checkbox = new JCheckBox("Internet Banking");
        Internet_banking_checkbox.setBounds(350, 500, 200, 30);
        Internet_banking_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Internet_banking_checkbox);

        Mobile_banking_checkbox = new JCheckBox("Mobile Banking");
        Mobile_banking_checkbox.setBounds(100, 550, 200, 30);
        Mobile_banking_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Mobile_banking_checkbox);

        Book_Check_checkbox = new JCheckBox("Cheque Book");
        Book_Check_checkbox.setBounds(350, 550, 200, 30);
        Book_Check_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Book_Check_checkbox);

        E_Statement_checkbox = new JCheckBox("E Statement");
        E_Statement_checkbox.setBounds(100, 600, 200, 30);
        E_Statement_checkbox.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(E_Statement_checkbox);

        Emails_alerts_Checkbok = new JCheckBox("E Statement");
        Emails_alerts_Checkbok.setBounds(350, 600, 200, 30);
        Emails_alerts_Checkbok.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Emails_alerts_Checkbok);

         c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", true);
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        p.add(c7);
//buttons
        Submit_Button = new JButton("Submit");
        Submit_Button.setBounds(520, 600, 150, 30);
        Submit_Button.setForeground(Color.WHITE);
        Submit_Button.setBackground(Color.black);
        Submit_Button.setFocusable(false);
        Submit_Button.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(Submit_Button);
        Submit_Button.addActionListener(this);

        cancel_Button = new JButton("cancel");
        cancel_Button.setBounds(650, 600, 150, 30);
        cancel_Button.setForeground(Color.WHITE);
        cancel_Button.setFocusable(false);
        cancel_Button.setForeground(Color.WHITE);
        cancel_Button.setBackground(Color.black);
        cancel_Button.setFont(new Font("Railway", Font.BOLD, 21));
        p.add(cancel_Button);
        cancel_Button.addActionListener(this);
        getContentPane().setBackground(Color.WHITE);

        p.setBounds(0, 0, 800, 680);
        p.setOpaque(false);
        p.setLayout(null);
        p.setOpaque(true);
       // p.setBackground(Color.darkGray);

        setBackground(Color.darkGray);
        setSize(800, 680);
        add(p);
        setLocation(300, 90);
        setLayout(null);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Submit_Button) {

            java.lang.String Account_type_label = null;
            if (saving_acc_checkbox.isSelected()) {

                Account_type_label = "saving_acc_checkbox";
            }
            if (Fixed_Deposit_checkbox.isSelected()) {

                Account_type_label = "Fixed_Deposit_checkbox";
            }
            if (Current_acc_checkbox.isSelected()) {

                Account_type_label = "Current_acc_checkbox";
            } if (Recurring_acc_checkbox.isSelected()) {

                Account_type_label = "Current_acc_checkbox";
            }

            Random ran = new Random();
            long RAN_FORM = (ran.nextLong() % 90000000L) + 5040936000000000L;
            String cardNum = "" + Math.abs(RAN_FORM);

            long RAN_pin = (ran.nextLong() % 9000L) + 1000L;
            String pin = "" + Math.abs(RAN_pin);
            String facility = "";
            if(Atm_Card_checkbox.isSelected()){
                facility = facility + " ATM Card";
            }
            if(Internet_banking_checkbox.isSelected()){
                facility = facility + " Internet Banking";
            }
            if(Mobile_banking_checkbox.isSelected()){
                facility = facility + " Mobile Banking";
            }
            if(Emails_alerts_Checkbok.isSelected()){
                facility = facility + " EMAIL Alerts";
            }
            if(Book_Check_checkbox.isSelected()){
                facility = facility + " Cheque Book";
            }
            if(E_Statement_checkbox.isSelected()){
                facility = facility + " E-Statement";
            }
            try{
                if(e.getSource()==Submit_Button){

                        DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();

                        String qSighup_3pg = "insert into Sighup_3pg values('"+formno+"','"+Account_type_label+"','"+cardNum+"','"+pin+"','"+facility+"')";
                        String  qbank ="insert into LOGIN_1 values('"+ formno + "','"+ cardNum+ "','"+ pin+ "')";
                       c.s.executeUpdate(qSighup_3pg);
                    c.s.executeUpdate(qbank);

                        JOptionPane.showMessageDialog(null, "Card Number: " + cardNum + "\n Pin:"+ pin);
                        new Deposite(pin).setVisible(true);
                        setVisible(false);
                    }
                } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
             if(e.getSource()==cancel_Button){
                    System.exit(0);
                }

            }

    }
    }
