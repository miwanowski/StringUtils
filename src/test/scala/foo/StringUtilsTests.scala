package foo

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import com.alvinalexander.utils.StringUtils

class StringUtilsTests extends FunSuite with BeforeAndAfter {
  
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

}