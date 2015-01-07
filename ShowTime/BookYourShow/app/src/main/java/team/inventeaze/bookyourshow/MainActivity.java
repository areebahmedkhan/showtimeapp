package team.inventeaze.bookyourshow;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabhost = (TabHost)findViewById(android.R.id.tabhost);

        TabSpec tab_ticket = tabhost.newTabSpec("Tickets");
        TabSpec tab_you = tabhost.newTabSpec("You");
        TabSpec tab_discover = tabhost.newTabSpec("Discover");

        tab_ticket.setIndicator("Tickets");
        tab_ticket.setContent(new Intent(this,TabTicketFragmentActivity.class));

        tab_you.setIndicator("You");
        tab_you.setContent(new Intent(this,TabYouFragmentActivity.class));

        tab_discover.setIndicator("Discover");
        tab_discover.setContent(new Intent(this,TabDiscoverFragment.class));

        tabhost.addTab(tab_ticket);
        tabhost.addTab(tab_you);
        tabhost.addTab(tab_discover);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }*/
        return super.onOptionsItemSelected(item);
    }
}
