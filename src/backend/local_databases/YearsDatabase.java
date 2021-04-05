package backend.local_databases;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class YearsDatabase implements Database<String[][]>{

    private ArrayList<String[]> yearsList = new ArrayList<>();

    @Override
    public String[][] populate() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("country_list.csv"));
            String currentCountry;
            reader.readLine();
            while((currentCountry = reader.readLine()) != null) {
                String[] currentCountryParsed = currentCountry.split(",");
                String countryISO3 = currentCountryParsed[currentCountryParsed.length-3];
                String startValidYear = currentCountryParsed[currentCountryParsed.length-2];
                String endValidYear;
                if (currentCountryParsed[currentCountryParsed.length-1].equals("Now")) endValidYear = "2021";
                else endValidYear = currentCountryParsed[currentCountryParsed.length-1];
                String[] countryYears = new String[]{countryISO3, startValidYear, endValidYear};
                yearsList.add(countryYears);
            }
        } catch (NullPointerException | IOException e) {
            System.out.println("Countries file missing. Attempt reinstall of files");
            System.exit(0);
        }
        return yearsList.toArray(new String[0][0]);
    }

    /*
    Takes an ISO3 country code as input and returns the valid years range of data available in world bank database
    corresponding to that country
     */
    public String[] retrieve(String ISO3) {
        String[][] years = populate();
        for (String[] country : years) {
            if (country[0].equals(ISO3)) return new String[]{country[1], country[2]};
        }
        return null;
    }
}
