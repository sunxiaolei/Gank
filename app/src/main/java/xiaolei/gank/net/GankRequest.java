package xiaolei.gank.net;

import io.reactivex.Flowable;
import xiaolei.gank.model.GankListDto;

/**
 * Created by sunxl8 on 2017/7/11.
 */

public class GankRequest {

    public static Flowable<GankListDto> getData(String category, int count, int page) {
        return NetworkManager.getCommonClient(NetConstant.GANK_BASE_HOST)
                .create(GankApi.class)
                .getData(category, count, page)
                .compose(SchedulersCompat.applyIoSchedulers());
    }
}
