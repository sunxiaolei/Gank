package xiaolei.gank.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import xiaolei.gank.BR;

/**
 * Created by sunxl8 on 2017/6/21.
 */

public class TestEntity extends BaseObservable{

    private String strTest;

    private boolean isVisible;

    private int intTest;

    @Bindable
    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
        notifyPropertyChanged(BR.visible);
    }

    @Bindable
    public String getStrTest() {
        return strTest;
    }

    public void setStrTest(String strTest) {
        this.strTest = strTest;
        notifyPropertyChanged(BR.strTest);
    }

    @Bindable
    public int getIntTest() {
        return intTest;
    }

    public void setIntTest(int intTest) {
        this.intTest = intTest;
        notifyPropertyChanged(BR.intTest);
    }
}
