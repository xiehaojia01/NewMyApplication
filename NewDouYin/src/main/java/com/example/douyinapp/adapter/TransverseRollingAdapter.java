package com.example.douyinapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.example.douyinapp.R;
import com.example.douyinapp.bean.MyDataBean;
import com.example.douyinapp.view.VideoActivity;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;



public class TransverseRollingAdapter extends RecyclerView.Adapter<TransverseRollingAdapter.MyViewHolder> {

    private Context context;
    private List<MyDataBean.CategoryListBean.AwemeListBean> aweme_list;

    public TransverseRollingAdapter(Context context, List<MyDataBean.CategoryListBean.AwemeListBean> aweme_list) {
        this.context = context;
        this.aweme_list = aweme_list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Fresco.initialize(context);
        View inflate = View.inflate(context, R.layout.layout_transverse_rolling, null);
        MyViewHolder myViewHolder = new MyViewHolder(inflate);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Fresco.initialize(context);
        //在getvideo后面加上   .getDynamic_cover().getUrl_list().get(0);  是可以动的图片可能报错
        //在getvideo后面加上       .getCover().getUrl_list().get(0) 是静态图片
        String imgUrl = aweme_list.get(position).getVideo().getCover().getUrl_list().get(0);
        Uri parse = Uri.parse(imgUrl);
        /**
         * 加载图片
         */
        AbstractDraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(parse)
                .setAutoPlayAnimations(true)
                .build();
        holder.myFresco.setController(controller);
        /**
         * 给图片的点击事件
         * 点击跳转
         */
        holder.myFresco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VideoActivity.class);
                intent.putExtra("videoUrl",aweme_list.get(position).getVideo().getDownload_addr().getUrl_list().get(1));
                intent.putExtra("videoName",aweme_list.get(position).getDesc());
                intent.putExtra("videoImg",aweme_list.get(position).getVideo().getCover().getUrl_list().get(1));
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return aweme_list.size();
    }

    /**
     * 装载横向滚动条目的数据
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView myFresco;

        public MyViewHolder(View itemView) {
            super(itemView);
            myFresco = itemView.findViewById(R.id.myFresco);
        }
    }

}
