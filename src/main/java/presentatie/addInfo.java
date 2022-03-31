package presentatie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author addInfo
 * @version 28/03/2022
 */
public class addInfo {
    private String content;
    private String name;
    private JButton addButton;
    private JTextField contentField;
    private JTextField nameField;
    private JPanel Main;
    private JLabel errorField;

    public addInfo(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contentField.getText().equals("")) {
                    errorField.setBackground(Color.red);
                    contentField.setForeground(Color.red);
                    errorField.setText("Field cannot be empty!!");
                    return;
                }
                errorField.setBackground(Color.white);
                contentField.setForeground(Color.black);
                errorField.setText("");
                name = nameField.getText();
                content = contentField.getText();
            }
        });
    }

    public String getContent(){
        return this.content;
    }

    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("addInfo");
        frame.setContentPane(new addInfo().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,180);
        frame.setVisible(true);
    }
}
