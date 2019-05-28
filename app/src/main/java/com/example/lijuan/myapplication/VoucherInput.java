package com.example.lijuan.myapplication;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lijuan.myapplication.db.Voucher;

import java.util.Date;

public class VoucherInput extends BaseActivity {

    TextView inputDate = null;
    int year = 2019;
    int month = 5;
    int day = 1;
    String abs;
    String type;
    String name;

    Spinner ledgerSubject;
    Spinner detailSubject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.voucher_input);

        inputDate = (TextView) findViewById(R.id.input_date);
        final EditText appendixNumber = (EditText) findViewById(R.id.appendix_number);
        final EditText totalDebit = (EditText) findViewById(R.id.total_debit);
        final EditText totalCredit = (EditText) findViewById(R.id.total_credit);
        final Spinner vouAbstract = (Spinner) findViewById(R.id.voucher_abstract);
        ledgerSubject = (Spinner) findViewById(R.id.ledger_subject);
        detailSubject = (Spinner) findViewById(R.id.detail_subject);
        final EditText originator = (EditText) findViewById(R.id.originator);

        Button submit = (Button) findViewById(R.id.voucher_input_submit);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.account_abstract, R.layout.spinner_checked_text);
        vouAbstract.setAdapter(adapter);
        vouAbstract.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                abs = vouAbstract.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter<CharSequence> ledgerAdapter = ArrayAdapter.createFromResource(getApplicationContext(),
                R.array.subject_type, R.layout.spinner_checked_text);
        ledgerSubject.setAdapter(ledgerAdapter);
        ledgerSubject.setOnItemSelectedListener(new spinnerItemSelected());

        detailSubject.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                name = detailSubject.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        submit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(appendixNumber.getText().toString());
                int debit = Integer.parseInt(totalDebit.getText().toString());
                int credit = Integer.parseInt(totalCredit.getText().toString());
                String checker = originator.getText().toString();
                Date date =new Date(year,month,day);

                if(totalDebit.getText().toString().isEmpty()){
                    Toast.makeText(v.getContext(),"借方合计不能为空！",Toast.LENGTH_SHORT).show();
                }else if(totalCredit.getText().toString().isEmpty()){
                    Toast.makeText(v.getContext(),"贷方合计不能为空！",Toast.LENGTH_SHORT).show();
                }else if(checker.isEmpty()){
                    Toast.makeText(v.getContext(),"制单人不能为空！",Toast.LENGTH_SHORT).show();
                }else{
                    Voucher voucher = new Voucher();
                    voucher.setAppendix_number(number);
                    voucher.setTotal_debit(debit);
                    voucher.setTotal_credit(credit);
                    voucher.setVou_abstract(abs);
                    voucher.setLedger_subject(type);
                    voucher.setDetail_subject(name);
                    voucher.setOriginator(checker);
                    voucher.setInput_date(date);
                    voucher.save();

                    Toast.makeText(v.getContext(),"录入成功！",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    public void getDate(View v){

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

            @Override public void onDateSet(DatePicker view, int years, int monthOfYear, int dayOfMonth) {
                year = years;
                month = monthOfYear+1;
                day = dayOfMonth;
            }
        }, 2019, 5, 1).show();

        showDate();
    }

    private void showDate(){
        inputDate.setText(year+"-"+month+"-"+day);
    }

    class spinnerItemSelected implements AdapterView.OnItemSelectedListener{

        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Spinner spinner = (Spinner) parent;
            String pro = (String) spinner.getItemAtPosition(position);
            type = ledgerSubject.getSelectedItem().toString();

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
            detailSubject.setAdapter(nameadapter);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    }


}
