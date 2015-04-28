package com.test
import com.vivangkumar.Giphy
import org.scalatest._
import Matchers._

class GiphySpec extends FunSpec {

  describe("Giphy") {
    describe("#search") {
      it("should return GIF's matching the search term") {
        val giphy = new Giphy("dc6zaTOxFJmzC")
        val response = giphy.search(Map("q" -> "star wars"))

        response shouldBe a [Map[String, Any]]
      }
    }
  }
}
