import scalaj.http._
import concurrent.Future

/**
 * This class contains general API request methods
 * @param apiKey Giphy API key
 */

class Request(apiKey: String) {
  val apiHost = "http://api.giphy.com"
  val apiVersion = "v1"

  /**
   * Constructs the root API endpoint and returns it
   * @param resource The type of resource
   *                 Could be one of 'gifs', 'stickers', 'sticker'
   * @return String
   */
  private def buildRootApiEndpoint(resource: String): String = {
    apiHost + "/" + apiVersion + "/" + resource
  }

  /**
   *
   * @param request The HTTP request object
   * @param params Params to be added
   * @return HTTPRequest
   */
  private def addQueryParams(request: HttpRequest, params: Map[String, String]): HttpRequest = {
    for((k, v) <- params) {
      request.param(k, v)
    }

    request
  }

  /**
   *
   * @param verb The HTTP verb
   * @param params Parameters to be sent as query params
   * @return Future[HttpRequest]
   */
  def makeNew(verb: String, params: Map[String, String], resource: String):Future[HttpRequest] = {
    val endpoint = buildRootApiEndpoint(resource)
    val request = Http(endpoint).param("api_key", apiKey)

    if (params.nonEmpty) {
      addQueryParams(request, params)
    }

    Future[HttpRequest] {
      request
    }
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
