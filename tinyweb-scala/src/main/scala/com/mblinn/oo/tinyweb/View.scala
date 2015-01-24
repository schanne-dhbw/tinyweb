package com.mblinn.oo.tinyweb

import com.mblinn.oo.tinyweb.Types.Model

trait View {
  def render(model: Model): String
}