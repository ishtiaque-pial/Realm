package pial.com.realm.ui.main;

import java.util.ArrayList;

import pial.com.realm.apiManager.Pojo.TodoResponse;
import rx.Observable;

/**
 * Created by pial on 10/30/17.
 */

public interface MainActivityMVP {

    interface Model {
        Observable<ArrayList<TodoResponse>> getResponse();

        Boolean addRealm(ArrayList<TodoResponse> todoResponses);

        ArrayList<TodoResponse> getRealmData();
    }

    interface View {

        void showToast(String message);

        void setList(ArrayList<TodoResponse> todoResponseArrayList);
    }

    interface Presenter {

        void setView(MainActivityMVP.View view);

        void rxUnsubscribe();

        void okClick();
    }
}
