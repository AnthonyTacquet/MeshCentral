package presentatie;

import logica.readFile;

/**
 * @author DemoRead
 * @version 27/03/2022
 */
public class DemoRead {
    public static void main(String[] args) {
        readFile readFile = new readFile("test.txt");
        System.out.println(readFile.getLocalPort());
        System.out.println(readFile.getUsername());
    }
}
