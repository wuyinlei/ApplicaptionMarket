package yinlei.applicaptionmarket.ui.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yinlei.applicaptionmarket.R;
import yinlei.applicaptionmarket.ui.activity.DetailActivity;
import yinlei.applicaptionmarket.utils.SettingPrefUtils;
import yinlei.applicaptionmarket.utils.StringUtils;
import yinlei.applicaptionmarket.utils.UIUtils;

/**
 * 在此写用途
 *
 * @version V1.0 <描述当前版本功能>
 * @FileName: ListAppAdapter.java
 * @author: 若兰明月
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

        if (viewType == TYPE_HEADER) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_header, parent, false);
            HeaderViewHolder headerViewHolder = new HeaderViewHolder(view);
            return headerViewHolder;
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.app_item, parent, false);
            AppItemViewHolder viewHolder = new AppItemViewHolder(view, context);
            return viewHolder;
        }


    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof AppItemViewHolder) {
            ((AppItemViewHolder) holder).appName.setTextSize(TypedValue.COMPLEX_UNIT_PX,
                    SettingPrefUtils.getTitleSize(UIUtils.getContext()));
            ((AppItemViewHolder) holder).appSize.setTextSize(TypedValue.COMPLEX_UNIT_PX
            ,SettingPrefUtils.getTextSize(UIUtils.getContext()));
            ((AppItemViewHolder) holder).appDes.setTextSize(TypedValue.COMPLEX_UNIT_PX
                    ,SettingPrefUtils.getTitleSize(UIUtils.getContext()));
            ((AppItemViewHolder) holder).appDownload.setTextSize(TypedValue.COMPLEX_UNIT_PX
                    ,SettingPrefUtils.getTextSize(UIUtils.getContext()));
        } else if (holder instanceof HeaderViewHolder) {

        }

    }

    @Override
    public int getItemCount() {
        return datas.size() + 1;
    }


    @Override
    public int getItemViewType(int position) {
        return position == 0 ? TYPE_HEADER : TYPE_ITEM;
    }
}

class AppItemViewHolder extends RecyclerView.ViewHolder {
    public TextView appName;
    public TextView appDownload, appSize;
    public TextView appDes;
    public SimpleDraweeView appIcon;
    private Context mContext;


    @Bind(R.id.re_layout)
    RelativeLayout reLayout;

    @OnClick(R.id.re_layout)
    void reItemClick() {
        DetailActivity.startActivity(mContext, "webview_load_progress_drawable", "webview_load_progress_drawable", "webview_load_progress_drawable", 3);
    }

    public AppItemViewHolder(View itemView, Context context) {
        super(itemView);
        this.mContext = context;
        ButterKnife.bind(this, itemView);
        appName = (TextView) itemView.findViewById(R.id.app_name);
        appDes = (TextView) itemView.findViewById(R.id.app_dec);
        appDownload = (TextView) itemView.findViewById(R.id.app_download);
        appSize = (TextView) itemView.findViewById(R.id.app_size);
        appIcon = (SimpleDraweeView) itemView.findViewById(R.id.app_icon);
        reLayout = (RelativeLayout) itemView.findViewById(R.id.re_layout);
    }


}

class HeaderViewHolder extends RecyclerView.ViewHolder {


    public HeaderViewHolder(View itemView) {
        super(itemView);

    }


}
