import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;


public class TemperatureConversionUsingSwing {
    public static void main(String[] args) {
        //Button1
        JLabel lb=new JLabel();
        lb.setText("Celsius");
        lb.setForeground(Color.white);
        lb.setBounds(10,100,450,30);
        Font myfont=new Font("Algerian",Font.BOLD,30);
        lb.setFont(myfont);

        JLabel lb2=new JLabel();
        lb2.setText("Fahrenheit");
        lb2.setForeground(Color.white);
        lb2.setBounds(290,100,450,30);
        Font myfont2=new Font("Algerian",Font.BOLD,30);
        lb2.setFont(myfont2);


        JTextField tf=new JTextField();
        tf.setFont(new Font("Algerian",Font.BOLD,20));
        tf.setBounds(10,150,120,30);

        JTextField tf2=new JTextField();
        tf2.setFont(new Font("Algerian",Font.BOLD,20));
        tf2.setBounds(290,150,120,30);
        tf2.setEditable(false);

        JButton button1=new JButton();
        button1.setText("Convert");
        button1.setBounds(10,300,120,30);
        button1.addActionListener(new ActionListener() {
                 public void actionPerformed(ActionEvent e)
                 {
                     String inputString1=tf.getText();
                     if(!isNumeric(inputString1))
                     {
                         JOptionPane.showMessageDialog(null,"please enter valid input","Invalid Input",JOptionPane.ERROR_MESSAGE);
                         return;
                     }
                     int temp=Integer.parseInt(inputString1);
                     int conversion;

                         if (lb.getText().equals("Celsius")) {
                             conversion = (temp * 9 / 5) + 32;
                         } else {
                             conversion = (temp - 32) * 5 / 9;
                         }

                     tf2.setText(Integer.toString(conversion));
                 }

        });


        JButton button2=new JButton();
        button2.setText("Switch");
        button2.setBounds(150,220,120,30);
        button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                String labelString=lb.getText();
                lb.setText(lb2.getText());
                lb2.setText(labelString);
                String TextString=tf.getText();
                tf.setText(tf2.getText());
                tf2.setText(TextString);
            }
        });

        JButton button4=new JButton();
        button4.setText("Clear");
        button4.setBounds(290,300,120,30);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                String inputString1=tf.getText();
                tf2.setText("");
                String inputString2=tf2.getText();
                tf.setText("");
            }
        });



        JFrame window1=new JFrame("Celsius To Fahrenheit Conversion");
        window1.setVisible(true);
        window1.setSize(500,500);
        window1.setResizable(false);
        window1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window1.getContentPane().setBackground(Color.orange);
        window1.setLayout(null);
        window1.add(lb);
        window1.add(tf);
        window1.add(button1);
        window1.add(lb2);
        window1.add(tf2);
        window1.add(button4);
        window1.add(button2);
        //window1.add(button3);

    }
    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}

