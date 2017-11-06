package pial.com.realm.apiManager.Pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

/**
 * Created by pial on 10/30/17.
 */

public class TodoResponse extends RealmObject{
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("todo")
    @Expose
    private String todo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

}
