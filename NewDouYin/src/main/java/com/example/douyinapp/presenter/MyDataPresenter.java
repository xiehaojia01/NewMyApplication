package com.example.douyinapp.presenter;


import com.example.douyinapp.bean.MyDataBean;
import com.example.douyinapp.model.MyDataModel;
import com.example.douyinapp.myinterface.IMyDataPresenter;
import com.example.douyinapp.myinterface.IMyDataView;

public class MyDataPresenter implements IMyDataPresenter {

    private IMyDataView iMyDataView;
    private final MyDataModel myDataModel;

    public MyDataPresenter(IMyDataView iMyDataView) {
        this.iMyDataView = iMyDataView;
        myDataModel = new MyDataModel();
    }
    public void receiveData(String cursor,String count,String retry_type,String iid,String device_id,String aid){
        myDataModel.receiveData(cursor,count,retry_type,iid,device_id,aid,this);
    }

    @Override
    public void getDataSuccess(MyDataBean myDataBean) {
        iMyDataView.getDataSuccess(myDataBean);
    }

    @Override
    public void getDataFailed() {

    }
}
