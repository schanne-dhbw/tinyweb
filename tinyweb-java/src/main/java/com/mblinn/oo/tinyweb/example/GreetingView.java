package com.mblinn.oo.tinyweb.example;

import com.mblinn.oo.tinyweb.StrategyView;

public class GreetingView extends StrategyView
{
    public GreetingView()
    {
        super(new GreetingRenderingStrategy());
    }
}
