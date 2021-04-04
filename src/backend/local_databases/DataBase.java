package backend.local_databases;

public interface DataBase<T> {

    /*
    Traverses data specific to the implementation of this interface for a data entry identifiable by "dataName".
     */
    T populate();

}
