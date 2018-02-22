package com.example.douyinapp.myinterface;


import com.example.douyinapp.bean.MyDataBean;

public interface IMyDataPresenter {

    void getDataSuccess(MyDataBean myDataBean);

    void getDataFailed();

}
