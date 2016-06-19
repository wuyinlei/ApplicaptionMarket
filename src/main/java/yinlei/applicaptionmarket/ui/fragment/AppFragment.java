package yinlei.applicaptionmarket.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.adapter.ListAppAdapter;
import yinlei.applicaptionmarket.ui.base.BaseFragment;

/**
 * 应用fragment
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: AppFragment.java
 * @author: 若兰明月
 * @date: 2016-06-19 16:03
 */

public class AppFragment extends BaseFragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_app, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        List<Integer> datas = new ArrayList<>();
        for (int i   = 0; i < 100; i++) {
            datas.add(i);
        }
        recyclerView.setAdapter(new ListAppAdapter(getActivity(),datas));
        return view;
    }


    /*private class MyRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private List<Integer> datas;
        private Context context;

        public MyRecycleAdapter(Context context, List<Integer> datas) {
            this.datas =datas;
            this.context = context;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.item,parent,false);
            MyViewHolder holder = new MyViewHolder(view);
            return holder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof MyViewHolder){
                MyViewHolder myViewHolder = (MyViewHolder) holder;
                myViewHolder.mTextView.setText(datas.get(position) + "");
            }
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder{

            private TextView mTextView;
            public MyViewHolder(View itemView) {
                super(itemView);
                mTextView = (TextView) itemView.findViewById(R.id.text);
            }
        }*/

}
