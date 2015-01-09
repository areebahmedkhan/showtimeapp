package team.inventeaze.bookyourshow;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.Request;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.model.GraphUser;

import team.inventeaze.bookyourshow.Adapter.LoginListAdapter;
import team.inventeaze.bookyourshow.Fragments.LoginEmailFragment;
import team.inventeaze.bookyourshow.Fragments.SignUpFragment;

/**
 * Created by DIGITAL on 12/30/2014.
 */
public class loginScreen extends FragmentActivity implements AdapterView.OnItemClickListener {

    ListView login_list;
    boolean isSignUpClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        init();
    }

    public void init(){
        login_list = (ListView)findViewById(R.id.listview_login);
        LoginListAdapter adapter = new LoginListAdapter(this);
        login_list.setOnItemClickListener(this);
        login_list.setAdapter(adapter);
    }

    MenuItem save_btn;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        save_btn = (MenuItem)menu.findItem(R.id.action_save);
        return true;
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(isSignUpClick){
            save_btn.setVisible(true);
        }else{
            save_btn.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                FragmentManager fm= getSupportFragmentManager();
                if(fm.getBackStackEntryCount()>0){
                    fm.popBackStack();
                    isSignUpClick = false;
                    invalidateOptionsMenu();
                }else{
                    finish();
                    overridePendingTransition(R.anim.push_right_in,R.anim.push_right_out);
                }
            break;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        selectItem(position);
    }

    public void selectItem(int position){
        Fragment fragment = null;
      //  try {
            if (position == 1) {
                fragment = new LoginEmailFragment();
            }
            else if (position == 2) {
                fragment = new SignUpFragment();
                isSignUpClick = true;
                invalidateOptionsMenu();
            }
            else if(position == 0) {
                Toast.makeText(this,"here we go.",Toast.LENGTH_LONG).show();
                LoginWithFacebook();
                return;
            }

            //this is what you should do, catching is jugar :p in this case its not jugar always but
            //here we can solve it in this way since we know why null pointer exception can occur :)..
            if(fragment == null) {
                Toast.makeText(this,"No Fragment Selected",Toast.LENGTH_LONG).show();
                return;
            }

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out, R.anim.push_right_in, R.anim.push_right_out);
            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
      //  }catch (NullPointerException ex){
        //    Toast.makeText(this,"Not Set -- Null Pointer Exception Occurs",Toast.LENGTH_LONG).show();
       // }

    }

    public void LoginWithFacebook() {
        // start Facebook Login
        Session.openActiveSession(this, true, new Session.StatusCallback() {

            // callback when session changes state
            public void call(Session session, SessionState state, Exception exception) {
                if (session.isOpened()) {
                    // make request to;2 the /me API
                    Request.executeMeRequestAsync(session, new Request.
                            GraphUserCallback() {

                        // callback after Graph API response with user object
                        @Override
                        public void onCompleted(GraphUser user, Response response) {
                            if (user != null) {
                                String username = user.getFirstName() + user.getMiddleName() + user.getLastName();
                                Toast.makeText(getApplicationContext(), "Success in fb login: " +username, Toast.LENGTH_LONG).show();


                                //Areeb here we get the name and other information in user object
                                //use it and move the class where we have to thanks :) :p

                            } else {

                                Toast.makeText(getApplicationContext(), "User is null: "+response, Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(data == null) {
            Toast.makeText(this,"No internet or something went wrong.",Toast.LENGTH_LONG).show();
            return;
        }

        if(requestCode == 64206) {

            if(Session.getActiveSession() == null) {
                Toast.makeText(getApplicationContext(),"No Session Available",Toast.LENGTH_LONG).show();
            }
            else {

                Session.getActiveSession().onActivityResult(this, requestCode, resultCode, data);

            }

            Log.i("Auth", "Code: " + requestCode + " resultCode: " + resultCode + " data: " + data);

        }
        else {
            Log.i("Auth", "Code: " + requestCode + " resultCode: " + resultCode + " data: " + data);
            Toast.makeText(this,"Cannot login via twitter something went wrong.",Toast.LENGTH_LONG).show();
        }

        super.onActivityResult(requestCode, resultCode, data);

    }
}
