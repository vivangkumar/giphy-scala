package com.vivangkumar

import com.vivangkumar.Types.GiphyResponse

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
   * @return GiphyResponse
   */
  def search(params: Map[String, String]): GiphyResponse = {
    val validation = CheckRequiredParams("q", params)
    ApiRequest(apiKey).validateAndMake(validation, "GET", Some(params), "gifs", "search")
  }

  /**
   * Get a GIF by ID
   * @param gifId ID of the gif requested
   * @return GiphyResponse
   */
  def getGifById(gifId: String): GiphyResponse  = {
    val validation = CheckEmptyParam(gifId)
    ApiRequest(apiKey).validateAndMake(validation, "GET", None, "gifs", gifId)
  }

  /**
   * Get multiple GIF by ID's
   * @param gifIds List of gif ids
   * @return GiphyResponse
   */
  def getGifsById(gifIds: List[String]): GiphyResponse  = {
    val validation = CheckList(gifIds)
    val params = Map("ids" -> gifIds.mkString(","))
    ApiRequest(apiKey).validateAndMake(validation, "GET", Some(params), "gifs", "")
  }

  /**
   * Queries the translate endpoint
   * @param params Options to send to the translate endpoint
   *               's'-> term or phrase to translate into a GIF
   *               'rating' -> limit results to those rated
   *                           (y,g, pg, pg-13 or r)
   * @return GiphyResponse
   */
  def translate(params: Map[String, String]): GiphyResponse  = {
    val validation = CheckRequiredParams("s", params)
    ApiRequest(apiKey).validateAndMake(validation, "GET", Some(params), "gifs", "translate")
  }

  /**
   * Queries the random endpoint
   * @param params Options to send to the random endpoint
   *               'tag' -> the GIF tag to limit randomness by
   *               'rating' -> limit results to those rated
   *                           (y,g, pg, pg-13 or r)
   * @return GiphyResponse
   */
  def random(params: Option[Map[String, String]]): GiphyResponse  = {
    ApiRequest(apiKey).makeNew("GET", params, "gifs", "random")
  }

  /**
   * Gets the latest trending GIF's
   * @param params Options to send to the trending endpoint
   *               'limit' -> limits the number of results returned
   *                          By default returns 25 results
   * @return GiphyResponse
   */
  def trending(params: Option[Map[String, String]]): GiphyResponse  = {
    ApiRequest(apiKey).makeNew("GET", params, "gifs", "trending")
  }

  /**
   * Queries the sticker search endpoint
   * @param params Options to send to the search endpoint
   *               'q' -> search query term
   *               'limit' -> number of results to return
   *               'offset' -> results offset
   *               'rating' -> (y,g, pg, pg-13 or r)
   * @return GiphyResponse
   */
  def searchStickers(params: Map[String, String]): GiphyResponse  = {
    val validation = CheckRequiredParams("q", params)
    ApiRequest(apiKey).validateAndMake(validation, "GET", Some(params), "stickers", "search")
  }

  /**
   * Queries the random sticker endpoint
   * @param params Options to send to the random endpoint
   *              'tag' -> the GIF tag to limit randomness by
   *              'rating' -> limit results to those rated
   *                          (y,g, pg, pg-13 or r)
   * @return GiphyResponse
   */
  def randomSticker(params: Option[Map[String, String]]): GiphyResponse  = {
    ApiRequest(apiKey).makeNew("GET", params, "stickers", "random")
  }

  /**
   * Get the latest stickers trending on Giphy
   * @param params Options to query the endpoint with
   *               's' -> term or phrase to translate into a GIF
   *               'limit' -> number of results to return
   *               'offset' -> results offset
   *               'fmt' -> Format (HTML or JSON)
   *               'rating' -> limit results to those rated
   *                           (y,g, pg, pg-13 or r)
   * @return GiphyResponse
   */
  def trendingStickers(params: Map[String, String]): GiphyResponse  = {
    val validation = CheckRequiredParams("s", params)
    ApiRequest(apiKey).validateAndMake(validation,"GET", Some(params), "stickers", "trending")
  }

  /**
   * Query the sticker translate endpoint
   * @param params Options to query the endpoint with
   *               's' -> term or phrase to translate into GIF
   * @return GiphyResponse
   */
  def translateStickers(params: Map[String, String]): GiphyResponse  = {
    val validation = CheckRequiredParams("s", params)
    ApiRequest(apiKey).validateAndMake(validation, "GET", Some(params), "stickers", "translate")
  }
}
