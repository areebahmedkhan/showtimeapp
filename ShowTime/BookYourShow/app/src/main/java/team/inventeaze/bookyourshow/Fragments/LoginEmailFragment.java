package team.inventeaze.bookyourshow.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import team.inventeaze.bookyourshow.R;

/**
 * Created by DELL on 1/4/2015.
 */
public class LoginEmailFragment extends Fragment implements View.OnClickListener {

    EditText email;
    View viewForNothing;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.login_email_fragment,container,false);
        init(view);

        return view;
    }

    public void init(View view){
        email = (EditText)view.findViewById(R.id.txt_email);
        viewForNothing = view.findViewById(R.id.viewclick);
        viewForNothing.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.viewclick:
                Log.d("VIEW"," View Click For Nothing");
                break;
        }
    }
}
