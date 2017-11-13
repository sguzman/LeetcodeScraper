package com.github.sguzman.leetcode.scraper.jsontype

case class Stat(
                 is_new_question: Boolean,
                 question__article__live: Boolean,
                 question__article__slug: String,
                 question__hide: Boolean,
                 question__title: String,
                 question__title_slug: String,
                 question_id: Int,
                 total_acs: Int,
                 total_submitted: Int
               )
