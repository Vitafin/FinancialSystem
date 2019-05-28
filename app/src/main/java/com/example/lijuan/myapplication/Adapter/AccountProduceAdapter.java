package com.example.lijuan.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lijuan.myapplication.R;
import com.example.lijuan.myapplication.db.Account;

import java.util.List;

/**
 * Created by Lijuan on 2019/5/5.
 */

public class AccountProduceAdapter extends RecyclerView.Adapter<AccountProduceAdapter.ViewHolder> {

    private List<Account> mAccountList;
    public AccountProduceAdapter(List<Account> accountList){
        mAccountList = accountList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView accountType;
        TextView accountId;
        TextView accountDate;
        TextView accountAbstract;
        TextView accountDirection;
        TextView accountValue;
        TextView accountAppliant;
        Button pass;
        Button nopass;

        public ViewHolder(View view){
            super(view);

            accountType = (TextView) view.findViewById(R.id.account_produce_type);
            accountId = (TextView) view.findViewById(R.id.account_produce_id);
            accountDate = (TextView) view.findViewById(R.id.account_produce_date);
            accountAbstract = (TextView) view.findViewById(R.id.account_produce_abstract);
            accountDirection = (TextView)view.findViewById(R.id.account_produce_direction);
            accountValue = (TextView) view.findViewById(R.id.account_produce_value);
            accountAppliant = (TextView) view.findViewById(R.id.account_produce_appliant);
            pass = (Button) view.findViewById(R.id.account_produce_pass);
            nopass = (Button) view.findViewById(R.id.account_produce_nopass);
        }

    }
    @Override
    public AccountProduceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_produce_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.pass.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Account account = mAccountList.get(position);

                account.setChecked(true);
                account.setAgreen(true);

                account.save();
                Toast.makeText(v.getContext(),"审核通过！",Toast.LENGTH_SHORT).show();
            }
        });
        holder.nopass.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Account account = mAccountList.get(position);

                account.setChecked(true);
                account.setAgreen(false);

                account.save();
                Toast.makeText(v.getContext(),"审核不通过！",Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(AccountProduceAdapter.ViewHolder holder, int position) {
        Account account = mAccountList.get(position);
        holder.accountType.setText(account.getAccount_type());
        holder.accountId.setText(account.getAccount_id()+"");
        holder.accountAbstract.setText(account.getAccount_abstract());
        holder.accountDirection.setText(account.getDirection());
        holder.accountDate.setText(account.getAccount_date().getYear()+"-"+account.getAccount_date().getMonth()+"-"+account.getAccount_date().getDay());
        holder.accountValue.setText(account.getAccount_value()+"");
        holder.accountAppliant.setText(account.getAppliant());

    }

    @Override
    public int getItemCount() {
        return mAccountList.size();
    }

}
