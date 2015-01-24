package com.mblinn.oo.tinyweb

import com.mblinn.oo.tinyweb.Types.Model


class FunctionView(renderer: (Model) => String) extends View {
  def render(model: Model): String = {
    try {
      renderer(model)
    } catch {
      case e: Exception => throw RenderingException(e)
    }
  }
}