package tinyweb.clojure;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

/**
 * Call Clojure Hello world!
 */
public class App
{
  public static void main(String[] args)
  {
    System.out.println("Hello Java world, let's call Clojure ...");

    IFn hello = Clojure.var("tinyweb.hello", "main");
    Object result = hello.invoke("Test");
    System.out.println(result);
  }
}
