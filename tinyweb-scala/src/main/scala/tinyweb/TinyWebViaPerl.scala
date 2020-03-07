package tinyweb

import com.mblinn.mbfpp.oo.tinyweb.{View, Controller, FunctionController, HttpRequest, HttpResponse, TinyWeb}
import com.mblinn.mbfpp.oo.tinyweb.example.Example
import scala.reflect.runtime.universe

object TinyWebViaPerl 
{
  def main(args: Array[String]): Unit = 
  {
    if (args.length == 0) println("No args ...")
    val argList =
      if (args.length == 1 && args(0).contains("/"))
      {
        args(0).split("/").map(_.trim).toList
      }
      else
      {
        args.toList
      }
    var path = ""
    var body = ""
    var header = Map[String, String]()
    if (argList.size > 1 && !argList(0).isEmpty())
    {
      // path
      path = argList(0)
    }
    for (arg <- argList.drop(1)) 
    {
      // header (name=value)
      if (arg.contains("="))
      {
        header.+((arg.split("=")(0), arg.split("=")(1)))
      }
      // ***body
      else if (arg.startsWith("***"))
      {
        body = arg.substring(3)
      }
    }
    def tinyweb = new TinyWeb(
      Map("greeting" -> new FunctionController(Example.greetingView, Example.handleGreetingRequest)),
      List(Example.loggingFilter)
    )
    def testHttpRequest = HttpRequest(header, body, path)

    val optionalResponse = tinyweb.handleRequest(testHttpRequest)
    
    println(optionalResponse map {_.body} getOrElse "n/a")
  }
}
