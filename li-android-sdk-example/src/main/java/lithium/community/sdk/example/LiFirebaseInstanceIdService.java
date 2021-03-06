package lithium.community.sdk.example;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import lithium.community.android.sdk.exception.LiRestResponseException;
import lithium.community.android.sdk.notification.LiNotificationProviderImpl;

/**
 * Created by sumit.pannalall on 12/29/16.
 */
public class LiFirebaseInstanceIdService extends FirebaseInstanceIdService {

    private static final String TAG = "LiFirebaseIIDService";

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the community side, send the
        // Instance ID token to your app server.
        registerWithCommunity();
    }
    // [END refresh_token]

    /**
     * Persist token to Notification service.
     * <p>
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     */
    private void registerWithCommunity() {
        // Get updated InstanceID token.
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        try {

            new LiNotificationProviderImpl().onIdRefresh(refreshedToken, this);
        } catch (LiRestResponseException e) {
            Log.e("LiSDK", "Could not post token (device id) to Notification service.");
        }
    }
}
