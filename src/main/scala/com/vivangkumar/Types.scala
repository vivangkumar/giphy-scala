package com.vivangkumar

/**
 * Types for responses and validation
 */
object Types {

  type GiphyResponse = Either[GiphyException, Map[String, Any]]

  type ValidationResponse = Either[GiphyException, Boolean]

}

