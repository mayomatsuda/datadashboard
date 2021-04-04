package backend.local_databases;

public interface DataBase<T> {

    /*
    Traverses data specific to the implementation of this interface for a data entry identifiable by "dataName".
     */
    T retrieve(String dataName);

    /*
    Creates and stores a new data entry into the data structure specific to the implementation of this interface.
     */
    boolean add(String dataName, T data);

}
