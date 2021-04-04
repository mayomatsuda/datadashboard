package backend.local_databases;

import backend.local_databases.DataBase;

public class CountryDatabase implements DataBase<String> {
    @Override
    public String retrieve(String dataName) {
        return null;
    }

    @Override
    public boolean add(String dataName, String data) {
        return false;
    }
}
