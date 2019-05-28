package com.example.lijuan.myapplication;

import android.os.AsyncTask;

/**
 * Created by Lijuan on 2019/4/2.
 */

public class UserLoginTask /*extends AsyncTask<Void, Void, Boolean>*/ {
    /*private static final String[] DUMMY_CREDENTIALS = ;

    @Override
    protected Boolean doInBackground(Void... params) {
        try {
            //模拟用户验证耗时
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {//遍历数组验证自定义用户及密码
            String[] pieces = credential.split(":");//分割字符串，将密码个邮箱分离开
            if (pieces[0].equals(mEmail)) {
                return pieces[1].equals(mPassword);
            }
        }
        return true;
    }
    @Override
    protected void onPostExecute(final Boolean success) {//线程结束后的ui处理
        mAuthTask = null;
        showProgress(false);//隐藏验证延时对话框

        if (success) {
            finish();
        } else {//密码错误，输入框获得焦点，并提示错误
            mPasswordView.setError(getString(R.string.error_incorrect_password));
            mPasswordView.requestFocus();
        }
    }
    //取消验证
    @Override
    protected void onCancelled() {
        mAuthTask = null;
        showProgress(false);
    }*/
}
