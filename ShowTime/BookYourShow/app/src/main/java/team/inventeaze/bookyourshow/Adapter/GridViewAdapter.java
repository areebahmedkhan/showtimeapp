package team.inventeaze.bookyourshow.Adapter;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import team.inventeaze.bookyourshow.R;

public class GridViewAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<String> items;
	
	public GridViewAdapter(Context context, ArrayList<String> items) {
		this.context = context;
		this.items = items;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return items.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return items.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		int[] images= {R.drawable.all,R.drawable.icon_movie2,R.drawable.events_icon,R.drawable.parties};
		
		if(convertView == null)
		{
			LayoutInflater inflater = 
					(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.team_grid_item, null);
			
			TextView tv = (TextView)convertView.findViewById(R.id.grid_item_text);
            if(items.get(position).equals("0")){
                tv.setText("ALL");
            }
            if(items.get(position).equals("1")){
                tv.setText("MOVIES");
            }
            if(items.get(position).equals("2")){
                tv.setText("EVENTS");
            }
            if(items.get(position).equals("3")){
                tv.setText("PARTIES");
            }

			ImageView user_images = (ImageView) convertView.findViewById(R.id.grid_item_image);
			user_images.setImageResource(images[position]);
			
		}
		return convertView;
	}

}
