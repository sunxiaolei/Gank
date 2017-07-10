package xiaolei.gank.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by sunxl8 on 2017/6/27.
 * 标题
 */

public class TitleEntity extends BaseObservable {

    private String title;

    public TitleEntity(String title) {
        this.title = title;
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
