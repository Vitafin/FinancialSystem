package com.example.lijuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lijuan.myapplication.db.Account;
import com.example.lijuan.myapplication.Adapter.AccountStaffAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class AccountQueryStaff extends BaseActivity {

    private List<Account> accountList = new ArrayList<>();
    String staffname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_query_staff);

        Intent intent1 = getIntent();
        staffname = intent1.getStringExtra("staffname");

        initAccounts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.account_query_staff_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AccountStaffAdapter accountStaffAdapter = new AccountStaffAdapter(accountList);
        recyclerView.setAdapter(accountStaffAdapter);

        ImageButton back = (ImageButton) findViewById(R.id.query_staff_back);
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
