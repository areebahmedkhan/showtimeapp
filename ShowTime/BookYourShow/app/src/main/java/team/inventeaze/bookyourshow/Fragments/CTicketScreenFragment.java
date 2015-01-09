package team.inventeaze.bookyourshow.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import team.inventeaze.bookyourshow.R;

/**
 * Created by AbdulMueed on 1/9/2015.
 */
public class CTicketScreenFragment extends Fragment implements View.OnClickListener {

    View view;
    public int selectedItemNumber; //0=events, 1=movie , 2 = plays, 3=concert, 4=all

    ImageView left_drawer_image;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.events_page_layout,container,false);
        inititializeItems();

        return view;
    }

    public void inititializeItems(){
        left_drawer_image = (ImageView) view.findViewById(R.id.imvLeftDrawerImage);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

        }
    }
}

