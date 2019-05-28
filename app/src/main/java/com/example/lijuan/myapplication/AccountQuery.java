package com.example.lijuan.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lijuan.myapplication.db.Account;
import com.example.lijuan.myapplication.Adapter.AccountAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class AccountQuery extends BaseActivity {

    private List<Account> accountList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_query);

        initAccounts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.account_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AccountAdapter accountAdapter = new AccountAdapter(accountList);
        recyclerView.setAdapter(accountAdapter);

        ImageButton back = (ImageButton) findViewById(R.id.account_query_back);
        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void initAccounts(){
        accountList = DataSupport.findAll(Account.class);
    }
}
