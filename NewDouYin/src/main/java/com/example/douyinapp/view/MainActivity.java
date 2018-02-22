package com.example.douyinapp.view;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.douyinapp.R;
import com.example.douyinapp.adapter.MyDataAdapter;
import com.example.douyinapp.bean.MyDataBean;
import com.example.douyinapp.bean.ShowBean;
import com.example.douyinapp.myinterface.IMyDataView;
import com.example.douyinapp.myinterface.IShowView;
import com.example.douyinapp.presenter.MyDataPresenter;
import com.example.douyinapp.presenter.ShowPresenter;
import com.example.douyinapp.utils.ChenJinShi;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IShowView, IMyDataView, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.showXBanner)
    XBanner showXBanner;
    @BindView(R.id.showXRecyclerView)
    XRecyclerView showXRecyclerView;
    @BindView(R.id.swipeRefresh)
    SwipeRefreshLayout swipeRefresh;
    @BindView(R.id.re)
    RelativeLayout re;


    private ShowPresenter showPresenter;
    private ArrayList<String> imgList = new ArrayList<>();
    private ArrayList<String> titleList = new ArrayList<>();
    private MyDataPresenter myDataPresenter;
    private int cursor = 0;
    private int count = 5;
    private MyDataAdapter myDataAdapter;
    private List<MyDataBean.CategoryListBean> dataList = new ArrayList<>();
    private boolean flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ChenJinShi.getInstance().Immersive(getWindow(),getActionBar());
        //隐藏标题栏
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();

        ButterKnife.bind(this);
        initData();
        swipeRefresh.setOnRefreshListener(this);//设置swiper的可刷新
        showXRecyclerView.setPullRefreshEnabled(false);
        //设置xRecyclerView可加载更多
        showXRecyclerView.setLoadingMoreEnabled(true);
        /**
         * 设置上拉加载的样式
         */
       /* showXRecyclerView.setLoa
        加载更多*/
        showXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                showXRecyclerView.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                count = count + 5;
                myDataPresenter.receiveData(cursor + "", count + "", "no_retry", "23028350734", "42386607829", "1128");
                myDataAdapter.notifyDataSetChanged();
                showXRecyclerView.loadMoreComplete();
            }
        });
    }

    private void initData() {
        myDataPresenter = new MyDataPresenter(this);
        showPresenter = new ShowPresenter(this);
        showPresenter.receive("no_retry", "23028350734", "42386607829", "1128");
        myDataPresenter.receiveData(cursor + "", count + "", "no_retry", "23028350734", "42386607829", "1128");
    }

    @Override
    public void onShowSuccess(List<ShowBean.BannerBean> banner) {
        titleList.clear();
        imgList.clear();
        /**
         * 请求成功返回的数据
         * 将图片地址和文字信息放入新集合
         */
        for (int i = 0; i < banner.size(); i++) {
            String title = banner.get(i).getTitle();
            titleList.add(title);
            String imgUrl = banner.get(i).getBanner_url().getUrl_list().get(0);
            imgList.add(imgUrl);
        }
      /*  为XBanner绑定数据
      showXBanner.removeView(re);*/
        if (!flag) {

            showXBanner.setData(imgList, titleList);
            //XBanner适配器适配数据
            showXBanner.setmAdapter(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, View view, int position) {
                    //Glide加载图片
                    Glide.with(MainActivity.this).load(imgList.get(position)).into((ImageView) view);
                }
            });
            flag = true;
        }else{

        }

    }

    @Override
    public void onShowFailed() {

    }

    @Override
    public void getDataSuccess(MyDataBean myDataBean) {
        /**
         * 添加到新集合
         */
        List<MyDataBean.CategoryListBean> category_list = myDataBean.getCategory_list();
        for (int i = 0; i < category_list.size(); i++) {
            dataList.add(category_list.get(i));
        }
        /**
         * 轮播图下的数据请求成功
         */
        showXRecyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        myDataAdapter = new MyDataAdapter(MainActivity.this, dataList);
        showXRecyclerView.setAdapter(myDataAdapter);
    }

    @Override
    public void getDataFailed() {

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                cursor++;
                swipeRefresh.setRefreshing(false);
                dataList.clear();
                myDataPresenter.receiveData(cursor + "", count + "", "no_retry", "23028350734", "42386607829", "1128");
                myDataAdapter.notifyDataSetChanged();
            }
        }, 2000);
    }
}
