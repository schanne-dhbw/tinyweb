package com.mblinn.mbfpp.oo.tinyweb

case class RenderingException(exception: Exception) extends RuntimeException(exception);
