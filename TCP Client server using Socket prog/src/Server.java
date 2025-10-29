import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Server extends JFrame implements ActionListener {

    JLabel Name_lb;
    JLabel Active_lb;

    ImageIcon Profile_pic;
    JLabel Profile_pic_lb;

    ImageIcon Voice_Call;
    JLabel Voice_Call_lb;

    ImageIcon Video_Call;
    JLabel Video_Call_lb;

    ImageIcon Menu_Icon;
    JLabel Menu_Icon_lb;

    ImageIcon back_icon;
    JLabel back_lb;

    JTextField tf;

    JButton Send_button;

    JPanel Mess_Box_Panel;

   static Box Vertical = Box.createVerticalBox();

    static  DataInputStream dis;
    static  DataOutputStream dos;

    Server() {
        JPanel Top_Panel = new JPanel();

        Mess_Box_Panel = new JPanel();
        Mess_Box_Panel.setLayout(new BorderLayout());

        // Name label
        Name_lb = new JLabel("Ram");
        Name_lb.setBounds(110, 15, 150, 20);
        Name_lb.setForeground(Color.WHITE);
        Name_lb.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        Top_Panel.add(Name_lb);

        Active_lb = new JLabel("Active Now");
        Active_lb.setBounds(110, 35, 150, 15);
        Active_lb.setForeground(Color.WHITE);
        Active_lb.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        Top_Panel.add(Active_lb);

        // Voice call icon
        Voice_Call = new ImageIcon(ClassLoader.getSystemResource("Icons/phone.png"));
        Image VoiceCall = Voice_Call.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Voice_Call_lb = new JLabel(new ImageIcon(VoiceCall));
        Voice_Call_lb.setBounds(330, 20, 30, 30);
        Top_Panel.add(Voice_Call_lb);

        // Video call icon
        Video_Call = new ImageIcon(ClassLoader.getSystemResource("Icons/video.png"));
        Image VideoCall = Video_Call.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Video_Call_lb = new JLabel(new ImageIcon(VideoCall));
        Video_Call_lb.setBounds(290, 20, 30, 30);
        Top_Panel.add(Video_Call_lb);

        // Menu icon
        Menu_Icon = new ImageIcon(ClassLoader.getSystemResource("Icons/3icon.png"));
        Image MenuIcon = Menu_Icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        Menu_Icon_lb = new JLabel(new ImageIcon(MenuIcon));
        Menu_Icon_lb.setBounds(370, 20, 30, 30);
        Top_Panel.add(Menu_Icon_lb);

        // Back icon
        back_icon = new ImageIcon(ClassLoader.getSystemResource("Icons/arrow.jpg"));
        Image backicon = back_icon.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        back_lb = new JLabel(new ImageIcon(backicon));
        back_lb.setBounds(10, 20, 30, 30);
        Top_Panel.add(back_lb);

        back_lb.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });

        tf = new JTextField();
        tf.setBounds(5, 655, 310, 40);
        tf.setBackground(Color.white);
        tf.setForeground(Color.black);
        tf.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(tf);

        Send_button = new JButton("Send");
        Send_button.setBounds(320, 655, 123, 40);
        Send_button.setFocusable(false);
        Send_button.setBackground(new Color(7, 94, 84));
        Send_button.setForeground(Color.WHITE);
        Send_button.addActionListener(this);
        add(Send_button);

        Top_Panel.setBackground(new Color(7, 94, 84));
        Top_Panel.setBounds(0, 0, 450, 70);
        Top_Panel.setLayout(null);
        add(Top_Panel);

        Mess_Box_Panel.setBounds(5, 75, 440, 570);
        add(Mess_Box_Panel);

        setSize(450, 700);
        setLocation(200, 50);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

            String Text = tf.getText();

            JPanel p = formatLabel(Text);

            JPanel right = new JPanel(new BorderLayout());
            right.add(p, BorderLayout.LINE_END);

            Vertical.add(right);
            Vertical.add(Box.createVerticalStrut(15));// space B/W the send mess
            Mess_Box_Panel.add(Vertical, BorderLayout.PAGE_START);
        try {

            dos.writeUTF(Text);
        }
        catch (Exception ee) {
            ee.printStackTrace();
        }
            tf.setText("");
            Mess_Box_Panel.revalidate(); // to refresh the frame
            Mess_Box_Panel.repaint();

    }
    public static JPanel formatLabel(String text) {

        JLabel messageLabel = new JLabel(text);
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel timeLabel = new JLabel(sdf.format(cal.getTime()));
        timeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        timeLabel.setForeground(Color.DARK_GRAY);

        JPanel messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.setBackground(new Color(220, 248, 198));
        messagePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        messagePanel.add(messageLabel);

        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        timePanel.setBackground(new Color(220, 248, 198));
        timePanel.add(timeLabel);

        messagePanel.add(timePanel);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(messagePanel, BorderLayout.LINE_END);

        return panel;
    }

    public static void main(String[] args) {

        Server server = new Server();
        try {
            ServerSocket ss = new ServerSocket(1104);
            while (true) {
                Socket s = ss.accept();

                 dis = new DataInputStream(s.getInputStream());
                 dos = new DataOutputStream(s.getOutputStream());

                while (true) {
                    String mess = dis.readUTF();
                    JPanel panel = formatLabel(mess);

                    JPanel left = new JPanel(new BorderLayout());
                    left.add(panel, BorderLayout.LINE_START);


                    server.Vertical.add(left);
                    server.Vertical.add(Box.createVerticalStrut(15));

                    server.Mess_Box_Panel.add(server.Vertical, BorderLayout.PAGE_START);


                    server.validate();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}























