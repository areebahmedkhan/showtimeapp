package team.inventeaze.bookyourshow.Listeners;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/**
 * Created by DELL on 1/3/2015.
 */
public class LoginAnimationListener implements AnimationListener {


    private ImageView image;

    public LoginAnimationListener(ImageView image){

        this.image = image;
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        image.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
