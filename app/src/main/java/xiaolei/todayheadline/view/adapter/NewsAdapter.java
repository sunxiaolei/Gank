package xiaolei.todayheadline.view.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import xiaolei.todayheadline.R;
import xiaolei.todayheadline.model.NewsEntity;

/**
 * Created by sunxl8 on 2017/6/26.
 */

public class NewsAdapter extends BaseQuickAdapter<NewsEntity, BaseViewHolder> {

    public NewsAdapter() {
        super(R.layout.item_news);
    }

    @Override
    protected void convert(BaseViewHolder holder, NewsEntity dto) {
        SimpleDraweeView iv = holder.getView(R.id.iv_img);
        iv.setImageURI(dto.getArticle_url());
        holder.setText(R.id.tv_title, dto.getTitle());
    }
}