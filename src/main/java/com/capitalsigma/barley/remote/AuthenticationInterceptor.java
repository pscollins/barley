package com.capitalsigma.barley.remote;

import retrofit.RequestInterceptor;

import java.util.List;

/**
 * Created by patrick on 7/14/15.
 */
public class AuthenticationInterceptor implements RequestInterceptor {
    private static final String API_KEY_HEADER = "Voat-ApiKey";
    private static final String AUTH_HEADER = "Authorization";
    private static final String AUTH_HEADER_VALUE_BASE = "Bearer ";

//    private String apiKey;

    private List<HeaderElement> headerElements;

    public AuthenticationInterceptor(String apiKey) {
        headerElements.add(new HeaderElement(API_KEY_HEADER, apiKey));
    }

    public void setAuthToken(String authToken) {
        // FIXME: Make sure this isn't set multiple times
        headerElements.add(new HeaderElement(AUTH_HEADER,
                AUTH_HEADER_VALUE_BASE + authToken));
    }

    @Override
    public void intercept(RequestFacade requestFacade) {
        for (HeaderElement e : headerElements) {
            e.register(requestFacade);
        }
    }
}
