package com.mblinn.oo.tinyweb

import com.mblinn.oo.tinyweb.Types.Model

class FunctionController(view: View, doRequest: (HttpRequest) => Model) extends Controller {
  override def handleRequest(request: HttpRequest): HttpResponse = {
    try {
      HttpResponse(view render doRequest(request), 200)
    } catch {
      case e: ControllerException => HttpResponse("", e.status)
      case _: RenderingException => HttpResponse("view error", 500)
      case _: Throwable => HttpResponse("", 500)
    }
  }
}