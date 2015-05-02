package com.vivangkumar

abstract class GiphyException(message: String) extends Exception

class RequestException(message: String) extends GiphyException(message)

class ValidationException(message: String) extends GiphyException(message)

class InvalidValidationRuleException(message: String) extends GiphyException(message)