package com.example.lijuan.myapplication;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lijuan.myapplication.db.Account;
import com.example.lijuan.myapplication.Adapter.AccountProduceAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class AccountProduce extends BaseActivity {

    private List<Account> accountList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_produce);

        initAccounts();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.account_produce_recycleview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        AccountProduceAdapter accountAdapter = new AccountProduceAdapter(accountList);
        recyclerView.setAdapter(accountAdapter);

        ImageButton back = (ImageButton) findViewById(R.id.account_produce_back);
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
            if(!account.getChecked()) accountList.add(account);
        }

    }
}
