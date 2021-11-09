package com.ddona.jsoup.parser

import com.ddona.jsoup.model.Question
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

object StackOverFlowParser {

    fun parserQuestion(question: String): List<Question> {
        val questions = arrayListOf<Question>()
        val link = "https://stackoverflow.com/search?q=$question"
        val document: Document = Jsoup.connect(link).timeout(10000).get()

        val questionElements = document.getElementsByClass("question-summary search-result")

        for (i in 0 until questionElements.size) {
            val questionElement: Element = questionElements[i]
            val voteElement: Element =
                questionElement.getElementsByClass("status answered-accepted")[0]
            val titleElement = questionElement.getElementsByClass("question-hyperlink")[0]
            val descriptionElement = questionElement.getElementsByClass("excerpt")[0]
            val timeElement = questionElement.getElementsByClass("relativetime")[0]
            val authorElement = questionElement
                .getElementsByClass("started fr")[0]
                .getElementsByTag("a")[0]
            val vote = voteElement.text()
            val title = titleElement.text()
            val description = descriptionElement.text()
            val time = timeElement.text()
            val url = titleElement.attr("href")
            val author = authorElement.text()
            questions.add(Question(title, description, vote, time, author, url))
        }
        return questions
    }
}