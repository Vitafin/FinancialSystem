package com.example.lijuan.myapplication.db;

import org.litepal.crud.DataSupport;

/**
 * Created by Lijuan on 2019/3/29.
 */

public class Staff extends DataSupport{
    private int id;

    private String name;

    private String password;

    private boolean adminstrator;

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getPassword(){
        return password;
    }

    public boolean getAdminstrator() {
        return adminstrator;
    }

    public void setId(int id){
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdminstrator(boolean adminstrator) {
        this.adminstrator = adminstrator;
    }
}
