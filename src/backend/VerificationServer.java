package backend;

import backend.local_databases.LoginDatabase;
import backend.local_databases.ViewsDatabase;

import java.util.Arrays;

public class VerificationServer {

    /*
    Makes use of the LoginDatabase to access the credentials file and validate login input against existing login info.
    Checks if the username inputted exists through the Login Database and if it does, compares the inputted password
    against the corresponding password in the database. Returns true if input was valid, and false if the username DNE
    or if the password input was wrong.
     */
    private boolean validateLogin(String username, String password) {
        LoginDatabase loginDB = new LoginDatabase();
        String passwordRetrieved = loginDB.retrieve(username);
        if (passwordRetrieved == null) {
            System.out.println("Unknown username.");
            return false;
        } else {
            if (!password.equals(passwordRetrieved)) System.out.println("invalid password");
            return password.equals(passwordRetrieved);
        }
    }

    /*
    Public interface to allow the login ui to verify the input from the user. Calls the validateLogin method
     */
    public boolean getResult(String username, String password) { return validateLogin(username, password); }

    public boolean validateView(String analysisType, String viewType) {
        ViewsDatabase viewDB = new ViewsDatabase();
        String[] availableViews = viewDB.retrieve(analysisType);
        return Arrays.asList(availableViews).contains(viewType);
    }
}