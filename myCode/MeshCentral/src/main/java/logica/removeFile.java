package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author removeFile
 * @version 29/03/2022
 */
public class removeFile {
    Process process;

    public removeFile(String name) throws IOException{
        String concat;
        try {
            if (!name.equals("")){
                Files.delete(Paths.get("MeshCentral/data/" + name));
            }
        } catch (Exception exception){
            throw new IOException(exception.getMessage());
        }
    }
}
