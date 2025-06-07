import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public  class sighup2_pg  extends JFrame implements ActionListener {

    JPanel p;
    JLabel Additional_details_label;

    JLabel Religion_label;
    JComboBox Religion_dropdown;

    JLabel category_Label;
    JComboBox category_dropdown;

    JLabel Income_Label;
    JComboBox Income_dropdown;

    JLabel Educatation_label;
    JComboBox Educatation_dropdown;

    JLabel occupatiom_Label;
    JComboBox occupatiom_dropdown;

    JLabel Pan_Label;
    JTextField Pan_filed;

    JLabel Addhar_label;
    JTextField Addhar_field;

    JLabel senior_label;
    JRadioButton yes;
    JRadioButton NO;

    String Formno;

    JButton Next_pg;

    public sighup2_pg(String Formno) {
        p = new JPanel();

        setTitle("New ACCOUNT APPLICATATION FORM - 2 PAGE  ");

        this.Formno = Formno;

        ImageIcon Bg = new ImageIcon("C:\\Users\\HP\\Downloads\\Bank background_2 (1).jp");
        JLabel Bg_Label = new JLabel(Bg);
        Bg_Label.setBounds(0, 0, 400, 500);
        setContentPane(new JLabel(Bg));

        Additional_details_label = new JLabel("NEW ACCOUNT APPLICATION FORM - PAGE 2 ");
        Additional_details_label.setFont(new Font("Raleway", Font.BOLD, 22));
        Additional_details_label.setBounds(250, 50, 400, 50);
        p.add(Additional_details_label);

        Religion_label = new JLabel("Religion ");
        Religion_label.setBounds(100, 120, 100, 30);
        Religion_label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Religion_label);

       String[] cast = {"jai shree ram ", "Punjabi", "maksad ", "Brahmins"};
        Religion_dropdown = new JComboBox(cast);
        Religion_dropdown.setBounds(350, 120, 320, 30);
        Religion_dropdown.setFont(new Font("Raleway", Font.BOLD, 14));
        p.add(Religion_dropdown);

        category_Label = new JLabel("category");
        category_Label.setBounds(100, 170, 100, 30);
        category_Label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(category_Label);

        java.lang.String[] category = {"General ", "OBC", "SC ", "ST"};
        category_dropdown = new JComboBox(category);
        category_dropdown.setBounds(350, 170, 320, 30);
        category_dropdown.setFont(new Font("Raleway", Font.BOLD, 14));
        p.add(category_dropdown);

        Income_Label = new JLabel("Income");
        Income_Label.setBounds(100, 220, 100, 30);
        Income_Label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Income_Label);

        java.lang.String[] Income = {"under 2 lac ", "under 6 lac ", "under 12 lac  ", "ambani ka relative "};
        Income_dropdown = new JComboBox(Income);
        Income_dropdown.setBounds(350, 220, 320, 30);
        Income_dropdown.setFont(new Font("Raleway", Font.BOLD, 14));
        p.add(Income_dropdown);

        Educatation_label = new JLabel("Educatation QUALIFICATION ");
        Educatation_label.setBounds(100, 270, 160, 30);
        Educatation_label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Educatation_label);

        java.lang.String[] Educatation = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        Educatation_dropdown = new JComboBox(Educatation);
        Educatation_dropdown.setBounds(350, 270, 320, 30);
        Educatation_dropdown.setFont(new Font("Raleway", Font.BOLD, 14));
        p.add(Educatation_dropdown);

        occupatiom_Label = new JLabel(" occupation");
        occupatiom_Label.setBounds(100, 320, 150, 30);
        occupatiom_Label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(occupatiom_Label);

        java.lang.String[] occupation = {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"};
        occupatiom_dropdown = new JComboBox(occupation);
        occupatiom_dropdown.setBounds(350, 320, 320, 30);
        occupatiom_dropdown.setFont(new Font("Raleway", Font.BOLD, 14));
        p.add(occupatiom_dropdown);

        Pan_Label = new JLabel("Pan no. ");
        Pan_Label.setBounds(100, 370, 200, 30);
        Pan_Label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Pan_Label);

        Pan_filed = new JTextField();
        Pan_filed.setBounds(300, 370, 300, 30);
        Pan_filed.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Pan_filed);

        Addhar_label = new JLabel("Addhar no. ");
        Addhar_label.setBounds(100, 420, 200, 30);
        Addhar_label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Addhar_label);

        Addhar_field = new JTextField();
        Addhar_field.setBounds(280, 420, 300, 30);
        Addhar_field.setFont(new Font("railway", Font.BOLD, 21));
        p.add(Addhar_field);

        senior_label = new JLabel("senior citizen ");
        senior_label.setBounds(100, 470, 200, 30);
        senior_label.setFont(new Font("railway", Font.BOLD, 21));
        p.add(senior_label);

        yes = new JRadioButton("Yes");
        yes.setBounds(250, 470, 50, 30);
        p.add(yes);

        NO = new JRadioButton("No");
        NO.setBounds(350, 470, 50, 30);
        p.add(NO);

        ButtonGroup BG = new ButtonGroup();
        BG.add(yes);
        BG.add(NO);

        Next_pg = new JButton("NEXT PAGE ");
        Next_pg.setFocusable(false);
        Next_pg.setForeground(Color.WHITE);
        Next_pg.setBackground(Color.BLACK);
        Next_pg.setBounds(600, 590, 100, 30);
        p.add(Next_pg);
        Next_pg.addActionListener(this);

        p.setBounds(0, 0, 800, 680);
        p.setOpaque(false);
        p.setLayout(null);

        setBackground(Color.LIGHT_GRAY);
        setSize(800, 680);
        add(p);
        setLocation(300, 90);
        setLayout(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = " " + Formno;
        String Religion = (java.lang.String) Religion_dropdown.getSelectedItem();
        String category = (java.lang.String) category_dropdown.getSelectedItem();
        String Income = (java.lang.String) Income_dropdown.getSelectedItem();
       String Educatation = (java.lang.String) Educatation_dropdown.getSelectedItem();
       String occupatiom = (java.lang.String) occupatiom_dropdown.getSelectedItem();
        java.lang.String Pan = Pan_filed.getText();
       String Addhar = Addhar_field.getText();

        java.lang.String Sineor_citizen = null;
        if (yes.isSelected()) {
            Sineor_citizen = "yes";
        } else if (NO.isSelected()) {
            Sineor_citizen = "NO";
        }

        try {
            DATA_BASE_CONNECTIVITY c = new DATA_BASE_CONNECTIVITY();
            java.lang.String q = "insert S2 Values('" + formno + "', '" + Religion + "', '" + category + "', '" + Income + "', '" + Educatation + "', '" + occupatiom + "', '" + Pan + "', '" + Addhar + "' )";
            c.s.executeUpdate(q);
        } catch (Exception exception) {

            System.out.println(e);
        }
            setVisible(false);
             new Sighup_3pg(Formno).setVisible(true);

        }
    public static void main(String[] args) {
        sighup2_pg knevw = new sighup2_pg( "");
    }
}



