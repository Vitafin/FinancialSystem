package com.example.lijuan.myapplication.db;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by Lijuan on 2019/4/28.
 */

public class Voucher extends DataSupport {

    private int vou_id;

    private Date input_date;

    private int appendix_number;

    private String vou_abstract;

    private String ledger_subject;

    private String detail_subject;

    private String originator;

    private int total_debit;

    private int total_credit;

    public void setVou_id(int vou_id) {
        this.vou_id = vou_id;
    }

    public void setInput_date(Date input_date) {
        this.input_date = input_date;
    }

    public void setAppendix_number(int appendix_number) {
        this.appendix_number = appendix_number;
    }

    public void setVou_abstract(String vou_abstract) {
        this.vou_abstract = vou_abstract;
    }

    public void setLedger_subject(String ledger_subject) {
        this.ledger_subject = ledger_subject;
    }

    public void setDetail_subject(String detail_subject) {
        this.detail_subject = detail_subject;
    }

    public void setTotal_debit(int total_debit) {
        this.total_debit = total_debit;
    }

    public void setTotal_credit(int total_credit) {
        this.total_credit = total_credit;
    }

    public void setOriginator(String originator) {
        this.originator = originator;
    }

    public int getVou_id() {
        return vou_id;
    }

    public Date getInput_date() {
        return input_date;
    }

    public int getAppendix_number() {
        return appendix_number;
    }

    public String getVou_abstract() {
        return vou_abstract;
    }

    public String getLedger_subject() {
        return ledger_subject;
    }

    public String getDetail_subject() {
        return detail_subject;
    }

    public String getOriginator() {
        return originator;
    }

    public int getTotal_credit() {
        return total_credit;
    }

    public int getTotal_debit() {
        return total_debit;
    }
}
