package com.mblinn.oo.tinyweb

class TinyWeb(controllers: Map[Types.Path, Controller], filters: List[(HttpRequest) => HttpRequest]) {
  def handleRequest(httpRequest: HttpRequest): Option[HttpResponse] = {
    val composedFilter = filters.reverse.reduceLeft {_ compose _}
    val filteredRequest = composedFilter(httpRequest)
    val controllerOption = controllers.get(filteredRequest.path)
    controllerOption map { _.handleRequest(filteredRequest)}
  }
}