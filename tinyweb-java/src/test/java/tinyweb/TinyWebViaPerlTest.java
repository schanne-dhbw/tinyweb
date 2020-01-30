package tinyweb;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TinyWebViaPerlTest 
{
  @Test
  public void testMain() 
  {
    String[] args = new String[] { "/greet&/greet@com.mblinn.oo.tinyweb.example.GreetingController@" +
                                   "com.mblinn.oo.tinyweb.example.GreetingView&" + 
                                   "com.mblinn.oo.tinyweb.example.LoggingFilter&" +
                                   "arg=value&***Marc,Test" };
    TinyWebViaPerl.main(args);
  }
}
