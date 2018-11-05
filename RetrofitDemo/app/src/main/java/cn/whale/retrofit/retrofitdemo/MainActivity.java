package cn.whale.retrofit.retrofitdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String base_url = "http://video.enjoynut.cn/";
    private static final String img_url = "https://www.baidu.com/img/";
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.iv)
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        getBaseResult();
    }

    public void getBaseResult() {
        Map<String, String> map = new HashMap<>();
        map.put("uuid", "a4e0293f-1f09-45cb-9b58-37861c345bz9");
        map.put("username", "qweasd3");
        map.put("passwd", "343b1c4a3ea721b2d640fc8700db0f36");
        map.put("pkgname", "com.asd");
        map.put("vcode", "112");
        Retrofit retrofit = new Retrofit.Builder().baseUrl(img_url).addCallAdapterFactory(RxJavaCallAdapterFactory.create()).addConverterFactory(FastJsonConverterFactory.create()).build();
        ApiService api = retrofit.create(ApiService.class);
        /*api.getBaseResult(map)
                .subscribeOn(Schedulers.io())//IO线程加载数据
                .observeOn(AndroidSchedulers.mainThread())//主线程显示数据
                .subscribe(new Subscriber<BaseResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("MainActivity", "凉凉" + e.toString());

                    }

                    @Override
                    public void onNext(BaseResult baseResult) {
                        Log.i("MainActivity", baseResult.getErrno() + " " + baseResult.getData());

                    }
                });*/
        api.downloadPicFromNet()
        .subscribeOn(Schedulers.newThread())
                .map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody responseBody) {
                        return BitmapFactory.decodeStream(responseBody.byteStream());
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Bitmap>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Bitmap bitmap) {
                        iv.setImageBitmap(bitmap);
                    }
                });
       /* Call<BaseResult> call = api.getBaseResult(map);
        call.enqueue(new Callback<BaseResult>() {
            @Override
            public void onResponse(Call<BaseResult> call, Response<BaseResult> response) {
                Toast.makeText(getApplicationContext(),response.body().getErrno()+"  "+response.body().getData(),Toast.LENGTH_SHORT).show();
                Log.i("MainActivity",response.body().getErrno()+"  "+response.body().getData());
            }

            @Override
            public void onFailure(Call<BaseResult> call, Throwable t) {
                Log.i("MainActivity","凉凉"+t.toString());
            }
        });*/
    }
}
