package com.github.sguzman.leetcode.scraper

import com.github.sguzman.leetcode.scraper.jsontype.Leetcode
import com.google.gson.GsonBuilder
import com.mashape.unirest.http.Unirest

object Main {
  def main(args: Array[String]): Unit = {
    val url = "https://leetcode.com/api/problems/all/"
    get(url).foreach(t => println(format(t)))
  }

  def get(url: String): Array[(Int, String)] = {
    val resp = Unirest.get(url).asJson.getBody
    val gson = new GsonBuilder().create
    val json = gson.fromJson(resp.toString, classOf[Leetcode])
    val problems = json.stat_status_pairs.map(_.stat)
    val sorted = problems.sortBy(_.question_id)
    val zip = sorted.map(_.question_id).zip(sorted.map(_.question__title))
    zip
  }

  def format(t: (Int, String)): String = s"Leetcode ${t._1}. ${t._2}"
}
