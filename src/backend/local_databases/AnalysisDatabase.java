package backend.local_databases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AnalysisDatabase implements Database<String[][]> {

    private ArrayList<String[]> analysisList = new ArrayList<>();

    @Override
    public String[][] populate() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("analysis_database.txt"));
            String currentAnalyses;
            while ((currentAnalyses = reader.readLine()) != null) {
                String[] currentAnalysesParsed = currentAnalyses.split(";");
                analysisList.add(currentAnalysesParsed);
            }
        } catch (IOException | NullPointerException e) {
            System.out.println("Analysis Database file missing. Attempt reinstall of files");
            System.exit(0);
        }
        return analysisList.toArray(new String[0][0]);
    }
}