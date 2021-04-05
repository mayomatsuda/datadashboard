package backend.local_databases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CountryDatabase implements Database<String[]> {

    private ArrayList<String> countryList = new ArrayList<>();

    @Override
    public String[] populate() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("country_list.csv"));
            String currentCountry;
            reader.readLine();
            while((currentCountry = reader.readLine()) != null) {
                String[] currentCountryParsed = currentCountry.split(",");
                String countryName = currentCountryParsed[1];
                if (countryName.startsWith("\""))  countryName = countryName + currentCountryParsed[2];
                countryList.add(countryName);
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("Countries file missing. Attempt reinstall of files");
            System.exit(0);
        }
        return countryList.toArray(new String[0]);
    }
}
