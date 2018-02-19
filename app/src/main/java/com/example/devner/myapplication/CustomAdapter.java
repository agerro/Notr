package com.example.devner.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Vaari on 2018-02-18.
 */

public class CustomAdapter extends ArrayAdapter<Note> implements View.OnClickListener{

    private ArrayList<Note> dataSet;
    Context mContext;

    // View lookup cache
    private static class ViewHolder {
        TextView txtName;
        TextView txtType;
        ImageView deleteButton;
    }

    public CustomAdapter(ArrayList<Note> data, Context context) {
        super(context, R.layout.list_item_custom, data);
        this.dataSet = data;
        this.mContext=context;

    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        Note dataModel = (Note)object;

        switch (v.getId())
        {
            case R.id.imageDelete:
                //MainActivity.deleteNote(dataModel);
                System.out.println("action: delete note");
                break;
        }
    }

    private int lastPosition = -1;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Note dataModel = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder; // view lookup cache stored in tag

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.list_item_custom, parent, false);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textPayload);
            viewHolder.txtType = (TextView) convertView.findViewById(R.id.textId);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result=convertView;
        }
        lastPosition = position;

        viewHolder.txtName.setText(dataModel.getNotePayload());
        viewHolder.txtType.setText(String.valueOf(dataModel.getNoteId()));
        // Return the completed view to render on screen
        return convertView;
    }
}
