package pial.com.realm.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ForwardingListener;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.onesignal.OSNotification;
import com.onesignal.OneSignal;

import org.json.JSONObject;

import java.security.SecureRandom;
import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import pial.com.realm.R;
import pial.com.realm.apiManager.Pojo.TodoResponse;
import pial.com.realm.root.App;
import pial.com.realm.ui.Dummy;

public class MainActivity extends AppCompatActivity implements MainActivityMVP.View {

    @BindView(R.id.et)
    EditText editText;
    @Inject
    MainActivityMVP.Presenter presenter;
//    private Realm realm;
//    private RealmConfiguration realmConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ((App) getApplication()).getComponent().inject(this);

//        realmConfiguration = new RealmConfiguration.Builder()
//                .schemaVersion(2)
//                .name("yuioy")
//                .build();
//
//        Realm.deleteRealm(realmConfiguration);
//        realm = Realm.getInstance(realmConfiguration);

        // Start with a clean slate every time


        // Open the Realm with encryption enabled


        //Log.e("hfgfhgfh", "path: " + realm.getPath());
//        OneSignal.startInit(this)
//                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
//                .unsubscribeWhenNotificationsAreDisabled(true)
//                .setNotificationReceivedHandler(new NotificationReceivedHandler())
//                .init();

//        Dummy dummy = new Dummy();
//        dummy.setOk("hghjggjhm");
//        realm.beginTransaction();
//        realm.copyToRealm(dummy);
//        realm.commitTransaction();
//        final RealmResults<Dummy> dummies = realm.where(Dummy.class).findAll();
//        if (dummies!=null) {
//            Log.e("shdgsd",""+dummies);
//            Toast.makeText(this, ""+dummies.get(0), Toast.LENGTH_SHORT).show();
//        }
//        realm.executeTransactionAsync(new Realm.Transaction() {
//                                          @Override
//                                          public void execute(Realm realm) {
//                                              Dummy dummy =realm.createObject(Dummy.class);
//                                              dummy.setOk("dgfdgfdg");
//
//                                          }
//                                      }, new Realm.Transaction.OnSuccess() {
//                                          @Override
//                                          public void onSuccess() {
//                                              Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
//                                          }
//                                      }, new Realm.Transaction.OnError() {
//                                          @Override
//                                          public void onError(Throwable error) {
//
//                                          }
//                                      });




    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.rxUnsubscribe();
        //realm.close();
    }

    public void ok(View view) {

        //OneSignal.sendTag("User_ID",editText.getText().toString());
        presenter.okClick();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(this, ""+message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setList(ArrayList<TodoResponse> todoResponseArrayList) {

//        for (TodoResponse todoResponse : todoResponseArrayList) {
//            realm.beginTransaction();
//            realm.copyToRealm(todoResponse);
//            realm.commitTransaction();
//        }
//        okkkkk();
//        Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
    }



    public class NotificationReceivedHandler implements OneSignal.NotificationReceivedHandler {

        @Override
        public void notificationReceived(OSNotification notification) {
            JSONObject data = notification.payload.additionalData;
            String customKey;

            if (data != null) {
                customKey = data.optString("customkey", null);
                if (customKey != null)
                    Log.e("OneSignalExample", "customkey set with value: " + customKey);
                else {
                    Log.e(",jshd,","hsadghjsdg");
                }
            } else {
                Log.e("sajhdjas","shjdgas");
            }
        }
    }
}
