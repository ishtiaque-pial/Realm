package pial.com.realm.utils;

import android.util.Log;

/**
 * Created by pial on 10/30/17.
 */

public class LogMessage {
    public static void printLogMessge(String className, String tag, String message) {
        Log.d(className, tag + "   ==/   " + message);
    }
}
