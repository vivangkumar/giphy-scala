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
   * @return Any
   */
  def search(params: Map[String, String]): Any = {
    ApiRequest(apiKey).makeNew("GET", Some(params), "gifs", "search")
  }

  /**
   *
   * @param gifId ID of the gif requested
   * @return Any
   */
  def getGifById(gifId: String): Any = {
    ApiRequest(apiKey).makeNew("GET", None, "gifs", gifId)
  }
}
