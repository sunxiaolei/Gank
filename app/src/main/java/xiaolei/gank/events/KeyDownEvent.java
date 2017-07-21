package xiaolei.gank.events;

/**
 * Created by sunxl8 on 2017/7/21.
 */

public class KeyDownEvent {

    public static final int KEYCODE_BACK = 4;

    private int keycode;

    public KeyDownEvent(int keycode) {
        this.keycode = keycode;
    }

    public int getKeycode() {
        return keycode;
    }

    public void setKeycode(int keycode) {
        this.keycode = keycode;
    }
}
