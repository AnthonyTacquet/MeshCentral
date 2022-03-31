package logica;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author readFile
 * @version 27/03/2022
 */
public class readFile {
    int localPort = 0;
    String remoteName = null;
    String remoteNodeId = null;
    String remoteTarget = null;
    int remotePort = 0;
    String username = null;
    String password = null;
    String serverId = null;
    String serverHttpsHash = null;
    int debugLevel = 0;
    String serverUrl = null;

    public readFile(String name){
        try {
            File myObj = new File("MeshCentral/" + name);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                int first = 0;
                int found = 0;
                String data = myReader.nextLine();
                for (int i = 0; i < data.length(); i++){
                    if (data.charAt(i) == '"'){
                        if (found == 0)
                            first = i;
                        found++;
                    }
                    if (found == 2){
                        String word = data.substring(first + 1, i);
                        if (word.equals("localPort"))
                            this.localPort = Integer.parseInt(data.substring(i + 3, data.length() - 1));
                        else if (word.equals("remoteName"))
                            this.remoteName = data.substring(i + 4, data.length() - 2);
                        else if (word.equals("remoteNodeId"))
                            this.remoteNodeId = data.substring(i + 4, data.length() - 2);
                        else if (word.equals("remoteTarget"))
                            this.remoteTarget = data.substring(i + 3, data.length() - 1);
                        else if (word.equals("remotePort"))
                            this.remotePort = Integer.parseInt(data.substring(i + 3, data.length() - 1));
                        else if (word.equals("username"))
                            this.username = data.substring(i + 4, data.length() - 2);
                        else if (word.equals("password"))
                            this.password = data.substring(i + 4, data.length() - 2);
                        else if (word.equals("serverId"))
                            this.serverId = data.substring(i + 4, data.length() - 2);
                        else if (word.equals("serverHttpsHash"))
                            this.serverHttpsHash = data.substring(i + 4, data.length() - 2);
                        else if (word.equals("debugLevel"))
                            this.debugLevel = Integer.parseInt(data.substring(i + 3, data.length() - 1));
                        else if (word.equals("serverUrl"))
                            this.serverUrl = data.substring(i + 4, data.length() - 1);
                        else
                            break;

                        found++;
                    }
                }

                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException exception) {
            throw new IllegalArgumentException("An error occured");
        }
    }

    public int getLocalPort(){
        return this.localPort;
    }

    public String getRemoteName(){
        return this.remoteName;
    }

    public String getRemoteNodeId(){
        return this.remoteNodeId;
    }

    public String getRemoteTarget(){
        return this.remoteTarget;
    }

    public int getRemotePort(){
        return this.remotePort;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String getServerId(){
        return this.serverId;
    }

    public String getServerHttpsHash(){
        return this.serverHttpsHash;
    }

    public int getDebugLevel(){
        return this.debugLevel;
    }

    public String getServerUrl(){
        return this.serverUrl;
    }
}
