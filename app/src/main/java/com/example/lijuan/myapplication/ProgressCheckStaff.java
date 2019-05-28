package com.example.lijuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lijuan.myapplication.db.Account;
import com.example.lijuan.myapplication.Adapter.ProgressAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ProgressCheckStaff extends BaseActivity {

    private List<Account> accountList = new ArrayList<>();
    String staffname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.progress_check_staff);

        Intent intent1 = getIntent();
        staffname = intent1.getStringExtra("staffname");

        initAccounts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.progress_check_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ProgressAdapter progressAdapter = new ProgressAdapter(accountList);
        recyclerView.setAdapter(progressAdapter);

        ImageButton back = (ImageButton) findViewById(R.id.progress_check_back);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initAccounts(){
        List<Account> accountAll = DataSupport.findAll(Account.class);
        for(Account account:accountAll){
            if(account.getAppliant().equals(staffname)) accountList.add(account);
        }
    }
}
