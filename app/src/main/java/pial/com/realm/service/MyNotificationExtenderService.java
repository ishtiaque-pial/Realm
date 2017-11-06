package pial.com.realm.service;



import com.onesignal.NotificationExtenderService;
import com.onesignal.OSNotificationDisplayedResult;
import com.onesignal.OSNotificationReceivedResult;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.math.BigInteger;

import pial.com.realm.R;
import pial.com.realm.root.App;

/**
 * Created by pial on 10/30/17.
 */

public class MyNotificationExtenderService extends NotificationExtenderService {
    @Override
    protected boolean onNotificationProcessing(OSNotificationReceivedResult notification) {
        OverrideSettings overrideSettings = new OverrideSettings();
        overrideSettings.extender = new NotificationCompat.Extender() {

            @Override
            public NotificationCompat.Builder extend(NotificationCompat.Builder builder) {
//                Bitmap icon = BitmapFactory.decodeResource(App.getContext().getResources(),
//                        R.drawable.profile);
                //builder.setLargeIcon(icon);
                //builder.setSmallIcon(getNotificationIcon(builder));
                int color = 0x008000;
                return builder.setColor(color);
            }
        };

        OSNotificationDisplayedResult displayedResult = displayNotification(overrideSettings);
        Log.d("OneSignalExample", "Notification displayed with id: " + displayedResult.androidNotificationId);
        return true;
    }
    private int getNotificationIcon(NotificationCompat.Builder builder) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            int color = 0x008000;
            builder.setColor(color);
            return R.drawable.logo;
        }
        return R.drawable.logo;
    }
}
