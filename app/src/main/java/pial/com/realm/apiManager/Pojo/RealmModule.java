package pial.com.realm.apiManager.Pojo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by pial on 10/31/17.
 */
@Module
public class RealmModule {
    @Singleton
    @Provides
    public Realm provideRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .schemaVersion(3)
                .name("y")
                .build();
        return Realm.getInstance(realmConfiguration);
    }
}
