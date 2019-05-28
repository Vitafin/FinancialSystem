package com.example.lijuan.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.lijuan.myapplication.db.Staff;

import org.litepal.crud.DataSupport;

public class RegisterActivity extends AppCompatActivity {

    private EditText registerAccount;
    private String type;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerAccount=(EditText) findViewById(R.id.register_account);

        final EditText registerPassword = (EditText) findViewById(R.id.register_password);

        final Button registerCommit = (Button) findViewById(R.id.register_commit);

        final Spinner staffType = (Spinner) findViewById(R.id.staff_type);

        String[] sItems = getResources().getStringArray(R.array.staff_type);

        ArrayAdapter<String>  adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,sItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        staffType.setAdapter(adapter);
        staffType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                String[] stafftype = getResources().getStringArray(R.array.staff_type);
                type = stafftype[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });


        registerCommit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Staff staff = new Staff();
                String account = registerAccount.getText().toString();
                String password = registerPassword.getText().toString();

                if(account.isEmpty()||password.isEmpty()){
                    Toast.makeText(RegisterActivity.this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                }else{
                    Cursor cursor = DataSupport.findBySQL("select * from Staff where name = ?",account);

                    if(cursor.getCount()==0){
                        staff.setName(account);
                        staff.setPassword(password);


                        if(type.equals("普通员工")){
                            staff.setAdminstrator(false);
                        }else{
                            staff.setAdminstrator(true);
                        }
                        staff.save();

                        Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        Toast.makeText(RegisterActivity.this, "该用户名已存在", Toast.LENGTH_SHORT).show();
                    }
                }




            }
        });

    }
}
