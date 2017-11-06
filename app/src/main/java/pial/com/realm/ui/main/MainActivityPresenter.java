package pial.com.realm.ui.main;

import java.util.ArrayList;

import pial.com.realm.apiManager.Pojo.TodoResponse;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by pial on 10/30/17.
 */

public class MainActivityPresenter implements MainActivityMVP.Presenter {
    private MainActivityMVP.View view;
    private MainActivityMVP.Model model;
    private Subscription subscription;
    private ArrayList<TodoResponse> list = new ArrayList<>();

    public MainActivityPresenter(MainActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MainActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void rxUnsubscribe() {

        if (subscription != null) {
            if (!subscription.isUnsubscribed()) {
                subscription.unsubscribe();
            }
        }
    }

    @Override
    public void okClick() {
        subscription = model.getResponse()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ArrayList<TodoResponse>>() {
                    @Override
                    public void onCompleted() {
                       view.showToast("ok");
                        //view.setList(list);
                        if (model.addRealm(list)) {
                            view.showToast("Added");
                        } else {
                            view.showToast("not added");
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showToast(e.getMessage());
                        if (model.getRealmData().isEmpty()) {
                            view.showToast("kisui pai nai");
                        } else {
                            view.showToast("onek kisu paisi");
                            view.setList(list);
                        }
                    }

                    @Override
                    public void onNext(ArrayList<TodoResponse> todoResponses) {
                        list = todoResponses;

                    }
                });
    }
}
