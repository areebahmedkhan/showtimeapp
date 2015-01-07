package team.inventeaze.bookyourshow;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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
        try {
            if (position == 1) {
                fragment = new LoginEmailFragment();
            }
            if (position == 2) {
                fragment = new SignUpFragment();
                isSignUpClick = true;
                invalidateOptionsMenu();
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.push_left_in, R.anim.push_left_out, R.anim.push_right_in, R.anim.push_right_out);
            transaction.replace(R.id.content_frame, fragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }catch (NullPointerException ex){
            Toast.makeText(this,"Not Set -- Null Pointer Exception Occurs",Toast.LENGTH_LONG).show();
        }

    }
}
