package com.example.douyinapp.model;


import com.example.douyinapp.bean.MyDataBean;
import com.example.douyinapp.myinterface.IMyDataPresenter;
import com.example.douyinapp.utils.IRetrofitServices;
import com.example.douyinapp.utils.RetrofitUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MyDataModel {
    public void receiveData(String cursor, String count, String retry_type, String iid, String device_id, String aid, final IMyDataPresenter iMyDataPresenter){
        IRetrofitServices services = RetrofitUtil.getInstance("http://api.amemv.com/aweme/v1/").create(IRetrofitServices.class);
        services.getMyData(cursor,count,retry_type,iid,device_id,aid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyDataBean>() {
                    @Override
                    public void accept(MyDataBean myDataBean) throws Exception {
                        if(myDataBean!=null){
                            iMyDataPresenter.getDataSuccess(myDataBean);
                        }else{

                        }
                    }
                });
    }

}
