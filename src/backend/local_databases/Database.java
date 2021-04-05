package backend.local_databases;

public interface Database<T> {

    /*
    Traverses data specific to the implementation of this interface
     */
    T populate();

}
