package com.github.sguzman.leetcode.scraper

import com.github.sguzman.leetcode.scraper.jsontype.{Difficulty, Leetcode, Stat}
import com.google.gson.GsonBuilder
import com.mashape.unirest.http.{JsonNode, Unirest}

object Main {
  def main(args: Array[String]): Unit = {
    val url = "https://leetcode.com/api/problems/all/"
    val tups = Main.app(url)

    tups.foreach(t => println(format(t)))
  }

  def app(url: String): Array[(Int, String)] = {
    val resp = Main.get(url)
    val l33t = Main.toLeetcode(resp)
    val stats = Main.toStats(l33t)
    val sorted = Main.sortById(stats)

    Main.idAndTitle(sorted)
  }

  private def get(url: String): JsonNode = Unirest.get(url).asJson.getBody

  private def toLeetcode(json: JsonNode) = new GsonBuilder().create.fromJson(json.toString, classOf[Leetcode])

  private def toStats(l33t: Leetcode) = l33t.stat_status_pairs.map(_.stat)

  private def sortById(stats: Array[Stat]) = stats.sortBy(_.question_id)

  private def idAndTitle(xs: Array[Stat]) = xs.map(_.question_id).zip(xs.map(_.question__title))

  private def format(t: (Int, String)): String = s"Leetcode ${t._1}. ${t._2}"
}
