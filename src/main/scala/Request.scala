import scala.util.{Failure, Success}
import scalaj.http._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.{Success, Failure}

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
   * @param method The giphy endpoint method requested
   * @return String
   */
  private def buildApiEndpoint(resource: String, method: String): String = {
    apiHost + "/" + apiVersion + "/" + resource + "/" + method
  }

  /**
   *
   * @param verb The HTTP verb
   * @param params Parameters to be sent as query params
   * @return HTTPResponse[String]
   */
  def makeNew(verb: String, params: Map[String, String], resource: String, method: String):HttpResponse[String] = {
    val endpoint = buildApiEndpoint(resource, method)
    val queryParams = params + ("api_key" -> apiKey)

    Http(endpoint).params(queryParams).asString
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
