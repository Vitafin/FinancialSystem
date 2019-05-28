package com.example.lijuan.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lijuan.myapplication.R;
import com.example.lijuan.myapplication.db.Account;

import java.util.List;

/**
 * Created by Lijuan on 2019/5/17.
 */

public class AccountStaffAdapter extends RecyclerView.Adapter<AccountStaffAdapter.ViewHolder> {
    private List<Account> mAccountList;

    public AccountStaffAdapter(List<Account> accountList){
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
        TextView accountCheck;

        public ViewHolder(View view){
            super(view);

            accountType = (TextView)view.findViewById(R.id.query_type_staff);
            accountId = (TextView) view.findViewById(R.id.query_id_staff);
            accountDate = (TextView) view.findViewById(R.id.query_date_staff);
            accountAbstract = (TextView) view.findViewById(R.id.query_abstract_staff);
            accountDirection = (TextView) view.findViewById(R.id.query_direction_staff);
            accountValue = (TextView) view.findViewById(R.id.query_value_staff);
            accountAppliant =(TextView) view.findViewById(R.id.query_appliant_staff);
            accountCheck = (TextView)view.findViewById(R.id.query_check_staff);
        }

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_query_staff_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account account = mAccountList.get(position);
        holder.accountType.setText(account.getAccount_type());
        holder.accountId.setText(account.getAccount_id()+"");
        holder.accountAbstract.setText(account.getAccount_abstract());
        holder.accountDirection.setText(account.getDirection());
        holder.accountDate.setText(account.getAccount_date().getYear()+"-"+account.getAccount_date().getMonth()+"-"+account.getAccount_date().getDay());
        holder.accountValue.setText(account.getAccount_value()+"");
        holder.accountAppliant.setText(account.getAppliant());
        if(account.getChecked()){
            if (account.getAgreen()) holder.accountCheck.setText("审核通过");
            else holder.accountCheck.setText("审核未通过");
        }else{
            holder.accountCheck.setText("未审核");
        }
    }

    @Override
    public int getItemCount() {
        return mAccountList.size();
    }
}
