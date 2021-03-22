package com.example.sql;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ThreeColumn_ListAdapter extends ArrayAdapter<User> {

    private LayoutInflater mInflater;
    private ArrayList<User> users;
    private int mViewResourceId;

    public ThreeColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<User> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = mInflater.inflate(mViewResourceId, null);

        User user = users.get(position);

        if (user != null) {
            TextView Name = (TextView) convertView.findViewById(R.id.textName);
            TextView email = (TextView) convertView.findViewById(R.id.textemail);
            TextView phone = (TextView) convertView.findViewById(R.id.textphone);


            if (Name != null) {
                Name.setText(user.getName());
            }
            if (email != null) {
                email.setText((user.getEmail()));
            }
            if (phone != null) {
                phone.setText((user.getPhone()));
            }
        }

        return convertView;
    }

}
