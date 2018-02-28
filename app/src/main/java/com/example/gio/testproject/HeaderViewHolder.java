package com.example.gio.testproject;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Gio on 2/28/2018.
 */

public class HeaderViewHolder extends RecyclerView.ViewHolder {
    public TextView headerTitle;

    public HeaderViewHolder(View itemView) {
        super(itemView);
        headerTitle = (TextView) itemView.findViewById(R.id.header_id);
    }
}