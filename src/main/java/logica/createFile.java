package logica;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author File
 * @version 26/03/2022
 */
public class createFile {
    String name = " ";
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

    public createFile(){

    }

    public createFile(int localPort, String remoteName, String remoteNodeId, String remoteTarget, int remotePort, String username, String password, String serverId, String serverHttpsHash, int debugLevel, String serverUrl ){
        this.localPort = localPort;
        this.remoteName = remoteName;
        this.remoteNodeId = remoteNodeId;
        this.remoteTarget = remoteTarget;
        this.remotePort = remotePort;
        this.username = username;
        this.password = password;
        this.serverId = serverId;
        this.serverHttpsHash = serverHttpsHash;
        this.debugLevel = debugLevel;
        this.serverUrl = serverUrl;
    }

    public void generate() throws IOException {
        try {
            FileWriter write = new FileWriter(new File("MeshCentral/", name));
            write.write("{\n");
            write.write(" \"action\": \"route\",\n");
            write.write(" \"localPort\": " + this.localPort + ",\n");
            write.write(" \"remoteName\": \"" + this.remoteName + "\",\n");
            write.write(" \"remoteNodeId\": \"" + this.remoteNodeId + "\",\n");
            write.write(" \"remoteTarget\": " + this.remoteTarget + ",\n");
            write.write(" \"remotePort\": " + this.remotePort + ",\n");
            write.write(" \"username\": \"" + this.username + "\",\n");
            write.write(" \"password\": \"" + this.password + "\",\n");
            write.write(" \"serverId\": \"" + this.serverId + "\",\n");
            write.write( " \"serverHttpsHash\": \"" + this.serverHttpsHash + "\",\n");
            write.write(" \"debugLevel\": " + this.debugLevel + ",\n");
            write.write(" \"serverUrl\": \"" + this.serverUrl + "\"\n");
            write.write("}");

            write.close();
        } catch (IOException exception){
            throw new IOException("Error");
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLocalPort(int port){
        if (Integer.toString(port).length() != 4){
            throw new IllegalArgumentException("Must be 4 digits long!!!");
        }
        this.localPort = port;
    }

    public void setRemoteName(String name){
        this.remoteName = name;
    }

    public void setRemoteNodeId(String remoteNodeId){
        this.remoteNodeId = remoteNodeId;
    }

    public void setRemoteTarget(String target){
        this.remoteTarget = target;
    }

    public void setRemotePort(int port){
        if (Integer.toString(port).length() != 4){
            throw new IllegalArgumentException("Must be 4 digits long!!!");
        }
        this.remotePort = port;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setServerId(String serverId){
        this.serverId = serverId;
    }

    public void setServerHttpsHash(String serverHttpsHash){
        this.serverHttpsHash = serverHttpsHash;
    }

    public void setDebugLevel(int debugLevel){
        this.debugLevel = debugLevel;
    }

    public void setServerUrl(String serverUrl){
        this.serverUrl = serverUrl;
    }
}
