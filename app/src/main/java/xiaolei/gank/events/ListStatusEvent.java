package xiaolei.gank.events;

/**
 * Created by sunxl8 on 2017/7/21.
 */

public class ListStatusEvent {

    public static final int TOP = 0;
    public static final int SCROLL = 1;

    private int status;

    public ListStatusEvent(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
