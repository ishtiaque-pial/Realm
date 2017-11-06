package pial.com.realm.root;

import android.app.Application;
import android.content.Context;

import com.onesignal.OneSignal;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import pial.com.realm.apiManager.ApiModule;
import pial.com.realm.apiManager.Pojo.RealmModule;
import pial.com.realm.ui.main.MainActivityModule;

/**
 * Created by pial on 10/29/17.
 */

public class App extends Application {
    private ApplicationComponent component;
    private static Context context;

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        Realm.init(this);
//        RealmConfiguration config = new RealmConfiguration.Builder().name("myrngfhfea.realm").build();
//        Realm.setDefaultConfiguration(config);

        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .mainActivityModule(new MainActivityModule())
                .realmModule(new RealmModule())
                .build();
    }

    public ApplicationComponent getComponent() {
        return component;
    }

}
