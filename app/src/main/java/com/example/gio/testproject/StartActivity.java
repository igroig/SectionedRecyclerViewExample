package com.example.gio.testproject;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void click(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivityForResult(i, 77);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 77) {
            if(resultCode == Activity.RESULT_OK){
                ItemObject result=(ItemObject)data.getParcelableExtra("result");
                Toast.makeText(this, result.getContents() + "from list", Toast.LENGTH_SHORT).show();
            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//
}
