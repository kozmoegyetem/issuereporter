package hu.viktorkozma.issuereport;

import android.util.Log;

import java.util.List;

import hu.viktorkozma.issuereport.Data.Issue;

public class RestInteractor implements DBInteractor {


    @Override
    public List<Issue> findAll() {
        Log.d("listall", "refreshDamages sent via Rest");

        return null;
    }

    @Override
    public Issue findByID() {
        Log.d("id", "refreshD one item via Rest");
        return null;
    }

    @Override
    public Issue save() {
        Log.d("save", "save edit via Rest");

        return null;
    }

    @Override
    public Issue sync() {
        return null;
    }
}
