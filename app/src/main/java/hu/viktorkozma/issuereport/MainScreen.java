package hu.viktorkozma.issuereport;

import java.util.List;

import hu.viktorkozma.issuereport.Data.Issue;

public interface MainScreen {

    void showlist(List<Issue> list);

    void navigatetoselect(long id);
}
