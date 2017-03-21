package lithium.community.sdk.example;

import android.app.Application;
import android.util.Log;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import lithium.community.android.sdk.LiSDKManager;
import lithium.community.android.sdk.auth.LiAppCredentials;

public class MainApplication extends Application {

  public static final String LOG_TAG = "MainApplication";

  @Override
  public void onCreate() {
    super.onCreate();
    try {
      LiAppCredentials liAppCredentials = new LiAppCredentials.Builder()
              .setClientKey(getString(R.string.clientId))
              .setClientSecret(getString(R.string.clientSecret))
              .setCommunityUri(getString(R.string.communityURL)).build();
      LiSDKManager.init(this, liAppCredentials);
    } catch (MalformedURLException | URISyntaxException | IllegalArgumentException e) {
      Log.e(LOG_TAG, "Couldn't initialize Lithium SDK");
    }

  }
}
