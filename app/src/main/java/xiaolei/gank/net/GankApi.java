package xiaolei.gank.net;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import xiaolei.gank.model.GankListDto;

/**
 * Created by sunxl8 on 2017/7/11.
 */

public interface GankApi {

    /**
     * 分类数据: http://gank.io/api/data/数据类型/请求个数/第几页
     * 数据类型： 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * 请求个数： 数字，大于0
     * 第几页：数字，大于0
     */
    @GET("data/{category}/{count}/{page}")
    Flowable<GankListDto> getData(@Path("category") String category, @Path("count") int count, @Path("page") int page);

    /**
     * 搜索：http://gank.io/api/search/query/listview/category/Android/count/10/page/1
     * category 后面可接受参数 all | Android | iOS | 休息视频 | 福利 | 拓展资源 | 前端 | 瞎推荐 | App
     * count 最大 50
     */

}
