package com.mblinn.oo.tinyweb

case class RenderingException(exception: Exception) extends RuntimeException(exception);