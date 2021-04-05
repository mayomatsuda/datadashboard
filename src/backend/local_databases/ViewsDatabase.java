package backend.local_databases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ViewsDatabase implements Database<String[]> {

    String[] analysisViews;
    BufferedReader reader;

    public ViewsDatabase() {
        try {
            reader = new BufferedReader(new FileReader("views_database.txt"));
            analysisViews = reader.readLine().split(",");
        } catch (IOException e) {
            System.out.println("Views Database file missing. Attempt reinstall of files");
            System.exit(0);
        }
    }

    @Override
    public String[] populate() {
        return analysisViews;
    }

    public String[] retrieve (String analysisType) {
        try {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String[] currentLineParsed = currentLine.split(";");
                if (currentLineParsed[0].equals(analysisType)) return currentLineParsed[1].split(",");
            }
        } catch (IOException e) {
            System.out.println("Views Database file missing. Attempt reinstall of files");
            System.exit(0);
        }
        return null;
    }

}
