package com.mblinn.mbfpp.oo.tinyweb

class TinyWeb(controllers: Map[String, Controller],
  filters: List[(HttpRequest) => HttpRequest]) 
{
  def handleRequest(httpRequest: HttpRequest): HttpResponse = 
  {
    val composedFilter = filters.reverse.reduceLeft(
      (composed, next) => composed compose next)
    val filteredRequest = composedFilter(httpRequest)
    val controllerOption = controllers.get(filteredRequest.path)
    val controller = controllerOption.getOrElse(new NotFoundController())
    return controller.handleRequest(filteredRequest)
  }
}
