package com.capitalsigma.barley.remote;

import retrofit.RequestInterceptor;

/**
 * Created by patrick on 7/14/15.
 */
public class HeaderElement {
    private final String key;
    private final String value;

    public HeaderElement(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public void register(RequestInterceptor.RequestFacade request) {
        request.addHeader(key, value);
    }
}
