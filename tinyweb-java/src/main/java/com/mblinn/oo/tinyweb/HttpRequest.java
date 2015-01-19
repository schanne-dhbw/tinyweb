package com.mblinn.oo.tinyweb;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HttpRequest {
    private final String path;
    private final String body;
    private final Map<String, String> headers;

    public HttpRequest(Builder builder) {
        this.path = builder.path;
        this.body = builder.body;
        this.headers = builder.headers;
    }

    public String getPath() {
        return path;
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return Collections.unmodifiableMap(headers);
    }

    public static class Builder {
        private Map<String, String> headers;
        private String path;
        private String body;

        public Builder() {
            this.headers = new HashMap<>();
        }

        public Builder path(String path) {
            this.path = path;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public HttpRequest build() {
            return new HttpRequest(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder addHeader(String headerName, String headerValue) {
            headers.put(headerName, headerValue);
            return this;
        }
    }

    public static Builder builderFrom(HttpRequest request) {
        Builder builder = new Builder();
        builder.path(request.getPath());
        builder.body(request.getBody());
        Map<String, String> headers = request.getHeaders();
        for (String headerName : headers.keySet())
            builder.addHeader(headerName, headers.get(headerName));
        return builder;
    }
}


