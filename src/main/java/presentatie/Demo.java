package presentatie;
import logica.connect;
import logica.createFile;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Demo
 * @version 27/03/2022
 */
public class Demo {
    public static void main(String[] args) {
        /*try {
            Process process = new ProcessBuilder("./meshcmd", "--actionfile", "MeshCentral/test.txt", "&").start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }*/
        connect connect = new connect();
        Process process;
        try {

            //process = new ProcessBuilder("rm -f MeshCentral/lol").start();
        } catch (Exception e){
            System.out.println(e);
        }
        connect.destroy();
    }
}
