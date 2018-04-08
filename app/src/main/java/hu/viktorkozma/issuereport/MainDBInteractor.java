package hu.viktorkozma.issuereport;

import android.util.Log;

public class MainDBInteractor implements DBInteractor {
    @Override
    public void findAll() {
        Log.w("findall", "findall");
    }

    @Override
    public void findByID() {
        Log.w("findbyid", "findbyid");
    }

    @Override
    public void save() {
        Log.w("save", "save");
    }

    @Override
    public void sync() {
        Log.w("sync", "sync");
    }
}
