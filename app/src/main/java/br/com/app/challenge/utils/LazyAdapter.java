package br.com.app.challenge.utils;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.app.challenge.smart_cities.R;

public class LazyAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid_l;
    private final Integer[] imgid_r;

    public LazyAdapter(Activity context, String[] itemname, Integer[] imgid_l, Integer[] imgid_r) {
        super(context, R.layout.my_list, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid_l=imgid_l;
        this.imgid_r=imgid_r;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.my_list, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView_left = (ImageView) rowView.findViewById(R.id.icon_left);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);
        ImageView imageView_right = (ImageView) rowView.findViewById(R.id.icon_right);

        txtTitle.setText(itemname[position]);
        imageView_left.setImageResource(imgid_l[position]);
        imageView_right.setImageResource(imgid_r[position]);
        extratxt.setText("Description "+itemname[position]);
        return rowView;
    };
}