package lithium.community.lithosphere;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Map;

import lithium.community.android.sdk.LiSDKManager;
import lithium.community.android.sdk.auth.LiAppCredentials;
import lithium.community.android.sdk.notification.LiNotificationPayload;
import lithium.community.android.sdk.ui.components.activities.LiConversationActivity;
import lithium.community.android.sdk.ui.components.utils.LiSDKConstants;

/**
 * This class overrides the class {@link lithium.community.android.sdk.notification.LiFirebaseMessagingService}
 * behavior for showing the notification received from community
 *
 */

public class RefAppNotificationService extends FirebaseMessagingService {

    private static final String TAG = "RefAppNotificationService";
    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Map<String, String> map = remoteMessage.getData();
        String notificationSrc = map.get("source");
        if (notificationSrc != null && notificationSrc.equals("community")) {
            LiNotificationPayload notificationPayload= new LiNotificationPayload();
            notificationPayload.setFromId(map.get("fromId"));
            notificationPayload.setFromName(map.get("fromName"));
            notificationPayload.setType(map.get("type"));
            notificationPayload.setMessage(map.get("message"));
            showCommunityNotification(this, notificationPayload);
        }
        else {
            //TODO this is the space where the developer will have his other notification layout setup
        }
    }

    private void showCommunityNotification(Context context, LiNotificationPayload notificationPayload) {
        String contentText;
        String alertTitle;
        String type = notificationPayload.getType();
        String fromName = notificationPayload.getFromName();
        String message = notificationPayload.getMessage();
        String messageID;
        if (type.equals("kudos")) {
            contentText = String.format(getString(R.string.li_message_kudo_notif_content_text),
                    fromName );
            alertTitle = getString(R.string.li_message_kudo_notif_alert_text);
            messageID = new JsonParser().parse(message).getAsJsonObject()
                    .get("eventSummary").getAsJsonObject().get("entityId").getAsString();
        }
        else if(type.equals("solutions")) {
            contentText = String.format(getString(R.string.li_message_solution_notif_content_text),
                    fromName );
            alertTitle = getString(R.string.li_message_solution_notif_alert_text);
            messageID = new JsonParser().parse(message).getAsJsonObject()
                    .get("eventSummary").getAsJsonObject().get("topicUid").getAsString();
        }
        else {
            contentText = String.format(getString(R.string.li_message_messages_notif_content_text),
                    fromName);
            alertTitle = getString(R.string.li_message_messages_notif_alert_text);
            messageID = new JsonParser().parse(message).getAsJsonObject()
                    .get("eventSummary").getAsJsonObject().get("topicUid").getAsString();
        }

        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context)
                        .setContentTitle(alertTitle)
                        .setContentText(contentText);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        mBuilder.setSmallIcon(R.mipmap.ic_launcher);
        Intent notificationIntent = new Intent(this, LiConversationActivity.class);
        notificationIntent.putExtra(LiSDKConstants.UPDATE_TOOLBAR_TITLE, true);
        notificationIntent.putExtra(LiSDKConstants.SELECTED_MESSAGE_ID, Long.valueOf(messageID));
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(contentIntent);
        Notification notif = mBuilder.build();

        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1, notif);

    }
    // [END receive_message]
}