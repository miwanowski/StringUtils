package foo

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.alvinalexander.utils.StringUtils

class StringUtilsTests extends FunSuite with BeforeAndAfter {
  
  test("ellipsis tests") {
    assert(StringUtils.truncateWithEllipsis("foo bar baz", 3) == "foo...")
    assert(StringUtils.truncateWithEllipsis("foo bar baz", 7) == "foo bar...")
    assert(StringUtils.truncateWithEllipsis("foo bar baz", 10) == "foo bar ba...")
    assert(StringUtils.truncateWithEllipsis("foo bar baz", 20) == "foo bar baz")
    assert(StringUtils.truncateWithEllipsis("foo bar baz", 11) == "foo bar baz")
  }

  test("short strings") {
    assert(StringUtils.truncate("foo", 3) == "foo")
    assert(StringUtils.truncate("fooz", 3) == "foo")
  }

  test("length > string") {
    assert(StringUtils.truncate("foo", 20) == "foo")
  }

  test("string > length") {
    assert(StringUtils.truncate("foo bar baz", 3) == "foo")
    assert(StringUtils.truncate("foo bar baz", 4) == "foo ")
    assert(StringUtils.truncate("foo bar baz", 7) == "foo bar")
  }
  
  test("remove all characters other than letters and numbers") {
    assert(StringUtils.removeAllButLettersAndNumbers("foo bar baz") == "foobarbaz")
    assert(StringUtils.removeAllButLettersAndNumbers("<script language=\"java\"") == "scriptlanguagejava")
    assert(StringUtils.removeAllButLettersAndNumbers(" ") == "")
  }

  test("replace all characters other than letters and numbers") {
    assert(StringUtils.replaceAll("foo bar baz", "[^a-zA-Z0-9]", "*") == "foo*bar*baz")
    assert(StringUtils.replaceAll("<script language=\"java\"",  "[^a-zA-Z0-9]", "*") == "*script*language**java*")
    assert(StringUtils.replaceAll("  ", "[^a-zA-Z0-9]", "*") == "**")
  }

  test("text that string has only letters and numbers") {
    assert(StringUtils.lettersAndNumbersOnly_?("foo bar baz") == false)
    assert(StringUtils.lettersAndNumbersOnly_?("<script") == false)
    assert(StringUtils.lettersAndNumbersOnly_?("|") == false)
    assert(StringUtils.lettersAndNumbersOnly_?("") == false)
    assert(StringUtils.lettersAndNumbersOnly_?(" ") == false)
  }

}