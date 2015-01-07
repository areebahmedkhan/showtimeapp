package team.inventeaze.bookyourshow;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DELL on 12/31/2014.
 */
public class eventScreen extends FragmentActivity {
    @Override
    public View onCreateView(String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(LAYOUT_INFLATER_SERVICE);
        init();
        return inflater.inflate(R.layout.events_screen,null,false);

    }

    public void init(){
        TextView txt_event_name = (TextView)findViewById(R.id.txt_event_name);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),
                "fonts/RosewoodStd-Regular.otf");
        txt_event_name.setTypeface(custom_font);
    }
}
