package team.inventeaze.bookyourshow;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by DELL on 12/27/2014.
 */
public class splashScreen extends Activity implements Animation.AnimationListener, View.OnClickListener {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    Animation animation;
    ImageView login;
    TextView skip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        init();

        new Handler().postDelayed(new Runnable() {
             /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                //Intent intent = new Intent(splashScreen.this,loginScreen.class);
                //startActivity(intent);
                // close this activity
                //overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
                //finish();
                login.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                login.startAnimation(animation);
                skip.startAnimation(animation);
                //animation.setAnimationListener(new LoginAnimationListener(login));
            }
        }, SPLASH_TIME_OUT);
    }


    public void init(){
        login = (ImageView)findViewById(R.id.login);
        skip = (TextView)findViewById(R.id.skip);

        login.setOnClickListener(this);
        skip.setOnClickListener(this);

        animation = AnimationUtils.loadAnimation(getApplicationContext(),android.R.anim.fade_in);
        animation.setAnimationListener(this);




        Typeface custom_font = Typeface.createFromAsset(getAssets(),
                "fonts/Smush_demo.otf");
        skip.setTypeface(custom_font);


    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.login:
                intent = new Intent(this,loginScreen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
            break;
            case R.id.skip:
                intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
            break;
        }
    }
}
