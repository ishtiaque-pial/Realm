package pial.com.realm.ui.main;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import pial.com.realm.apiManager.ApiService;

/**
 * Created by pial on 10/30/17.
 */
@Module
public class MainActivityModule {
    @Provides
    public MainActivityMVP.Presenter procideMainActivityPresenter(MainActivityMVP.Model model) {
        return new MainActivityPresenter(model);
    }

    @Provides
    public MainActivityMVP.Model provideMainActivityModel(ApiService apiService, Realm realm) {
        return new MainActivityModel(apiService,realm);
    }
}
