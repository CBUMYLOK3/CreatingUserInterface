import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;



public class CreatingUserInterface {

    private JFrame frame;
    private JTextField textField;


    public CreatingUserInterface() {

        frame = new JFrame("User Interface");
        textField = new JTextField();

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        JMenuItem item1 = new JMenuItem("Print Date and Time");
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printDateTime();
            }
        });

        JMenuItem item2 = new JMenuItem("Write to log.txt");
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                writeToLog();
            }
        });

        JMenuItem item3 = new JMenuItem("Change Background Color");
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                changeBackgroundColor();
            }
        });

        JMenuItem item4 = new JMenuItem("Exit");
        item4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        menu.add(item1);
        menu.add(item2);
        menu.add(item3);
        menu.add(item4);
        menuBar.add(menu);
        frame.add(textField);

        frame.setJMenuBar(menuBar);        
        frame.setVisible(true);   
    }

    private void printDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        String dateTime = dateFormat.format(new Date());
        textField.setText(dateTime);
        
    }

    private void writeToLog() {
        String text = textField.getText();
        try {
            FileWriter writer = new FileWriter("log.txt");
            writer.write(text);
            writer.close();
            JOptionPane.showMessageDialog(frame, "Successfully");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error occurred");
        }
    }

    private void changeBackgroundColor() {
        Random random = new Random();

        ArrayList<Integer> greens = new ArrayList<Integer> ();
            greens.add(75);
            greens.add(90);
            greens.add(105);
            greens.add(120);
            greens.add(135);

        int randomColor = random.nextInt(greens.size());
        int randomNum = greens.get(randomColor);
        float hue = randomNum/ 360f;
        float saturation = 0.5f;
        float brightness = 0.9f;

        Color color = Color.getHSBColor(hue, saturation, brightness);
        frame.getContentPane().setBackground(color);
        textField.setBackground(frame.getContentPane().getBackground());
    }

    public static void main (String[] args) {
        new CreatingUserInterface();
    }
    
}
