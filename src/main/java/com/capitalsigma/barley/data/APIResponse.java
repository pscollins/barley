package com.capitalsigma.barley.data;

/**
 * Created by patrick on 7/14/15.
 */
public class APIResponse<T> {
    private T response;
    private boolean success;
    private ErrorInfo errorInfo;

    public APIResponse() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        APIResponse<?> that = (APIResponse<?>) o;

        if (success != that.success) return false;
        if (response != null ? !response.equals(that.response) : that.response != null) return false;
        return !(errorInfo != null ? !errorInfo.equals(that.errorInfo) : that.errorInfo != null);

    }

    @Override
    public int hashCode() {
        int result = response != null ? response.hashCode() : 0;
        result = 31 * result + (success ? 1 : 0);
        result = 31 * result + (errorInfo != null ? errorInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "APIResponse{" +
                "response=" + response +
                ", success=" + success +
                ", errorInfo=" + errorInfo +
                '}';
    }
}
