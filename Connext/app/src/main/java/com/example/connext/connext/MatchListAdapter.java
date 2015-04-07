package com.example.connext.connext;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by raahulbiswas on 15-04-06.
 */
public class MatchListAdapter extends BaseAdapter {
    Context context;
    List<MatchItem> rowItem;

    MatchListAdapter(Context context, List<MatchItem> rowItem) {
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
            convertView = mInflater.inflate(R.layout.match_list, null);
        }

        RoundedImageView imgIcon = (RoundedImageView) convertView.findViewById(R.id.picture);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.name);
        TextView matchText = (TextView) convertView.findViewById(R.id.percentage);

        MatchItem row_pos = rowItem.get(position);
        // setting the image resource and title
        new FetchImageTask(imgIcon).execute(row_pos.getIcon());

        txtTitle.setText(row_pos.getTitle());
        String stringdouble= Double.toString(row_pos.getMatch());
        matchText.setText(stringdouble);
//        matchText.setText(String.valueOf(row_pos.getMatch()));

        return convertView;

    }
}
