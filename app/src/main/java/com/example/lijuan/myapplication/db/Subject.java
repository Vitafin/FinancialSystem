package com.example.lijuan.myapplication.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Lijuan on 2019/4/28.
 */

public class Subject extends DataSupport {

    private int sub_id;

    private String sub_title;

    private String balance_direction;

    private String sub_type;

    private boolean sub_status;

    public Subject(int sub_id, String sub_title, String balance_direction, String sub_type, boolean sub_status){
        this.sub_id = sub_id;
        this.sub_title = sub_title;
        this.balance_direction = balance_direction;
        this.sub_type = sub_type;
        this.sub_status = sub_status;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public void setBalance_direction(String balance_direction) {
        this.balance_direction = balance_direction;
    }

    public void setSub_type(String sub_type) {
        this.sub_type = sub_type;
    }

    public void setSub_status(boolean sub_status) {
        this.sub_status = sub_status;
    }

    public int getSub_id() {
        return sub_id;
    }

    public String getSub_title() {
        return sub_title;
    }

    public String getBalance_direction() {
        return balance_direction;
    }

    public String getSub_type() {
        return sub_type;
    }

    public boolean getSub_status(){
        return sub_status;
    }
}
