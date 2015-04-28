package com.vivangkumar

import scalaj.http._
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * This class contains general API request methods
 * @param apiKey Giphy API key
 */

class Request(apiKey: String) {
  val apiHost = "http://api.giphy.com"
  val apiVersion = "v1"

  implicit val formats = org.json4s.DefaultFormats
  /**
   * Constructs the root API endpoint and returns it
   * @param resource The type of resource
   *                 Could be one of 'gifs' or 'stickers'
   * @param method The giphy endpoint method requested
   * @return String
   */
  private def buildApiEndpoint(resource: String, method: String): String = {
    val endpoint = apiHost + "/" + apiVersion + "/" + resource

    if (method.nonEmpty) {
      return endpoint + "/" + method
    }

    endpoint
  }

  /**
   * Handle HTTP responses
   * @param response The HTTP response object
   * @return Any (Maybe an exception or a String)
   */
  private def handleResponse(response: HttpResponse[String]): Any = {
    if (response.isError) {
      throw new Error("Error when sending request to Giphy - " + response.statusLine)
    } else if (response.isSuccess) {
      val json = parse(response.body)
      return json.extract[Map[String, Any]]
    }
  }

  /**
   *
   * @param verb The HTTP verb
   * @param params Parameters to be sent as query params
   *               This an Option - Map[String, String] or None
   * @return HTTPResponse[String]
   */
  def makeNew(verb: String, params: Option[Map[String, String]], resource: String, method: String): Any = {
    val endpoint = buildApiEndpoint(resource, method)
    var queryParams = Map("api_key" -> apiKey)

    if (params.isDefined) {
      queryParams = params.get + ("api_key" -> apiKey)
    }

    handleResponse(Http(endpoint).params(queryParams).asString)
  }
}

/**
 * Companion object for the Request class
 */
object ApiRequest {
  def apply(apiKey: String) = {
    new Request(apiKey)
  }
}
