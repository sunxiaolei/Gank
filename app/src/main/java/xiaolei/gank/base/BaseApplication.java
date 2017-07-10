package xiaolei.gank.base;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import org.litepal.LitePal;

import sunxl8.myutils.Utils;

/**
 * Created by sun on 2017/6/22.
 */

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.init(this);

        LitePal.initialize(this);

        Fresco.initialize(this);
    }
}
