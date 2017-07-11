package xiaolei.gank.view.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import xiaolei.gank.R;
import xiaolei.gank.model.GankItemEntity;

/**
 * Created by sunxl8 on 2017/7/11.
 */

public class DataAdapter extends BaseQuickAdapter<GankItemEntity, BaseViewHolder> {

    public DataAdapter() {
        super(R.layout.item_data);
    }

    @Override
    protected void convert(BaseViewHolder holder, GankItemEntity entity) {
        holder.setText(R.id.tv_data_title, entity.getDesc());
    }
}
