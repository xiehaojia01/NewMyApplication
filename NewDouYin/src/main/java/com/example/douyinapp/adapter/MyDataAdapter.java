package com.example.douyinapp.adapter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.douyinapp.R;
import com.example.douyinapp.bean.MyDataBean;

import java.util.List;


public class MyDataAdapter extends RecyclerView.Adapter<MyDataAdapter.MyViewHolder> {

    private Context context;
    private List<MyDataBean.CategoryListBean> dataList;

    public MyDataAdapter(Context context, List<MyDataBean.CategoryListBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View inflate = View.inflate(context, R.layout.layout_bigitem, null);
            MyViewHolder myViewHolder = new MyViewHolder(inflate);

            return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        /**
         * 适配数据
         */
        String cha_name = dataList.get(position).getChallenge_info().getCha_name();
        String desc = dataList.get(position).getDesc();
        int user_count = dataList.get(position).getChallenge_info().getUser_count();
        holder.title.setText(cha_name);
        holder.spans.setText(desc);
        holder.user_count.setText(user_count+"");
        /**
         * 传入集合
         * 嵌套适配器
         * 布局下的recyclerView
         */
        List<MyDataBean.CategoryListBean.AwemeListBean> aweme_list = dataList.get(position).getAweme_list();
        //布局管理者
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        //配置适配器
        TransverseRollingAdapter rollingAdapter = new TransverseRollingAdapter(context, aweme_list);
        holder.recyclerView.setAdapter(rollingAdapter);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    /**
     * 装载首页的大item的数据
     */
    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView spans;
        TextView user_count;
        RecyclerView recyclerView;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.title);
            spans = itemView.findViewById(R.id.spans);
            user_count = itemView.findViewById(R.id.user_count);
            recyclerView = itemView.findViewById(R.id.recyclerView);

        }
    }

}
