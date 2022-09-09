package logica;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author connect
 * @version 28/03/2022
 */
public class connect {
    Process process;
    public void connect(String name){
        String s;
        try {
            Process process = new ProcessBuilder("./MeshCentral/meshcmd", "--actionfile", "MeshCentral/data/" + name).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void connect(String name, String code){
        String s;
        try {
            Process process = new ProcessBuilder("./MeshCentral/meshcmd", "--actionfile", "MeshCentral/data/" + name, "--token " + code).start();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void destroy(){
        String pid = "";
        String s;
        try {
            process = Runtime.getRuntime().exec("pidof meshcmd");
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((s = br.readLine()) != null) {
                pid = s;
                break;
            }
            process = Runtime.getRuntime().exec("kill -9 " + pid);

        } catch (Exception exception){
            throw new IllegalArgumentException(exception.getMessage());
        }
    }
}
