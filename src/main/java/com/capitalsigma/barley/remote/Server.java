package com.capitalsigma.barley.remote;

import android.content.Context;
import com.capitalsigma.barley.R;
import com.capitalsigma.barley.data.Response;
import com.capitalsigma.barley.data.Submission;
import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

import java.util.List;


/**
 * Created by patrick on 7/14/15.
 */
public class Server {
    private final String FRONT_PAGE_SUBVERSE = "_front";
    private final String ALL_SUBVERSE = "_all";
    private final String DEFAULT_SUBVERSE = "_default";

    private RequestInterceptor authInterceptor;
    private RestAdapter restAdapter;
    private API api;

    public static interface API {
        @GET("/api/v1/{subverse}")
        void getSubmissions(@Path("subverse") String subverse, Callback<Response<List<Submission>>> cb);
    }

    public Server(String publicKey, String remoteUrl) {
        authInterceptor = new AuthenticationInterceptor(publicKey);
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(remoteUrl)
                .setRequestInterceptor(authInterceptor)
                .build();
        api = restAdapter.create(API.class);
    }

    public Server(Context ctx) {
        this(ctx.getString(R.string.public_key), ctx.getString(R.string.remote_url));
    }

    @GET("/api/v1/{subverse}")
    public void getSubmissions(@Path("subverse") String subverse,
                               Callback<Response<List<Submission>>> cb) {
        api.getSubmissions(subverse, cb);
    }

    public void getFrontPageSubverse(Callback<Response<List<Submission>>> cb) {
        getSubmissions(FRONT_PAGE_SUBVERSE, cb);
    }

    public void getDefaultPageSubverse(Callback<Response<List<Submission>>> cb) {
        getSubmissions(DEFAULT_SUBVERSE, cb);
    }
    public void getAllPageSubverse(Callback<Response<List<Submission>>> cb) {
        getSubmissions(ALL_SUBVERSE, cb);
    }


}
