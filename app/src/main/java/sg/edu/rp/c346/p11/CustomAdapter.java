package sg.edu.rp.c346.p11;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<String> {
    private String[] text;
    private Context context;
    private TextView tvText;
    private ImageView iv;

    public CustomAdapter(Context context, int resource, String[] objects){
        super(context, resource, objects);

        text = objects;

        this.context = context;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.row, parent, false);


        tvText = (TextView) rowView.findViewById(R.id.tvText);

        iv = (ImageView) rowView.findViewById(R.id.iv);



        String currentText = text[position];


        tvText.setText(currentText);

        if(currentText.equalsIgnoreCase("Bio")){
            iv.setImageResource(R.drawable.about);
        }else if(currentText.equalsIgnoreCase("Vaccination")){
            iv.setImageResource(R.drawable.edit);
        }else if(currentText.equalsIgnoreCase("Anniversary")){
            iv.setImageResource(R.drawable.calender);
        }else if(currentText.equalsIgnoreCase("About us")){
            iv.setImageResource(R.drawable.star);
        }

        return rowView;
    }
}
