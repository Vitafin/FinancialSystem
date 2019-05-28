package com.example.lijuan.myapplication;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lijuan.myapplication.db.Account;

import java.util.Date;

public class AccountApplyStaff extends BaseActivity {

    private String type;
    private String direction;
    private int year;
    private int month;
    private int day;

    private TextView accountDate;
    private String abs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.account_apply_staff);

        Intent intent1 = getIntent();
        final String staffname = intent1.getStringExtra("staffname");

        Spinner accountType = (Spinner) findViewById(R.id.account_type);
        final EditText accountId = (EditText) findViewById(R.id.account_id);
        accountDate = (TextView) findViewById(R.id.account_date);
        final Spinner accountAbstract = (Spinner) findViewById(R.id.account_abstract);
        Spinner accountDirection = (Spinner) findViewById(R.id.account_direction);
        final EditText accountValue = (EditText)findViewById(R.id.account_value);

        ArrayAdapter<CharSequence> abstractAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.account_abstract, R.layout.spinner_checked_text);
        accountAbstract.setAdapter(abstractAdapter);
        accountAbstract.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                abs=accountAbstract.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        String[] typeItems = getResources().getStringArray(R.array.account_type);
        ArrayAdapter<String> typeAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, typeItems);
        typeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        accountType .setAdapter(typeAdapter);
        accountType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                String[] types = getResources().getStringArray(R.array.account_type);
                type = types[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        String[] directionItems = getResources().getStringArray(R.array.account_direction);
        ArrayAdapter<String> directionAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,directionItems);
        directionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        accountDirection.setAdapter(directionAdapter);
        accountDirection.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] directions = getResources().getStringArray(R.array.account_direction);
                direction= directions[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Button submit = (Button) findViewById(R.id.account_apply_submit);

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int id = Integer.parseInt(accountId.getText().toString());
                Date date = new Date(year,month,day);
                int value = Integer.parseInt(accountValue.getText().toString());

                if(accountId.getText().toString().isEmpty()){
                    Toast.makeText(v.getContext(),"流水号不能为空！",Toast.LENGTH_SHORT).show();
                }else if(accountValue.getText().toString().isEmpty()){
                    Toast.makeText(v.getContext(),"金额不能为空！",Toast.LENGTH_SHORT).show();
                }else{
                    Account account = new Account();

                    account.setAccount_id(id);
                    account.setAccount_type(type);
                    account.setDirection(direction);
                    account.setAccount_abstract(abs);
                    account.setAccount_value(value);
                    account.setAccount_date(date);
                    account.setAppliant(staffname);
                    account.setChecked(false);
                    account.setAgreen(false);

                    account.save();

                    Toast.makeText(v.getContext(),"申报成功！",Toast.LENGTH_SHORT).show();
                }



            }
        });

        ImageButton back = (ImageButton) findViewById(R.id.account_apply_back);

        back.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void getDate(View v){
        new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int years, int months, int dayOfMonth) {
                year = years;
                month = months+1;
                day = dayOfMonth;
            }
        },2019,5,1).show();

        accountDate.setText(year+"-"+month+"-"+day);

    }


}
