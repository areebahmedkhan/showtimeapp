package team.inventeaze.bookyourshow.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import team.inventeaze.bookyourshow.R;

/**
 * Created by DELL on 1/4/2015.
 */
public class LoginEmailListAdapter extends ArrayAdapter {

    private Context context;
    private  String[] icon_box_hint;
    private  int[] images = {R.drawable.login_email,R.drawable.password};

    public LoginEmailListAdapter(Context context) {
        super(context, 0);
        this.context = context;
        icon_box_hint = context.getResources().getStringArray(R.array.login_email_options);
    }



    @Override
    public int getCount() {
        return icon_box_hint.length;
    }

    @Override
    public Object getItem(int position) {
        return icon_box_hint[position];
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.login_list_email_items,null);

        ImageView icon = (ImageView)convertView.findViewById(R.id.icon);
        EditText icon_box = (EditText)convertView.findViewById(R.id.icon_box);

        icon.setImageResource(images[position]);
        icon_box.setHint(icon_box_hint[position]);

        return convertView;
    }
}
