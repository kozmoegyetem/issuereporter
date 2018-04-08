package hu.viktorkozma.issuereport;

public interface DBInteractor {
    void findAll();

    void findByID();

    void save();

    void sync();

}
