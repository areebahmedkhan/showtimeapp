package team.inventeaze.bookyourshow.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import team.inventeaze.bookyourshow.R;

/**
 * Created by DELL on 1/4/2015.
 */
public class LoginListAdapter extends ArrayAdapter {

    private Context context;
    private  String[] img_icons;
    private  int[] images = {R.drawable.facebook,R.drawable.login_email,R.drawable.sign_up};

    public LoginListAdapter(Context context) {
        super(context, 0);
        this.context = context;
        img_icons = context.getResources().getStringArray(R.array.login_list);
    }

    @Override
    public int getCount() {
        return img_icons.length;
    }

    @Override
    public Object getItem(int position) {
        return img_icons[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.login_list_items,parent,false);

        ImageView icon = (ImageView)convertView.findViewById(R.id.icon);
        TextView caption = (TextView)convertView.findViewById(R.id.caption);

        icon.setImageResource(images[position]);
        caption.setText(img_icons[position]);


        return convertView;
    }
}
