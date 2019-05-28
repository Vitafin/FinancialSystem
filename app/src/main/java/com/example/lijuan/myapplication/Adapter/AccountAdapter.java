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
 * Created by Lijuan on 2019/5/2.
 */

public class AccountAdapter extends RecyclerView.Adapter<AccountAdapter.ViewHolder> {

    private List<Account> mAccountList;

    public AccountAdapter(List<Account> accountList){
        mAccountList = accountList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView queryType;
        TextView queryId;
        TextView queryDate;
        TextView queryAbstract;
        TextView queryDirection;
        TextView queryValue;
        TextView queryAppliant;
        TextView queryCheck;
        Button queryAmend;
        Button queryDelete;

        public ViewHolder(View view){
            super(view);

            queryType = (TextView)view.findViewById(R.id.query_type);
            queryId = (TextView) view.findViewById(R.id.query_id);
            queryDate = (TextView) view.findViewById(R.id.query_date);
            queryAbstract = (TextView) view.findViewById(R.id.query_abstract);
            queryDirection = (TextView) view.findViewById(R.id.query_direction);
            queryValue = (TextView) view.findViewById(R.id.query_value);
            queryAppliant =(TextView) view.findViewById(R.id.query_appliant);
            queryCheck = (TextView)view.findViewById(R.id.query_cheak);
            queryAmend = (Button)view.findViewById(R.id.query_amend);
            queryDelete = (Button)view.findViewById(R.id.query_delete);
        }

    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.account_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);

        holder.queryAmend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Account account = mAccountList.get(position);

                String type = holder.queryType.getText().toString();
                String accAbstract = holder.queryAbstract.getText().toString();
                int value = Integer.parseInt(holder.queryValue.getText().toString());

                if(type.isEmpty()){
                    Toast.makeText(v.getContext(),"账户不能为空！",Toast.LENGTH_SHORT).show();
                }else if(accAbstract.isEmpty()){
                    Toast.makeText(v.getContext(),"摘要不能为空！",Toast.LENGTH_SHORT).show();
                }else if(holder.queryValue.getText().toString().isEmpty()){
                    Toast.makeText(v.getContext(),"金额不能为空！",Toast.LENGTH_SHORT).show();
                }else{
                    account.setAccount_type(type);
                    account.setAccount_abstract(accAbstract);
                    account.setAccount_value(value);
                    account.save();
                    Toast.makeText(v.getContext(),"修改成功！",Toast.LENGTH_SHORT).show();
                }

            }
        });

        holder.queryDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                Account account = mAccountList.get(positon);

                account.delete();

                Toast.makeText(v.getContext(),"删除成功！",Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account account = mAccountList.get(position);
        holder.queryType.setText(account.getAccount_type());
        holder.queryId.setText(account.getAccount_id()+"");
        holder.queryAbstract.setText(account.getAccount_abstract());
        holder.queryDirection.setText(account.getDirection());
        holder.queryDate.setText(account.getAccount_date().getYear()+"-"+
                account.getAccount_date().getMonth()+"-"+account.getAccount_date().getDay());
        holder.queryValue.setText(account.getAccount_value()+"");
        holder.queryAppliant.setText(account.getAppliant());
        if(account.getChecked()){
            if (account.getAgreen()) holder.queryCheck.setText("审核通过");
            else holder.queryCheck.setText("审核未通过");
        }else{
            holder.queryCheck.setText("未审核");
        }
    }

    @Override
    public int getItemCount() {
        return mAccountList.size();
    }


}
