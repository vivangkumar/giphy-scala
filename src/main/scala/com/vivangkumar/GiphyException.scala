package com.vivangkumar

/**
 * Base class that inherits from Exception
 * @param message Exception message
 */
abstract class GiphyException(message: String) extends Exception

/**
 * Exception to be thrown when a Request error occurs
 * @param message Exception message
 */
class RequestException(message: String) extends GiphyException(message)

/**
 * Validation exceptions
 * @param message Exception message
 */
class ValidationException(message: String) extends GiphyException(message)

/**
 * Convenience invalid validation rule exception
 * @param message Exception message
 */
class InvalidValidationRuleException(message: String) extends GiphyException(message)