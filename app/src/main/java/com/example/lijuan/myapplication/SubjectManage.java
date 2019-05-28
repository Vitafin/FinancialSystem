package com.example.lijuan.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.example.lijuan.myapplication.db.Subject;
import com.example.lijuan.myapplication.Adapter.SubjectAdapter;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class SubjectManage extends BaseActivity {

    private List<Subject> subjectList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_manage);

        initSubjects();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.subject_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SubjectAdapter subjectAdapter = new SubjectAdapter(subjectList);
        recyclerView.setAdapter(subjectAdapter);

        ImageButton addSubject = (ImageButton) findViewById(R.id.add_subject_manage);

        addSubject.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SubjectManage.this, AddSubject.class);
                startActivity(intent);
                finish();
            }
        });

        ImageButton backSubject = (ImageButton) findViewById(R.id.subject_manage_back);

        backSubject.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void initSubjects(){
        subjectList = DataSupport.findAll(Subject.class);
        /*Subject subject1 = new Subject(123,"现金","借","资产",true);
        subjectList.add(subject1);

        Subject subject2 = new Subject(124,"现金","借","资产",true);
        subjectList.add(subject2);*/

    }

}
