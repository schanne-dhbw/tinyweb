package tinyweb;

import com.mblinn.oo.tinyweb.Controller;
import com.mblinn.oo.tinyweb.Filter;
import com.mblinn.oo.tinyweb.HttpRequest;
import com.mblinn.oo.tinyweb.HttpResponse;
import com.mblinn.oo.tinyweb.TemplateController;
import com.mblinn.oo.tinyweb.TinyWeb;
import com.mblinn.oo.tinyweb.View;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TinyWebViaPerl
{
  private static View getView(String className)
  {
    try
    {
      if (className != null && !className.isEmpty())
      {
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        if (obj instanceof View) return (View) obj;
      }
    } 
    catch (Exception ex)
    {
    }
    return null;
  }
  
  private static TemplateController getController(String className, View injectedView)
  {
    try
    {
      if (className != null && !className.isEmpty())
      {
        Class clazz = Class.forName(className);
        Constructor constr = clazz.getConstructor(new Class[] { View.class });
        Object obj = constr.newInstance(new Object[] { injectedView });
        if (obj instanceof TemplateController) return (TemplateController) obj;
      }
    } 
    catch (Exception ex)
    {
    }
    return null;
  }
  
  private static Filter getFilter(String className)
  {
    try
    {
      if (className != null && !className.isEmpty())
      {
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        if (obj instanceof Filter) return (Filter) obj;
      }
    } 
    catch (Exception ex)
    {
    }
    return null;
  }
  
  public static void main(String[] args)
  {
    HttpRequest.Builder builder = HttpRequest.Builder.newBuilder();
    if (args.length == 1 && args[0].contains("&"))
    {
      args = args[0].split("&");
    }
    if (args.length > 1 && !args[0].isEmpty())
    {
      builder = builder.path(args[0]);
    }
    Map<String, Controller> controllers = new HashMap<>();
    List<Filter> filters = new ArrayList<>();
    for (int idx = 1; idx < args.length; idx++)
    {
	  // header (name=value)
      if (args[idx].contains("="))
      {
        String[] nameValue = args[idx].split("=");
        if (nameValue.length == 2)
        {
          builder = builder.addHeader(nameValue[0].trim(), nameValue[1].trim());
        }
      }
	  // url@controller@view
      else if (args[idx].contains("@"))
      {
        String[] urlControllerView = args[idx].split("@");
        if (urlControllerView.length == 3)
        {
          View view = getView(urlControllerView[2].trim());
          TemplateController controller = getController(urlControllerView[1].trim(), view);
          controllers.put(urlControllerView[0].trim(), controller);
        }
      }
	  // ***body
      else if (args[idx].startsWith("***"))
      {
        builder.body(args[idx].substring(3));
      }
	  // filter
      else
      {
        String filter = args[idx].trim();
        filters.add(getFilter(filter));
      }
    }
    HttpRequest req = builder.build();
    TinyWeb web = new TinyWeb(controllers, filters);
    HttpResponse res = web.handleRequest(req);
    if (res != null)
    {
      System.out.println(res.getBody());
    }
    else
    {
      System.out.println("Error page!");
    }
  }
}
