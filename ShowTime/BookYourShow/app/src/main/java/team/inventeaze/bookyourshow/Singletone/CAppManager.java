package team.inventeaze.bookyourshow.Singletone;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * Created by DELL on 1/10/2015.
 */
public class CAppManager {
    public static CAppManager appManager;

    public static CAppManager getInstance(){
        if(appManager == null)
            appManager = new CAppManager();
        return appManager;
    }

    public Typeface setFont(Context context , String path){
        Typeface font = Typeface.createFromAsset(context.getAssets(),path);
        return font;
    }
}
