package lithium.community.sdk.example;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import lithium.community.android.sdk.client.manager.LiClientManager;
import lithium.community.android.sdk.ui.components.activities.LiCreateMessageActivity;
import lithium.community.android.sdk.ui.components.activities.LiSupportHomeActivity;
import lithium.community.android.sdk.ui.components.utils.LiSDKConstants;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startHelpSupportFlow = (Button) findViewById(R.id.startHelpSupportFlow);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        startHelpSupportFlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startHelpAndSupport();
            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createMessageFlow(view);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        else if (id == R.id.li_action_logout) {
            LiClientManager.getInstance().getLiAuthManager().logout(this);
        }

        return super.onOptionsItemSelected(item);
    }

    private void createMessageFlow(View view) {
        Intent i = new Intent(view.getContext(), LiCreateMessageActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(LiSDKConstants.ASK_Q_CAN_SELECT_A_BOARD, true);
        bundle.putString(LiSDKConstants.ASK_Q_SELECTED_BOARD,
                getString(R.string.li_general_discussion));
        bundle.putString(LiSDKConstants.ASK_Q_SELECTED_BOARD_ID,"");
        i.putExtras(bundle);
        startActivity(i);
    }

    private void startHelpAndSupport() {
        Intent i = new Intent(this, LiSupportHomeActivity.class);
        this.startActivity(i);
    }

}
