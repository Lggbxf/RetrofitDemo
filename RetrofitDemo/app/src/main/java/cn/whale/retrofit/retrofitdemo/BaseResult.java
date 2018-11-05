package cn.whale.retrofit.retrofitdemo;

/**
 * Created by nuts on 2018/11/5.
 */

public class BaseResult {
    private int errno;
    private String data;

    public int getErrno() {
        return errno;
    }

    public void setErrno(int errno) {
        this.errno = errno;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
