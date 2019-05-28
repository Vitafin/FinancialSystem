package com.example.lijuan.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lijuan.myapplication.MutiProgress;
import com.example.lijuan.myapplication.R;
import com.example.lijuan.myapplication.db.Account;

import java.util.List;

/**
 * Created by Lijuan on 2019/5/23.
 */

public class ProgressAdapter extends RecyclerView.Adapter<ProgressAdapter.ViewHolder> {
    private List<Account> mAccountList;
    public ProgressAdapter(List<Account> accountList){
        mAccountList = accountList;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView progressDate;
        TextView progressAbstract;
        MutiProgress mutiProgress;

        public ViewHolder(View view){
            super(view);

            progressDate = (TextView)view.findViewById(R.id.progress_date);
            progressAbstract = (TextView) view.findViewById(R.id.progress_abstract);
            mutiProgress = (MutiProgress) view.findViewById(R.id.mp_1);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.progress_check_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Account account = mAccountList.get(position);
        holder.progressAbstract.setText(account.getAccount_abstract());
        holder.progressDate.setText(account.getAccount_date().getYear()+"-"+account.getAccount_date().getMonth()+"-"+account.getAccount_date().getDay());
        if(account.getChecked()){
            if (account.getAgreen()) {

                holder.mutiProgress.nodesNum=3;
                holder.mutiProgress.currNodeState=1;
                holder.mutiProgress.currNodeNO=2;
            }
            else {
                holder.mutiProgress.nodesNum=3;
                holder.mutiProgress.currNodeState=0;
                holder.mutiProgress.currNodeNO=2;
            }
        }else{
            holder.mutiProgress.nodesNum=3;
            holder.mutiProgress.currNodeState=1;
            holder.mutiProgress.currNodeNO=0;
        }
    }


    @Override
    public int getItemCount() {
        return mAccountList.size();
    }
}
