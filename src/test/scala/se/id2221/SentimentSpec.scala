package se.id2221

import org.scalatest.{BeforeAndAfterAll, FlatSpec}
import se.id2221.analysis.{Analysis, Sentiment}

class SentimentSpec extends FlatSpec {

  "Negative tweet about Trump" should "result in a negative output" in {
    val text = "Donald trump is a bad president"
    assert(Analysis.mainSentiment(text) == Sentiment.NEGATIVE)
  }

  "Positive tweet about Trump" should "result in a positive output" in {
    val text = "Donald Trump is a great president"
    assert(Analysis.mainSentiment(text) == Sentiment.POSITIVE)
  }

  "Neutral tweet about Trump" should "result in a neutral output" in {
    val text = "Donald Trump is a president"
    assert(Analysis.mainSentiment(text) == Sentiment.NEUTRAL)
  }
}
