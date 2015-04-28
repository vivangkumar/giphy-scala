/**
 * Main entry point to call Giphy endpoints
 * @param apiKey Giphy apiKey
 */
class Giphy(apiKey: String) {
  /**
   * Queries the search endpoint
   * @param params Options to send to the search endpoint
   *               'q' -> search query term
   *               'limit' -> number of results to return
   *               'offset' -> results offset
   *               'rating' -> (y,g, pg, pg-13 or r)
   * @return Any
   */
  def search(params: Map[String, String]): Any = {
    ApiRequest(apiKey).makeNew("GET", Some(params), "gifs", "search")
  }

  /**
   * Get a GIF by ID
   * @param gifId ID of the gif requested
   * @return Any
   */
  def getGifById(gifId: String): Any = {
    ApiRequest(apiKey).makeNew("GET", None, "gifs", gifId)
  }

  /**
   * Get multiple GIF by ID's
   * @param gifIds List of gif ids
   * @return Any
   */
  def getGifsById(gifIds: List[String]): Any = {
    val params = Map("ids" -> gifIds.mkString(","))
    ApiRequest(apiKey).makeNew("GET", Some(params), "gifs", "")
  }

  /**
   * Queries the translate endpoint
   * @param params Options to send to the translate endpoint
   *               's'-> term or phrase to translate into a GIF
   *               'rating' -> limit results to those rated
   *                           (y,g, pg, pg-13 or r)
   * @return Any
   */
  def translate(params: Map[String, String]): Any = {
    ApiRequest(apiKey).makeNew("GET", Some(params), "gifs", "translate")
  }

  /**
   * Queries the random endpoint
   * @param params Options to send to the random endpoint
   *               'tag' -> the GIF tag to limit randomness by
   *               'rating' -> limit results to those rated
   *                           (y,g, pg, pg-13 or r)
   * @return Any
   */
  def random(params: Option[Map[String, String]]): Any = {
    ApiRequest(apiKey).makeNew("GET", params, "gifs", "random")
  }

  /**
   * Gets the latest trending GIF's
   * @param params Options to send to the trending endpoint
   *               'limit' -> limits the number of results returned
   *                          By default returns 25 results
   * @return Any
   */
  def trending(params: Option[Map[String, String]]): Any = {
    ApiRequest(apiKey).makeNew("GET", params, "gifs", "trending")
  }

  /**
   * Queries the sticker search endpoint
   * @param params Options to send to the search endpoint
   *               'q' -> search query term
   *               'limit' -> number of results to return
   *               'offset' -> results offset
   *               'rating' -> (y,g, pg, pg-13 or r)
   * @return Any
   */
  def searchStickers(params: Map[String, String]): Any = {
    ApiRequest(apiKey).makeNew("GET", Some(params), "stickers", "search")
  }
}
