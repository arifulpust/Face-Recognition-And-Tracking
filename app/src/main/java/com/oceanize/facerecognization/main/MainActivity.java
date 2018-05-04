package com.oceanize.facerecognization.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.oceanize.facerecognization.R;
import com.oceanize.facerecognization.eyetrack.GooglyEyesActivity;
import com.oceanize.facerecognization.facedetect.FaceActivity;
import com.oceanize.facerecognization.facedetectfromphoto.PhotoViewerActivity;
import com.oceanize.facerecognization.facetrack.FaceTrackerActivity;
import com.oceanize.facerecognization.multifacetrack.MultiTrackerActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements OnItemListener {
    @BindView(R.id.list)
    RecyclerView list;
List<String> menu= Arrays.asList("Face Detect from Photo", "Face Tracking","Multi Face Tracking","Eye Track","Face Track");
MenuAdapter  menuAdapter;
Unbinder unbinder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder= ButterKnife.bind(this);


        list.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        list.setHasFixedSize(true);
        menuAdapter=new MenuAdapter(getApplicationContext(),menu,this);
        list.setAdapter(menuAdapter);

    }

    @Override
    public void ItemPosition(int Position, String Value, int Type) {
        Log.e("getItemPosition",Position+"  "+Value+" "+Type);
        if(Position==0)
        {
            Intent intent=new Intent(MainActivity.this, PhotoViewerActivity.class);
            startActivity(intent);
        } else if (Position==1) {
            Intent intent=new Intent(MainActivity.this, FaceTrackerActivity.class);
            startActivity(intent);
        }
        else if (Position==2) {
            Intent intent=new Intent(MainActivity.this, MultiTrackerActivity.class);
            startActivity(intent);
        }
        else if (Position==3) {
            Intent intent=new Intent(MainActivity.this, GooglyEyesActivity.class);
            startActivity(intent);
        }
        else if (Position==4) {
            Intent intent=new Intent(MainActivity.this, FaceActivity.class);
            startActivity(intent);
        }
        //FaceActivity



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
