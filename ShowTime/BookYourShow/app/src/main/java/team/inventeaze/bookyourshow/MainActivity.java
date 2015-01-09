package team.inventeaze.bookyourshow;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.AppEventsLogger;

import team.inventeaze.bookyourshow.Listeners.IPageEventListeners;

public class MainActivity extends FragmentActivity implements IPageEventListeners, View.OnClickListener {


    ImageView imageViewEvents;
    ImageView imageViewConcerts;
    ImageView imageViewPlays;
    ImageView imageViewMovies;
    ImageView imageViewAllCategories;
    ImageView imvLeftDrawer;



    DrawerLayout leftDrawerLayout;

    boolean isDrawerOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //we don't want any kind of title bar whatsoever lol

        setContentView(R.layout.events_page_layout);


        InitialzieElements();

    }

    public void InitialzieElements() {
        imageViewEvents = (ImageView) findViewById(R.id.imvevents);
        imageViewConcerts = (ImageView) findViewById(R.id.imvconcerts);
        imageViewMovies = (ImageView) findViewById(R.id.imvmovies);
        imageViewPlays = (ImageView) findViewById(R.id.imvplays);
        imageViewAllCategories = (ImageView) findViewById(R.id.imvallcategories);
        imvLeftDrawer = (ImageView) findViewById(R.id.imvLeftDrawerImage);


        imageViewPlays.setOnClickListener(this);
        imageViewMovies.setOnClickListener(this);
        imageViewConcerts.setOnClickListener(this);
        imageViewEvents.setOnClickListener(this);
        imvLeftDrawer.setOnClickListener(this);

    }


    public void ToggleDrawer() {
        if(isDrawerOpen) {

        }
        else {

        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
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

    @Override
    protected void onPause() {
        super.onPause();

        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    /*
    * Callback methods for views :p
    * */
    @Override
    public void EventInPage(int viewId, String eventName, Object object) {

    }

    @Override
    public void ViewPageDone(int viewId) {

    }

    @Override
    public void ViewPageFinish(int viewId) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imvallcategories:
                Toast.makeText(this,"Click All Cat",Toast.LENGTH_LONG).show();
                break;

            case R.id.imvconcerts:

                break;

            case R.id.imvevents:
                break;

            case R.id.imvmovies:
                break;

            case R.id.imvplays:
                break;

            case R.id.imvLeftDrawerImage:
                ToggleDrawer();
                break;
        }
    }
}
