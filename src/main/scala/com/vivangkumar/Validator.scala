package com.vivangkumar

abstract class ValidationRule

/**
 *
 * @param param Param to validate
 * @param map Map to be checked in
 */
case class CheckRequiredParams(param: String, map: Map[String, Any]) extends ValidationRule

/**
 * Check if a parameter is empty
 * @param param Parameter to validate
 */
case class CheckEmptyParam(param: String) extends ValidationRule

class Validator {
  /**
   * Performs the actual validation
   * @param v A ValidationRule
   * @return Either [Error, Boolean]
   */
  def validate(v: ValidationRule): Either[Error, Boolean] = v match {
    case CheckRequiredParams(param, map) =>
      if (map.contains(param) && param.nonEmpty) {
        Right(true)
      } else {
        Left(new Error("Required param " + param + " is missing"))
      }
    case CheckEmptyParam(param) =>
      if (param.nonEmpty) {
        Right(true)
      } else {
        Left(new Error("Parameter " + param + " is empty"))
      }
  }
}