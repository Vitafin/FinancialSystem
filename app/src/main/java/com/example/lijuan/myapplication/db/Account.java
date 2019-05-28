package com.example.lijuan.myapplication.db;

import org.litepal.crud.DataSupport;

import java.util.Date;

/**
 * Created by Lijuan on 2019/4/28.
 */

public class Account extends DataSupport {

    private int account_id;

    private String account_type;

    private Date account_date;

    private String account_abstract;

    private String direction;

    private int account_value;

    private String appliant;

    private boolean checked;

    private boolean agreen;

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean getChecked(){
        return checked;
    }

    public void setAgreen(boolean agreen) {
        this.agreen = agreen;
    }

    public boolean getAgreen(){
        return agreen;
    }

    public void setAppliant(String appliant) {
        this.appliant = appliant;
    }

    public String getAppliant() {
        return appliant;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public void setAccount_date(Date account_date) {
        this.account_date = account_date;
    }

    public void setAccount_abstract(String account_abstract) {
        this.account_abstract = account_abstract;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void setAccount_value(int account_value) {
        this.account_value = account_value;
    }

    public int getAccount_id() {
        return account_id;
    }

    public String getAccount_type() {
        return account_type;
    }

    public Date getAccount_date() {
        return account_date;
    }

    public String getAccount_abstract() {
        return account_abstract;
    }

    public String getDirection() {
        return direction;
    }

    public int getAccount_value() {
        return account_value;
    }
}
