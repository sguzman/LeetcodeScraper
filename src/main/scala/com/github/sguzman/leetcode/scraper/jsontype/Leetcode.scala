package com.github.sguzman.leetcode.scraper.jsontype

case class Leetcode(
                     ac_easy: Int,
                     ac_hard: Int,
                     ac_medium: Int,
                     category_slug: String,
                     frequency_high: Int,
                     frequency_mid: Int,
                     is_paid: Boolean,
                     num_solved: Int,
                     num_total: Int,
                     stat_status_pairs: Array[Problem],
                     user_name: String
                   )
