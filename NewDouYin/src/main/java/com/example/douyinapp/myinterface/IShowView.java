package com.example.douyinapp.myinterface;


import com.example.douyinapp.bean.ShowBean;

import java.util.List;

public interface IShowView {

    void onShowSuccess(List<ShowBean.BannerBean> banner);

    void onShowFailed();

}
