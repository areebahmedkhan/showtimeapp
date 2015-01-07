package team.inventeaze.bookyourshow.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import team.inventeaze.bookyourshow.R;

/**
 * Created by DELL on 1/7/2015.
 */
public class SignUpFragment extends Fragment {

    EditText name;
    EditText email;
    EditText password;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sign_up_fragment,container,false);
        init(view);

        return view;
    }

    public void init(View view){
        name = (EditText)view.findViewById(R.id.txt_username);
        email = (EditText)view.findViewById(R.id.txt_email);
        password = (EditText)view.findViewById(R.id.txt_pass);
    }

}
