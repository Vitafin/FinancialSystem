package com.example.lijuan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lijuan.myapplication.db.Subject;

public class AddSubject extends BaseActivity {
    Spinner subjectType;
    Spinner subjectName;
    String subType;
    String subName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_subject);

        final EditText subjectId = (EditText) findViewById(R.id.subject_id_add);
        subjectName = (Spinner) findViewById(R.id.subject_name_add);
        final EditText subjectBalance = (EditText) findViewById(R.id.balance_direction_add);
        subjectType = (Spinner) findViewById(R.id.subject_type_add);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.subject_type, R.layout.spinner_checked_text);
        subjectType.setAdapter(adapter);
        subjectType.setOnItemSelectedListener(new spinnerItemSelected());

        subjectName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subName = subjectName.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button addSubmit = (Button) findViewById(R.id.add_subject_submit);

        addSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                if((subjectId.getText().toString()).isEmpty()){
                    Toast.makeText(v.getContext(),"科目代码不能为空",Toast.LENGTH_SHORT).show();
                }else if((subjectBalance.getText().toString()).isEmpty()){
                    Toast.makeText(v.getContext(),"余额方向不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    int id = Integer.parseInt(subjectId.getText().toString());
                    String balance = subjectBalance.getText().toString();
                    Subject subject = new Subject(id,subName,balance,subType,true);
                    subject.save();
                    Toast.makeText(v.getContext(),"添加成功！",Toast.LENGTH_SHORT).show();
                }
            }
        });

        ImageButton backAdd = (ImageButton) findViewById(R.id.add_subject_back);

        backAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    class spinnerItemSelected implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner = (Spinner) parent;
            String pro = (String) spinner.getItemAtPosition(position);
            subType = subjectType.getSelectedItem().toString();

            ArrayAdapter<CharSequence> nameadapter = ArrayAdapter.createFromResource(getApplicationContext(),
                    R.array.def, R.layout.spinner_checked_text);

            if(pro.equals("资产")){
                nameadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.subject_assets,
                        R.layout.spinner_checked_text);
            }else if(pro.equals("负债")){
                nameadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.subject_debt,
                        R.layout.spinner_checked_text);
            }else if(pro.equals("共同")){
                nameadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.subject_share,
                        R.layout.spinner_checked_text);
            }else if(pro.equals("所有者权益")){
                nameadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.subject_ownership_interest,
                        R.layout.spinner_checked_text);
            }else if(pro.equals("成本")){
                nameadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.subject_cost,
                        R.layout.spinner_checked_text);
            }else if(pro.equals("损益")){
                nameadapter = ArrayAdapter.createFromResource(getApplicationContext(), R.array.subject_profit_loss,
                        R.layout.spinner_checked_text);
            }
            subjectName.setAdapter(nameadapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }
}
