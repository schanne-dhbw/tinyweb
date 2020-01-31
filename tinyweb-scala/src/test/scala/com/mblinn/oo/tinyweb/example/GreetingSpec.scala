
package com.mblinn.oo.tinyweb.example

import com.mblinn.oo.tinyweb.{HttpRequest, HttpResponse}
import org.scalacheck.Prop.BooleanOperators
import org.scalatest.matchers.should.Matchers

class GreetingSpec extends PropSpec with GeneratorDrivenPropertyChecks with Matchers {


  property("a greeting response should contains the names given in the input") {

    def outputContainsInputNames(names: List[String], headers: Map[String, String]): Boolean = {
      val request = HttpRequest(names.mkString(","), "/greeting", headers)
      val response: Option[HttpResponse] = Greeting.tinyweb.handleRequest(request)
      response match {
        case Some(HttpResponse(body, 200)) => names.forall {
          body contains _
        }
        case _ => false
      }
    }

    forAll { (names: List[String], headers: Map[String, String]) =>
      whenever(!names.exists(_.contains(","))) {
        outputContainsInputNames(names, headers) should be(right = true)
      }
    }

  }


}
