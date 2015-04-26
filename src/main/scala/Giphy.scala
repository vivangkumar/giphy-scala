/**
 *
 * @param apiKey Giphy apiKey
 */
class Giphy(apiKey: String) {
  /**
   * Queries the search endpoint
   * @param query Search query string
   * @return JSON string
   * TODO Add parameters for search
   */
  def search(query: String): String = {
    val params = Map("q" -> query)
    val request = ApiRequest(apiKey).makeNew("GET", params, "gifs", "search")
    request.body
  }
}
