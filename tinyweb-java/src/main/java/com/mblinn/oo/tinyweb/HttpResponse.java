package com.mblinn.oo.tinyweb;

public class HttpResponse {
    private final String body;
    private final Integer responseCode;

    public HttpResponse(Builder builder) {
        this.body = builder.body;
        this.responseCode = builder.responseCode;
    }

    public String getBody() {
        return body;
    }

    public Integer getResponseCode() {
        return responseCode;
    }

    public static class Builder {
        private String body;
        private Integer responseCode;

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder responseCode(Integer responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public HttpResponse build() {
            return new HttpResponse(this);
        }

        public static Builder newBuilder() {
            return new Builder();
        }
    }
}
