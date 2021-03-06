package com.test

import com.vivangkumar.{ValidationException, RequestException, GiphyException, Giphy}
import org.scalatest._
import Matchers._

class GiphySpec extends FunSpec with EitherValues {

  describe("Giphy") {
    val giphy = new Giphy("dc6zaTOxFJmzC")
    it("should return a RequestException for an illegal api key when a method is called") {
      val giphy = new Giphy("somekey")
      val search = giphy.search(Map("q" -> "star wars"))

      search.left.value shouldBe a [RequestException]
    }

    describe("#search") {
      it("should return response with type Map[String, Any]") {
        val response = giphy.search(Map("q" -> "star wars"))

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return aValidationException if there was a validation failure") {
        val response = giphy.search(Map("limit" -> "25"))

        response.left.value shouldBe a [ValidationException]
      }
    }

    describe("#getGifById") {
      it("should return a response with type Map[String, Any]") {
        val response = giphy.getGifById("feqkVgjJpYtjy")

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return a ValidationException if the ID is empty") {
        val response = giphy.getGifById("")

        response.left.value shouldBe a [ValidationException]
      }
    }

    describe("#getGifsById") {
      it("should return a response wtih type Map[String, Any]") {
        val response = giphy.getGifsById(List("7rzbxdu0ZEXLy", "feqkVgjJpYtjy"))

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return a ValidationException on passing an empty list") {
        val response = giphy.getGifsById(List())

        response.left.value shouldBe a [ValidationException]
      }
    }

    describe("#translate") {
      it("should return a response with type Map[String, Any]") {
        val response = giphy.translate(Map("s" -> "star wars"))

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return a ValidationException when a required param is missing") {
        val response = giphy.translate(Map("limit" -> "25"))

        response.left.value shouldBe a [ValidationException]
      }
    }

    describe("#random") {
      it("should return a random GIF with type Map[String, Any]") {
        val response = giphy.random(Some(Map("tag" -> "american psycho")))

        response.right.value shouldBe a [Map[_, _]]
      }
    }

    describe("#trending") {
      it("should return the latest trending GIF's with type Map[String, Any]") {
        val response = giphy.random(None)

        response.right.value shouldBe a [Map[_, _]]
      }
    }

    describe("#searchStickers") {
      it("should return animated stickers of type Map[String, Any]") {
        val response = giphy.searchStickers(Map("q" -> "christian bale"))

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return a ValidationException if there was a validation failure") {
        val response = giphy.searchStickers(Map("limit" -> "25"))

        response.left.value shouldBe a [ValidationException]
      }
    }

    describe("#randomSticker") {
      it("should return a response with type Map[String, Any]") {
        val response = giphy.randomSticker(None)

        response.right.value shouldBe a [Map[_, _]]
      }
    }

    describe("#trendingStickers") {
      it("should return a response of type Map[String, Any]") {
        val response = giphy.trendingStickers(Map("s" -> "star wars"))

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return a ValidationException when a required param is missing") {
        val response = giphy.trendingStickers(Map("limit" -> "25"))

        response.left.value shouldBe a [ValidationException]
      }
    }

    describe("#translateStickers") {
      it("should return a reponse of type Map[String, Any]") {
        val response = giphy.translateStickers(Map("s" -> "star wars"))

        response.right.value shouldBe a [Map[_, _]]
      }

      it("should return a ValidationException when a required param is missing") {
        val response = giphy.translateStickers(Map("limit" -> "25"))

        response.left.value shouldBe a [ValidationException]
      }
    }
  }
}
