package xiaolei.todayheadline.net;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.QueryMap;

/**
 * Created by sun on 2017/6/22.
 */

public interface ToutiaoApi {

    /**
     * 获取新闻
     *
     * @param params
     * @return
     */
    @GET("article/recent/")
    Flowable<String> getNews(@QueryMap(encoded = true) Map<String, String> params);
}
