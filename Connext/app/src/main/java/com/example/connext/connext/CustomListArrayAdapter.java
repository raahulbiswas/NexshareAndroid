package com.example.connext.connext;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by raahulbiswas on 15-03-24.
 */
public class CustomListArrayAdapter extends BaseAdapter {

    Context context;
    List<RowItem> rowItem;

    CustomListArrayAdapter(Context context, List<RowItem> rowItem) {
        this.context = context;
        this.rowItem = rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.atteendee_list, null);
        }

        RoundedImageView imgIcon = (RoundedImageView) convertView.findViewById(R.id.picture);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.name);

        RowItem row_pos = rowItem.get(position);
        // setting the image resource and title
        new FetchImageTask(imgIcon).execute(row_pos.getIcon());

        txtTitle.setText(row_pos.getTitle());

        return convertView;

    }

}
