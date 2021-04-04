package backend.local_databases;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LoginDatabase implements DataBase<String> {

    File credentials = new File("credentials.txt");

    /*
    Scans the credentials.txt file for username password pairs based on the given username string. If the username is
    found, the corresponding password is returned. If the username does not exist, null return.
     */
    @Override
    public String retrieve(String username) {
        try {
            Scanner scanner = new Scanner(credentials);
            while(scanner.hasNextLine()) {
                String[] currentCredential = scanner.nextLine().split(",");
                if (currentCredential[0].equals(username)) return currentCredential[1];
            }
        } catch(FileNotFoundException e) {
            System.out.println("credentials file missing. Attempt reinstall of files");
            System.exit(0);
        }
        return null;
    }

    @Override
    public boolean add(String username, String Password) {
        return false;
    }

}
