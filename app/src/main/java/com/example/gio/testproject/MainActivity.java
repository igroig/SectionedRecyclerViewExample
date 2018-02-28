package com.example.gio.testproject;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements RVSClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView sectionHeader;
    private SectionedRecyclerViewAdapter sectionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sectionHeader = (RecyclerView) findViewById(R.id.add_header);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        sectionHeader.setLayoutManager(linearLayoutManager);
        sectionHeader.setHasFixedSize(true);
        HeaderRecyclerViewSection firstSection = new HeaderRecyclerViewSection(this, "First Section", getDataSource());
        HeaderRecyclerViewSection secondSection = new HeaderRecyclerViewSection(this, "Second Section", getDataSource2());
        HeaderRecyclerViewSection thirdSection = new HeaderRecyclerViewSection(this, "Third Section", getDataSource3());
        sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(firstSection);
        sectionAdapter.addSection(secondSection);
        sectionAdapter.addSection(thirdSection);
        sectionHeader.setAdapter(sectionAdapter);
    }

    private List<ItemObject> getDataSource() {
        List<ItemObject> data = new ArrayList<ItemObject>();
        data.add(new ItemObject("111111111111111"));
        data.add(new ItemObject("This isisisisisisis the item content in the second position"));
        data.add(new ItemObject("This isisisisisisis the item content in the second position"));
        data.add(new ItemObject("This isisisisisisis the item content in the second position"));
        return data;
    }

    private List<ItemObject> getDataSource2() {
        List<ItemObject> data = new ArrayList<ItemObject>();
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("22222222222"));
        data.add(new ItemObject("This is the item content in the second position"));
        return data;
    }

    private List<ItemObject> getDataSource3() {
        List<ItemObject> data = new ArrayList<ItemObject>();
        data.add(new ItemObject("33333333333333333333333333"));
        data.add(new ItemObject("33333333333333333333333333"));
        data.add(new ItemObject("33333333333333333333333333"));
        data.add(new ItemObject("This is the item content in the second position"));
        data.add(new ItemObject("This is the item content in the second position"));
        return data;
    }

//    @Override
//    public void click(int position, HeaderRecyclerViewSection section) {
//        section.getItemByPosition(position);
//    }


    @Override
    public void click(ItemObject item) {
        Toast.makeText(this, item.getContents(), Toast.LENGTH_SHORT).show();
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",item);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}