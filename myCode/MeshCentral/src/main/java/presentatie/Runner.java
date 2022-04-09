package presentatie;

import logica.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;


/**
 * @author Runner
 * @version 27/03/2022
 */
public class Runner {
    static JFrame frame;
    private JComboBox<String> Existing;
    private JButton Connect;
    private JLabel localPortField;
    private JLabel remoteNameField;
    private JLabel remoteNodeIDField;
    private JLabel remoteTargetField;
    private JLabel remotePortField;
    private JLabel usernameField;
    private JLabel passwordField;
    private JLabel serverIdField;
    private JLabel serverHttpsHashField;
    private JLabel debugLevelField;
    private JLabel serverUrlField;
    private JButton addButton;
    private JTextField chooseName;
    private JButton removeFile;
    private JTextField localPortText;
    private JTextField remotePortText;
    private JTextField usernameText;
    private JTextField debugLevelText;
    private JPanel Main;
    private JTextField passwordText;
    private JTextField remoteNameText;
    private JTextField remoteNodeIdText;
    private JTextField remoteTargetText;
    private JTextField serverIdText;
    private JTextField serverHttpsHashText;
    private JTextField serverUrlText;
    private JButton disconnectButton;
    private JTextField error;
    private JButton surf;

    private int activePort = 0;
    private boolean connection = false;


    public Runner(){
        error.setEditable(false);
        error.setBorder(new LineBorder(Color.red, 1));
        error.setCursor(new Cursor(Cursor.HAND_CURSOR));

        remoteTargetText.setText("null");
        debugLevelText.setText("0");
        Existing.addItem("none");
        String concat;
        Process p;
        Process process;
        try {
            process = Runtime.getRuntime().exec("ls MeshCentral/data");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((concat = br.readLine()) != null) {
                if (concat.equals("temp")){
                    p = new ProcessBuilder("rm MeshCentral/data/temp").start();
                    break;
                }
                Existing.addItem(concat);
            }
            process.waitFor();
            process.destroy();
        } catch (Exception e) {
            error.setText("Error: " + e.getMessage());
        }
        connect connect = new connect();
        error.setForeground(Color.red);

        Connect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Existing.getSelectedItem().equals("none")){
                    readFile readFile = new readFile(Existing.getSelectedItem().toString());
                    activePort = Integer.parseInt(localPortText.getText());

                    error.setForeground(Color.GREEN);
                    error.setBorder(new LineBorder(Color.green, 1));
                    error.setText("Connection is established, surf to 127.0.0.1:" + activePort + "!!!");
                    connection = true;
                    connect.connect(Existing.getSelectedItem().toString());
                } else {
                    if (localPortText.getText().isEmpty() || remoteNameText.getText().isEmpty() || remoteNodeIdText.getText().isEmpty() || remoteTargetText.getText().isEmpty() || remotePortText.getText().isEmpty() || usernameText.getText().isEmpty() || passwordText.getText().isEmpty() || serverIdText.getText().isEmpty() || serverHttpsHashText.getText().isEmpty() || debugLevelText.getText().isEmpty() || serverUrlText.getText().isEmpty()){
                        error.setText("Not all required fields are filled in!!!");
                        return;
                    }
                    try {
                        createFile file = new createFile(Integer.parseInt(localPortText.getText()), remoteNameText.getText(), remoteNodeIdText.getText(), remoteTargetText.getText(), Integer.parseInt(remotePortText.getText()), usernameText.getText(), passwordText.getText(), serverIdText.getText(), serverHttpsHashText.getText(), Integer.parseInt(debugLevelText.getText()), serverUrlText.getText());
                        file.setName("temp");
                        file.generate();
                        activePort = Integer.parseInt(localPortText.getText());
                        connect.connect("temp");
                        error.setForeground(Color.GREEN);
                        error.setText("Connection is established, surf to 127.0.0.1:" + activePort + "!!!");
                        connection = true;
                    } catch (Exception exception){
                        error.setText("Error: " + exception.getMessage());
                        return;
                    }
                }
            }
        });

        disconnectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                connect.destroy();
                error.setForeground(Color.red);
                error.setBorder(new LineBorder(Color.red, 1));
                error.setText("Connection is disabled!!!");
                connection = false;
            }
        });

        Existing.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!Existing.getSelectedItem().toString().equals("none")){
                    readFile file = new readFile(Existing.getSelectedItem().toString());
                    localPortText.setText(Integer.toString(file.getLocalPort()));
                    remoteNameText.setText(file.getRemoteName());
                    remoteNodeIdText.setText(file.getRemoteNodeId());
                    remoteTargetText.setText(file.getRemoteTarget());
                    remotePortText.setText(Integer.toString(file.getRemotePort()));
                    usernameText.setText(file.getUsername());
                    passwordText.setText(file.getPassword());
                    serverIdText.setText(file.getServerId());
                    serverHttpsHashText.setText(file.getServerHttpsHash());
                    debugLevelText.setText(Integer.toString(file.getDebugLevel()));
                    serverUrlText.setText(file.getServerUrl());
                } else {
                    localPortText.setText("");
                    remoteNameText.setText("");
                    remoteNodeIdText.setText("");
                    remoteTargetText.setText("");
                    remotePortText.setText("");
                    usernameText.setText("");
                    passwordText.setText("");
                    serverIdText.setText("");
                    serverHttpsHashText.setText("");
                    debugLevelText.setText("");
                    serverUrlText.setText("");
                }

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < Existing.getItemCount(); i++){
                    if (Existing.getSelectedItem().toString().equals(chooseName.getText())){
                        error.setText("File already exists!!!");
                    }
                }
                if (chooseName.getText().isEmpty() || localPortText.getText().isEmpty() || remoteNameText.getText().isEmpty() || remoteNodeIdText.getText().isEmpty() || remoteTargetText.getText().isEmpty() || remotePortText.getText().isEmpty() || usernameText.getText().isEmpty() || passwordText.getText().isEmpty() || serverIdText.getText().isEmpty() || serverHttpsHashText.getText().isEmpty() || debugLevelText.getText().isEmpty() || serverUrlText.getText().isEmpty()){
                    error.setText("Not all required fields are filled in!!!");
                    return;
                }
                try {
                    createFile file = new createFile(Integer.parseInt(localPortText.getText()), remoteNameText.getText(), remoteNodeIdText.getText(), remoteTargetText.getText(), Integer.parseInt(remotePortText.getText()), usernameText.getText(), passwordText.getText(), serverIdText.getText(), serverHttpsHashText.getText(), Integer.parseInt(debugLevelText.getText()), serverUrlText.getText());
                    file.setName(chooseName.getText());
                    file.generate();
                    addExisting(chooseName.getText());
                } catch (Exception exception){
                    error.setText("Error: " + exception.getMessage());
                    return;
                }
            }
        });

        removeFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Existing.getSelectedItem().toString().equals("none")){
                    error.setText("First choose item to remove!!!");
                    return;
                }
                try {
                    error.setText(Existing.getSelectedItem().toString() + " was Deleted!!!");
                    removeFile removeFile = new removeFile(Existing.getSelectedItem().toString());
                    removeExisting(Existing.getSelectedIndex());
                } catch (Exception exception){
                    error.setText("Error: " + exception.getMessage());
                }
            }
        });
        surf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (connection){
                    try{
                        Thread.sleep(500);
                        String url = "127.0.0.1:" + activePort;
                        openBrowser.openURL(url);
                    } catch (Exception exception){
                        error.setForeground(Color.RED);
                        error.setText("Error: " + exception.getMessage());
                        System.out.println("Error: " + exception.getMessage());
                    }
                } else {
                    error.setForeground(Color.RED);
                    error.setText("Error: no connection has been started yet!!!");
                }
            }
        });
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                connect.destroy();
                connection = false;
            }
        });
    }

    public void removeExisting(int index){
        Existing.removeItemAt(index);
        error.setForeground(Color.red);
        error.setBorder(new LineBorder(Color.red, 1));
        error.setText("File has been removed from the list!!!");
    }

    public void addExisting(String name){
        Existing.addItem(name);
        error.setForeground(Color.green);
        error.setBorder(new LineBorder(Color.green, 1));
        error.setText("File " + name + " has been added to the list!!!");
    }

    public static void main(String[] args) {
        frame = new JFrame("MeshCentral");
        frame.setContentPane(new Runner().Main);
        frame.setSize(600,480);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new BorderLayout());


        //frame.setContentPane(new JLabel(new ImageIcon("src/test/java/main/logica/logo")));
        //frame.setLayout(new FlowLayout());
    }
}
