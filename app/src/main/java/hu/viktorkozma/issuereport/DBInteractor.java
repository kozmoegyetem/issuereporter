package hu.viktorkozma.issuereport;

import java.util.List;

import hu.viktorkozma.issuereport.Data.Issue;

public interface DBInteractor {
    public List<Issue> findAll();

    public Issue findByID();

    public Issue save();

    public Issue sync();

}
