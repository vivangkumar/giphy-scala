/**
 *
 * @param apiKey Giphy apiKey
 */
class Giphy(apiKey: String) {
  /**
   * Queries the search endpoint
   * @param params Options to pass to the search endpoint
   *               'q' (required) -> search query term
   *               'limit' (optional) -> number of results to return
   *               'offset' (optional) -> results offset
   *               'rating' (optional) ->  (y,g, pg, pg-13 or r)
   * @return JSON string
   */
  def search(params: Map[String, String]): String = {
    val request = ApiRequest(apiKey).makeNew("GET", params, "gifs", "search")
    request.body
  }
}
