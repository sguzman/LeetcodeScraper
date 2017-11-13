package com.github.sguzman.leetcode.scraper.jsontype

case class Problem(
                  difficulty: Difficulty,
                  frequency: Int,
                  is_favor: Boolean,
                  paid_only: Boolean,
                  progress: Int,
                  stat: Stat,
                  status: String
                  )
