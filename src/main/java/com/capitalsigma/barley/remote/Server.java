package com.capitalsigma.barley.remote;

import android.content.Context;
import com.capitalsigma.barley.R;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;


/**
 * Created by patrick on 7/14/15.
 */
public class Server {
    private final String API_KEY_HEADER = "Voat-ApiKey";
    private final String AUTH_HEADER = "Authorization";
    private final String AUTH_HEADER_VALUE_BASE = "Bearer ";

    private String url;
    private RequestInterceptor authInterceptor;

    

}
