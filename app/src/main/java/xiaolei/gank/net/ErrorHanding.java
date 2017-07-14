package xiaolei.gank.net;

import com.google.gson.JsonParseException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;

/**
 * Created by sunxl8 on 2017/7/14.
 */

public class ErrorHanding {

    public static String handleError(Throwable throwable) {
        throwable.printStackTrace();
        String message;
        if (throwable instanceof HttpException) {
            HttpException httpException = (HttpException) throwable;
            message = "网络错误(" + httpException.code() + ")";
        } else if (throwable instanceof JSONException
                || throwable instanceof JsonParseException) {
            message = "解析失败";
        } else if (throwable instanceof SocketTimeoutException) {
            message = "网络连接超时";
        } else if (throwable instanceof UnknownHostException
                || throwable instanceof ConnectException) {
            message = "网络连接失败，请检查网络!";
        } else {
            message = "其他：" + throwable.getMessage();
        }
        return message;
    }
}
