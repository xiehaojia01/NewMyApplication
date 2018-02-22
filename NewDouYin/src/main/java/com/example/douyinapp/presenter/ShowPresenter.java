package com.example.douyinapp.presenter;


import com.example.douyinapp.bean.ShowBean;
import com.example.douyinapp.model.ShowModel;
import com.example.douyinapp.myinterface.IShowPresenter;
import com.example.douyinapp.myinterface.IShowView;

import java.util.List;

public class ShowPresenter implements IShowPresenter {

    private ShowModel showModel;
    private IShowView iShowView;

    public ShowPresenter(IShowView iShowView) {
        showModel = new ShowModel();
        this.iShowView = iShowView;
    }

    public void receive(String retry_type, String iid, String device_id, String aid){
        showModel.receive(retry_type,iid,device_id,aid,this);
    }

    @Override
    public void onShowSuccess(List<ShowBean.BannerBean> banner) {
        iShowView.onShowSuccess(banner);
    }

    @Override
    public void onShowFailed() {

    }


}
