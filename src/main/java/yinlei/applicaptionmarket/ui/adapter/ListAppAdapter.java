package yinlei.applicaptionmarket.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import yinlei.applicaptionmarket.R;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: yinlei.applicaptionmarket.ui.adapter.ListAppAdapter.java
 * @author: myName
 * @date: 2016-06-19 18:25
 */

public class ListAppAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Integer> datas;
    private Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;


    public ListAppAdapter(Context context, List<Integer> datas) {
        this.datas = datas;
        this.context = context;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(viewType == TYPE_HEADER){
            View view = LayoutInflater.from(context).inflate(R.layout.item_header, parent, false);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(view);
            return headerViewHolder;
        }else {
            View view = LayoutInflater.from(context).inflate(R.layout.app_item, parent, false);
            AppItemViewHolder viewHolder = new AppItemViewHolder(view);
            return viewHolder;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AppItemViewHolder) {

        } else if (holder instanceof HeaderViewHolder) {

        }

    }

    @Override
    public int getItemCount() {
        return datas.size()+1;
    }


    @Override
    public int getItemViewType(int position) {
        return position ==0 ? TYPE_HEADER : TYPE_ITEM;
    }
}

class AppItemViewHolder extends RecyclerView.ViewHolder {
    public TextView appName;
    public TextView appDownload,appSize;
    public TextView appDes;
    public SimpleDraweeView appIcon;

    public AppItemViewHolder(View itemView) {
        super(itemView);
        appName = (TextView) itemView.findViewById(R.id.app_name);
        appDes = (TextView) itemView.findViewById(R.id.app_dec);
        appDownload = (TextView) itemView.findViewById(R.id.app_download);
        appSize = (TextView) itemView.findViewById(R.id.app_size);
        appIcon = (SimpleDraweeView) itemView.findViewById(R.id.app_icon);
    }
}

class HeaderViewHolder extends RecyclerView.ViewHolder {


    public HeaderViewHolder(View itemView) {
        super(itemView);

    }


}
