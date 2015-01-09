package team.inventeaze.bookyourshow;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.facebook.AppEventsLogger;

import team.inventeaze.bookyourshow.Listeners.IPageEventListeners;

public class MainActivity extends FragmentActivity implements IPageEventListeners {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE); //we don't want any kind of title bar whatsoever lol

        setContentView(R.layout.events_page_layout);


        InitialzieElements();

    }

    public void InitialzieElements() {

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
}
