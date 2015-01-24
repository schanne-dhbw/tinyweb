package com.mblinn.oo.tinyweb

case class HttpRequest(body: String, path: Types.Path, headers: Map[String, String])