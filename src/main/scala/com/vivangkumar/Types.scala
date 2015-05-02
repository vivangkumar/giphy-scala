package com.vivangkumar


object Types {

  type GiphyResponse = Either[GiphyException, Map[String, Any]]

  type ValidationResponse = Either[GiphyException, Boolean]
}
