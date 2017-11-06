package pial.com.realm.ui.main;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;
import pial.com.realm.apiManager.ApiService;
import pial.com.realm.apiManager.Pojo.TodoResponse;
import pial.com.realm.ui.Dummy;
import rx.Observable;

/**
 * Created by pial on 10/30/17.
 */

public class MainActivityModel implements MainActivityMVP.Model{
    private ApiService apiService;
    private Realm realm;
    private boolean flag;;

    public MainActivityModel(ApiService apiService, Realm realm) {
        this.apiService = apiService;
        this.realm = realm;
    }

    @Override
    public Observable<ArrayList<TodoResponse>> getResponse() {
        return apiService.getTodo();
    }

    @Override
    public Boolean addRealm(final ArrayList<TodoResponse> todoResponses) {
        Log.e("TodoSize",""+todoResponses.size());
        flag = false;
        for (TodoResponse todoResponse : todoResponses) {
            realm.beginTransaction();
            realm.copyToRealm(todoResponse);
            realm.commitTransaction();
            flag = true;
        }

        return flag;
    }

    @Override
    public ArrayList<TodoResponse> getRealmData() {
        ArrayList<TodoResponse> todoResponses = new ArrayList<>();
        final RealmResults<TodoResponse> dummies = realm.where(TodoResponse.class).findAll();
        if (dummies!=null) {
            //Log.e("shdgsd",""+dummies);
//            Toast.makeText(this, ""+dummies.get(0), Toast.LENGTH_SHORT).show();
            todoResponses.addAll(dummies);
        }
        Log.e("shdgsd",""+dummies);
        return todoResponses;
    }
}
