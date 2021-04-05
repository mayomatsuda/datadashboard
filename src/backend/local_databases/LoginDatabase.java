package backend.local_databases;

import java.io.*;

public class LoginDatabase{

    private File credentials = new File("login_database.txt");

    /*
    Scans the credentials.txt file for username password pairs based on the given username string. If the username is
    found, the corresponding password is returned. If the username does not exist, null return.
     */
    public String retrieve(String username) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("login_database.txt"));
            String currentCredential;
            while((currentCredential = reader.readLine()) != null) {
                String[] currentCredentialParsed = currentCredential.split(",");
                if (currentCredentialParsed[0].equals(username)) return currentCredentialParsed[1];
            }
        } catch(IOException e) {
            System.out.println("credentials file missing. Attempt reinstall of files");
            System.exit(0);
        }
        return null;
    }
}
