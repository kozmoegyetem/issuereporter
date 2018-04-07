package hu.viktorkozma.issuereport.ui;

import javax.inject.Singleton;

import dagger.Component;
import hu.viktorkozma.issuereport.InteractorModule;
import hu.viktorkozma.issuereport.MainActivity;
import hu.viktorkozma.issuereport.MainPresenter;

@Singleton
@Component(modules = {UIModule.class, InteractorModule.class})

public interface MainAppComponent {

    void inject(MainActivity mainactivity);

    void inject(MainPresenter mainPresenter);

}
