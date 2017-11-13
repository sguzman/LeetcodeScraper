package com.github.sguzman.leetcode.scraper

import org.scalatest.FunSuite

class MainTest extends FunSuite {
  test("Does it run through the entire process without throwing an error?") {
    val url = "https://leetcode.com/api/problems/all/"
    val tups = Main.app(url)

    tups.foreach(t => {
      val title = t._2
      title.matches("""^Leetcode [1-9]+[0-9]*\. [A-Za-z0-9]$""")
    })
  }
}
