package se.id2221

import analysis.Analysis
import org.apache.spark.SparkConf
import org.apache.spark.streaming.twitter.TwitterUtils
import org.apache.spark.streaming.{Seconds, StreamingContext}
import twitter4j._
import twitter4j.conf.ConfigurationBuilder


object Streaming {
  def main(args: Array[String]) {

    if (args.length < 4) {
      println("1. CONSUMER KEY, 2. CONSUMER SECRET, 3. ACCESS TOKEN, 4. ACCESS TOKEN SECRET")
      System.exit(1)
    }

    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)

    val configurationBuilder = new ConfigurationBuilder()
    configurationBuilder.setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret)

    val tf = new TwitterFactory(configurationBuilder.build)
    val twitter = tf.getInstance

    val conf = new SparkConf()
    val name = "id2221"

    conf.setAppName(name).setMaster("local[3]")

    import org.apache.log4j.{Level, Logger}
    Logger.getLogger("org").setLevel(Level.ERROR)

    val ssc = new StreamingContext(conf, Seconds(10))
    val trumpTweets = TwitterUtils.createStream(ssc, Some(twitter.getAuthorization), Array("Donald Trump", "donald trump"))


    trumpTweets.foreachRDD {d =>
      d.foreach {x =>
        // Fetches "location" from the users profile, if it has been set.
        val loc = twitter.showUser(x.getUser.getId).getLocation
        val location = if (loc.isEmpty) "unknown" else loc
        println("LOC: " + location + " Text: " + x.getText + " Sentiment: " + Analysis.mainSentiment(x.getText))
      }
    }

    ssc.start()
    ssc.awaitTermination()
  }
}
