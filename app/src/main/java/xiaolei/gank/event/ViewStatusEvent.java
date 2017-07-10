package xiaolei.gank.event;

/**
 * Created by sunxl8 on 2017/6/27.
 */

public class ViewStatusEvent {

    public static final int STATUS_NORMAL = 0;
    public static final int STATUS_LOADING = 1;
    public static final int STATUS_EMPTY = 2;
    public static final int STATUS_ERROR = 3;

    private int status;

    private String msg;

    public ViewStatusEvent(int status) {
        this.status = status;
    }

    public ViewStatusEvent(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
