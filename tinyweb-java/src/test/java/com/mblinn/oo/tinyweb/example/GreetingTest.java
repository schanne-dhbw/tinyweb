package com.mblinn.oo.tinyweb.example;

import com.mblinn.oo.tinyweb.Controller;
import com.mblinn.oo.tinyweb.Filter;
import com.mblinn.oo.tinyweb.HttpRequest;
import com.mblinn.oo.tinyweb.HttpResponse;
import com.mblinn.oo.tinyweb.StrategyView;
import com.mblinn.oo.tinyweb.TinyWeb;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class GreetingTest {

    @Test
    public void put_it_all_together() throws Exception {
        final HashMap<String, Controller> controllers = new HashMap<>();
        controllers.put("/greet", new GreetingController(new StrategyView(new GreetingRenderingStrategy())));

        final HttpRequest request = HttpRequest.Builder.newBuilder()
                .path("/greet")
                .body("Alan,Paul")
                .build();
        List<Filter> filters = Arrays.<Filter>asList(new LoggingFilter());

        final HttpResponse httpResponse = new TinyWeb(controllers, filters).handleRequest(request);

        assertThat(httpResponse.getResponseCode(), CoreMatchers.equalTo(200));
        assertThat(httpResponse.getBody(), allOf(containsString("Alan"), containsString("Paul")));

    }
}