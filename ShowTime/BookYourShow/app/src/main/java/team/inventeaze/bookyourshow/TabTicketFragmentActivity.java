package team.inventeaze.bookyourshow;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

import team.inventeaze.bookyourshow.Adapter.GridViewAdapter;

/**
 * Created by DELL on 12/27/2014.
 */
public class TabTicketFragmentActivity extends FragmentActivity implements AdapterView.OnItemClickListener {

    private GridViewAdapter customAdapter;
    private ArrayList<String> items = new ArrayList<String>();
    private GridView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_ticket_layout);

        for(int i = 0; i < 4; i++)
        {
            items.add(Integer.toString(i));
        }

        customAdapter = new GridViewAdapter(this, items);
        view = (GridView) findViewById(R.id.gridview);
        view.setAdapter(customAdapter);
        view.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //Toast.makeText(this, "Position = " + position, Toast.LENGTH_LONG).show();
        if(position == 2){

        }
    }
}
