package com.mblinn.oo.tinyweb.stepone

import com.mblinn.oo.tinyweb.RenderingException;

import com.mblinn.oo.tinyweb.Types.Model

trait View {
  def render(model: Model): String
}

class FunctionView(viewRenderer: (Map[String, List[String]]) => String) extends View 
{
  def render(model: Map[String, List[String]]) =
    try
      viewRenderer(model)
    catch {
      case e: Exception => throw new RenderingException(e)
    }
}
