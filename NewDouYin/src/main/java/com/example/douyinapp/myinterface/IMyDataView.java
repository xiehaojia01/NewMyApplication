package com.example.douyinapp.myinterface;


import com.example.douyinapp.bean.MyDataBean;

public interface IMyDataView {

    void getDataSuccess(MyDataBean myDataBean);

    void getDataFailed();

}
