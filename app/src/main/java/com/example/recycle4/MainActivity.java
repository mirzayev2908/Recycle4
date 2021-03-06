package com.example.recycle4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.recycle4.listener.OnBottomReachedListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        List<Member> members=prepareMemberList();
        refreshAdapter(members);
    }

    private void initViews() {
        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter= new CustomAdapter(context, members, new OnBottomReachedListener() {
            @Override
            public void onBottomReached(int position) {

            }
        }) {
            @Override
            public void OnBottomReached(int position) {

            }
        };
        recyclerView.setAdapter(adapter);
    }


    private List<Member> prepareMemberList(){
        List<Member> members=new ArrayList<>();
        members.add(new Member());
        for (int i = 0; i <30 ; i++) {
            if (i==0||i==5||i==16||i==25){
                members.add(new Member("Mirzayev "+i,"Shaxzod "+i, false));
            } else{ members.add(new Member("Mirzayev "+i,"Shaxzod "+i, true));}
        }
        members.add(new Member());
        return members;
    }
}