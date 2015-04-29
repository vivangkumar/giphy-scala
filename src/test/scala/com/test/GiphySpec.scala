package com.test
import com.vivangkumar.Giphy
import org.scalatest._
import Matchers._

class GiphySpec extends FunSpec {

  describe("Giphy") {
    val giphy = new Giphy("dc6zaTOxFJmzC")
    it("should throw an error for an illegal api key when a method is called") {
      val giphy = new Giphy("somekey")

      intercept[Error] {
        giphy.search(Map("q" -> "star wars"))
      }
    }

    describe("#search") {
      it("should return response with type Map[String, Any]") {
        val response = giphy.search(Map("q" -> "star wars"))

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#getGifById") {
      it("should return a response with type Map[String, Any]") {
        val response = giphy.getGifById("feqkVgjJpYtjy")

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#getGifsById") {
      it("should return a response wtih type Map[String, Any]") {
        val response = giphy.getGifsById(List("7rzbxdu0ZEXLy", "feqkVgjJpYtjy"))

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#translate") {
      it("should return a response with type Map[String, Any]") {
        val response = giphy.translate(Map("s" -> "star wars"))

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#random") {
      it("should return a random GIF with type Map[String, Any]") {
        val response = giphy.random(Some(Map("tag" -> "american psycho")))

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#trending") {
      it("should return the latest trending GIF's with type Map[String, Any]") {
        val response = giphy.random(None)

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#searchStickers") {
      it("should return animated stickers of type Map[String, Any]") {
        val response = giphy.searchStickers(Map("q" -> "christian bale"))

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#randomSticker") {
      it("should return a response with type Map[String, Any]") {
        val response = giphy.randomSticker(None)

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#trendingStickers") {
      it("should return a response of type Map[String, Any]") {
        val response = giphy.trendingStickers(Map("s" -> "star wars"))

        response shouldBe a [Map[String, Any]]
      }
    }

    describe("#translateStickers") {
      it("should return a reponse of type Map[String, Any]") {
        val response = giphy.translateStickers(Map("s" -> "star wars"))

        response shouldBe a [Map[String, Any]]
      }
    }
  }
}
