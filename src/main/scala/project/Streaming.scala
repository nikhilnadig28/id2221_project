package project

import org.apache.ivy.ant.IvyAntSettings.Credentials
import org.apache.spark.SparkConf
import org.apache.spark.streaming._
import twitter4j._
import twitter4j.conf.ConfigurationBuilder



import scala.collection.JavaConversions._

object Streaming {
  def main(args: Array[String]) {

    val Array(consumerKey, consumerSecret, accessToken, accessTokenSecret) = args.take(4)

    val configurationBuilder = new ConfigurationBuilder();
    configurationBuilder.setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
      .setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret)


    val str = Stre


    val tf = new TwitterFactory(configurationBuilder.build());
    val twitter = tf.getInstance()
    val query = new Query("donald trump").lang("en")

    val result = twitter.search(query)

    for (status <- result.getTweets) {
      System.out.println("@" + status.getUser.getScreenName + ":" + status.getText + ":" + status.getCreatedAt)
    }
  }
}
