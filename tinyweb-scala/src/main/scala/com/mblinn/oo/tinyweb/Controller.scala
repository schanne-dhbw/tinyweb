package com.mblinn.oo.tinyweb

trait Controller {
  def handleRequest(request: HttpRequest): HttpResponse
}