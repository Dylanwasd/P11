package sg.edu.rp.c346.p11;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BioFragment extends Fragment {
    TextView tvBio;
    Button edit;
    EditText etBio;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_bio, container, false);
        tvBio = view.findViewById(R.id.tvBio);
        edit = view.findViewById(R.id.btnEdit);
        etBio = view.findViewById(R.id.etBio);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBio.setText(etBio.getText().toString());
            }
        });
        return view;

    }
    @Override
    public void onPause(){
        super.onPause();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        SharedPreferences.Editor prefEdit = prefs.edit();

        prefEdit.putString("bio", tvBio.getText().toString());
        prefEdit.commit();
    }

    @Override
    public void onResume(){
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());

        String msg = prefs.getString("bio","No Bio");

        tvBio.setText(msg);
    }
}
