package pial.com.realm.root;

import javax.inject.Singleton;

import dagger.Component;
import pial.com.realm.apiManager.ApiModule;
import pial.com.realm.apiManager.Pojo.RealmModule;
import pial.com.realm.ui.main.MainActivity;
import pial.com.realm.ui.main.MainActivityModule;

/**
 * Created by pial on 10/29/17.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class,RealmModule.class, MainActivityModule.class})
public interface ApplicationComponent {

    void inject(MainActivity target);
}
