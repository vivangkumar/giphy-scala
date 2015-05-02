package com.vivangkumar

import com.vivangkumar.Types.ValidationResponse

abstract class ValidationRule

/**
 * Check if a parameter is in the list
 * @param param Param to validate
 * @param map Map to be checked in
 */
case class CheckRequiredParams(param: String, map: Map[String, Any]) extends ValidationRule

/**
 * Check if a parameter is empty
 * @param param Parameter to validate
 */
case class CheckEmptyParam(param: String) extends ValidationRule

/**
 * Check if there is atleast one item in the list
 * @param paramList List to be validated
 */
case class CheckList(paramList: List[String]) extends ValidationRule

class Validator {
  /**
   * Performs the actual validation
   * @param v A ValidationRule
   * @return ValidationResponse
   */
  def validate(v: ValidationRule): ValidationResponse = v match {
    case CheckRequiredParams(param, map) =>
      if (map.contains(param) && param.nonEmpty) {
        Right(true)
      } else {
        Left(new ValidationException("Required param " + param + " is missing"))
      }
    case CheckEmptyParam(param) =>
      if (param.nonEmpty) {
        Right(true)
      } else {
        Left(new ValidationException("Parameter " + param + " is empty"))
      }
    case CheckList(paramList) =>
      if (paramList.length >= 1) {
        Right(true)
      } else {
        Left(new ValidationException("The parameter list should contain atleast one item"))
      }
    case _ => Left(new InvalidValidationRuleException("Invalid validation rule"))
  }
}