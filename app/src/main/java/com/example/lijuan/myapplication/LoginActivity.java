package com.example.lijuan.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class LoginActivity extends BaseActivity {

    private EditText accountEdit;

    private EditText passwordEdit;

    private Button login;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Connector.getDatabase();

        accountEdit=(EditText) findViewById(R.id.account);
        passwordEdit=(EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if(name.isEmpty()||password.isEmpty()){
                    Toast.makeText(LoginActivity.this, "请填写用户名或密码", Toast.LENGTH_SHORT).show();
                }
                else{
                    Cursor cursor = DataSupport.findBySQL("select * from Staff where name = ? and password = ?",name,password);
                    if(cursor.getCount()== 0){
                        Toast.makeText(LoginActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }else{

                        cursor.moveToFirst();
                        boolean administer = cursor.getInt(cursor.getColumnIndex("adminstrator"))==1;

                        if(administer){
                            Intent intent = new Intent(LoginActivity.this, NavActivity.class);
                            intent.putExtra("staffname",name);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Intent intent = new Intent(LoginActivity.this,StaffNav.class);
                            intent.putExtra("staffname",name);
                            startActivity(intent);
                            finish();
                        }

                    }
                }


               /* List<Staff> staffs = DataSupport.select(name,password).find(Staff.class);

                if(staffs.isEmpty()){
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent(LoginActivity.this, NavActivity.class);
                    startActivity(intent);
                    finish();
                }*/


                /*if (account.equals("admin") && password.equals("123456")){
                    Intent intent = new Intent(LoginActivity.this, NavActivity.class);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(LoginActivity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

        register.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
