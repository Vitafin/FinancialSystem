package com.example.lijuan.myapplication.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lijuan.myapplication.R;
import com.example.lijuan.myapplication.db.Subject;

import java.util.List;

/**
 * Created by Lijuan on 2019/4/29.
 */

public class SubjectAdapter extends RecyclerView.Adapter<SubjectAdapter.ViewHolder> {

    private List<Subject> mSubjectList;

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView subjectId;
        EditText subjectName;
        EditText balanceDirection;
        EditText subjectType;
        TextView subjectStatus;
        Button subjectAmend;
        Button subjectStop;

        public ViewHolder(View view) {
            super(view);

            subjectId = (TextView) view.findViewById(R.id.subject_id);
            subjectName = (EditText) view.findViewById(R.id.subject_name);
            balanceDirection = (EditText) view.findViewById(R.id.balance_direction);
            subjectType = (EditText) view.findViewById(R.id.subject_type);
            subjectStatus = (TextView) view.findViewById(R.id.subject_status);
            subjectAmend = (Button) view.findViewById(R.id.subject_amend);
            subjectStop = (Button) view.findViewById(R.id.subject_stop);

        }
    }


    public SubjectAdapter(List<Subject> subjectList){
        mSubjectList = subjectList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);



        holder.subjectAmend.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Subject subject = mSubjectList.get(position);

                String name = holder.subjectName.getText().toString();
                String balance = holder.balanceDirection.getText().toString();
                String type = holder.subjectType.getText().toString();

                if(name.isEmpty()){
                    Toast.makeText(v.getContext(),"科目名称不能为空！",Toast.LENGTH_SHORT).show();
                }else if(balance.isEmpty()){
                    Toast.makeText(v.getContext(),"余额方向不能为空！",Toast.LENGTH_SHORT).show();
                }else if(type.isEmpty()){
                    Toast.makeText(v.getContext(),"科目类别不能为空！",Toast.LENGTH_SHORT).show();
                }else{
                    subject.setSub_title(name);
                    subject.setBalance_direction(balance);
                    subject.setSub_type(type);

                    subject.save();

                    Toast.makeText(v.getContext(),"修改成功！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.subjectStop.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int positon = holder.getAdapterPosition();
                Subject subject = mSubjectList.get(positon);
                subject.setSub_status(false);
                subject.save();

                Toast.makeText(v.getContext(),"该科目已停用！",Toast.LENGTH_SHORT).show();
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Subject subject = mSubjectList.get(position);
        holder.subjectId.setText(subject.getSub_id()+"");
        holder.subjectName.setText(subject.getSub_title());
        holder.balanceDirection.setText(subject.getBalance_direction());
        holder.subjectType.setText(subject.getSub_type());

        if(subject.getSub_status()) {
            holder.subjectStatus.setText("启用");
        }
        else {
            holder.subjectStatus.setText("停用");
            holder.subjectAmend.setEnabled(false);
            holder.subjectStop.setEnabled(false);
            holder.subjectAmend.setBackgroundColor(0xff888888);
            holder.subjectStop.setBackgroundColor(0xff888888);
        }
    }


    @Override
    public int getItemCount() {
        return mSubjectList.size();
    }
}
