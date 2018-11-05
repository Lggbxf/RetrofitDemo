package cn.whale.retrofit.retrofitdemo;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by nuts on 2018/11/5.
 */

public interface ApiService {
    @FormUrlEncoded
    @POST("api.php?req=userReg")
    Observable<BaseResult> getBaseResult(@FieldMap Map<String, String> params);

    @GET("bd_logo1.png?where=super")
    Observable<ResponseBody> downloadPicFromNet();
}
