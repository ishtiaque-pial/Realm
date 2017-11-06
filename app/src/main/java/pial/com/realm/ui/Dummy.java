package pial.com.realm.ui;

import io.realm.RealmObject;

/**
 * Created by pial on 10/30/17.
 */

public class Dummy extends RealmObject{
    String ok;

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }
}
