package com.alvinalexander.utils

object StringUtils {
  
  def truncate(s: String, length: Int) = s.take(length)

  /**
   * Returns a String that is the same as the input String, but
   * truncated to the specified length.
   */
  def truncateWithEllipsis(s: String, length: Int) = {
    if (s.length > length) {
      s.take(length) + "..."
    } else {
      s
    }
  }

  /**
   * A 'sanitize' method. Takes an input String, and returns a
   * new String with all characters removed from that String
   * other than letters and numbers.
   */
  def removeAllButLettersAndNumbers(s: String) = {
    replaceAll(s, "[^a-zA-Z0-9]", "")
  }
  
  /**
   * @param s The string to perform the replace operation on (such as "123 Main Street")
   * @param regex The regular expression to use to find what you want to replace.
   * @param replaceWith The string you want to use as the replacement. Can be an empty string,
   * asterisk, etc., anything you want to use as the replacement pattern.
   */
  def replaceAll(s: String, regex: String, replaceWith: String) = {
    val r = regex.r
    r.replaceAllIn(s, replaceWith)
  }
  
  def lettersAndNumbersOnly_?(s: String) = s.matches("[a-zA-Z0-9]")

}


