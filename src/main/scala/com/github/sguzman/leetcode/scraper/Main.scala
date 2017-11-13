package com.github.sguzman.leetcode.scraper

import com.github.sguzman.leetcode.scraper.jsontype.Leetcode
import com.google.gson.GsonBuilder
import com.mashape.unirest.http.Unirest

object Main {
  def main(args: Array[String]): Unit = {
    val url = "https://leetcode.com/api/problems/all/"
    println(get(url))
  }

  def get(url: String) = {
    val resp = Unirest.get(url).asJson.getBody
    val gson = new GsonBuilder().create
    val json = gson.fromJson(resp.toString, classOf[Leetcode])
    json
  }
}
