package presentatie;

import logica.connect;
import logica.createFile;
import logica.readFile;
import logica.removeFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;


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
    private JLabel error;
    private JButton githubButton;

    public Runner(){
        //error.setText("                                     ");
        remoteTargetText.setText("null");
        debugLevelText.setText("0");
        Existing.addItem("none");
        String concat;
        Process p;
        Process process;
        try {
            process = Runtime.getRuntime().exec("ls MeshCentral");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((concat = br.readLine()) != null) {
                if (concat.equals("temp")){
                    p = new ProcessBuilder("rm MeshCentral/temp").start();
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

                    error.setForeground(Color.GREEN);
                    error.setText("Connection is established!!!");
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
                            connect.connect("temp");
                            error.setForeground(Color.GREEN);
                            error.setText("Connection is established!!!");
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
                error.setText("Connection is disabled!!!");
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
                    removeFile removeFile = new removeFile(Existing.getSelectedItem().toString());
                    removeExisting(Existing.getSelectedIndex());
                } catch (Exception exception){
                    error.setText("Error: " + exception.getMessage());
                }
                error.setText(Existing.getSelectedItem().toString() + " was Deleted!!!");
            }
        });
    }

    public void removeExisting(int index){
        Existing.removeItemAt(index);
        error.setForeground(Color.red);
        error.setText("File has been removed from the list!!!");
    }

    public void addExisting(String name){
        Existing.addItem(name);
        error.setForeground(Color.green);
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
