package com.example.gio.testproject;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;

/**
 * Created by Gio on 2/28/2018.
 */

public class HeaderRecyclerViewSection extends StatelessSection {
    private static final String TAG = HeaderRecyclerViewSection.class.getSimpleName();
        private String title;
        private List<ItemObject> list;
        private RVSClickListener listener;
        public HeaderRecyclerViewSection(RVSClickListener listener , String title, List<ItemObject> list) {
            super(R.layout.header, R.layout.item);
            this.title = title;
            this.list = list;
            this.listener = listener;
        }
        @Override
        public int getContentItemsTotal() {
            return list.size();
        }
        @Override
        public RecyclerView.ViewHolder getItemViewHolder(View view) {
            return new ItemViewHolder(view);
        }
        @Override
        public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
            ItemViewHolder iHolder = (ItemViewHolder)holder;
            iHolder.itemContent.setText(list.get(position).getContents());
            iHolder.itemContent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(TAG, "onClick: " + list.get(position).getContents());
//                    listener.click(position,HeaderRecyclerViewSection.this);
                    listener.click(list.get(position));
                }
            });
        }
        @Override
        public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
            return new HeaderViewHolder(view);
        }
        @Override
        public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
            HeaderViewHolder hHolder = (HeaderViewHolder)holder;
            hHolder.headerTitle.setText(title);
        }
}