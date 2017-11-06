package pial.com.realm.apiManager;

import java.util.ArrayList;

import pial.com.realm.apiManager.Pojo.TodoResponse;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by pial on 10/30/17.
 */

public interface ApiService {
    @GET("/Todos")
    Observable<ArrayList<TodoResponse>> getTodo();
}
