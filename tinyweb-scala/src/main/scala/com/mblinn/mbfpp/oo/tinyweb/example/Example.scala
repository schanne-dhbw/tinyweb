package com.mblinn.mbfpp.oo.tinyweb.example

import com.mblinn.mbfpp.oo.tinyweb.{FunctionController, FunctionView, HttpRequest, TinyWeb}

import java.util.Random

object Example
{
  def greetingViewRenderer(model: Map[String, List[String]]) =
    "<h1>Friendly Greetings:</h1>%s".format(
      model
      getOrElse("/greetings", List[String]())
      map(renderGreeting)
      mkString(""))

  private def renderGreeting(greeting: String): String =
  {
    return "<h2>%s</h2>".format(greeting)
  }
  
  def greetingView = new FunctionView(greetingViewRenderer)

  def handleGreetingRequest(request: HttpRequest): Map[String, List[String]] =
  {
    return Map("/greetings" -> request.body.split(",").toList.map(makeGreeting))
  }

  private def random = new Random()
  private def greetings = Vector("Hello", "Greetings", "Salutations", "Hola")
  private def makeGreeting(name: String): String =
  {
    return "%s, %s".format(greetings(random.nextInt(greetings.size)), name)
  }
  
  def greetingController = new FunctionController(Example.greetingView, Example.handleGreetingRequest)

  def loggingFilter(request: HttpRequest): HttpRequest = 
  {
    println("In Logging Filter - request for path: %s".format(request.path))
    return request
  }

  def secondFilter(request: HttpRequest): HttpRequest = 
  {
    println("Second Filter")
    return request
  }

  def main(args: Array[String]): Unit = 
  {
    def tinyweb = new TinyWeb(
      Map("/greeting" -> Example.greetingController),
      List(Example.loggingFilter))
    
    def testHttpRequest = HttpRequest(
      Map("name" -> "value"),
      body="Mike,Joe,John,Steve",
      path="/greeting")
    
    val optionalResponse = tinyweb.handleRequest(testHttpRequest)
    
    println(optionalResponse map {_.body} getOrElse "n/a")
  }
}