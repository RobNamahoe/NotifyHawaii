package models;

import controllers.NewsServices.CivilBeat;
import controllers.NewsServices.HonoluluStarAdvertiser;
import controllers.NewsServices.MauiNews;

import java.util.ArrayList;
import java.util.List;

/**
 * A helper class for managing News Articles.
 */
public class NewsArticleDB {

  /**
   * Add the article to the database.
   * @param article The article to add.
   */
  public static synchronized void add(NewsArticle article) {
    article.save();
  }

  /**
   * Checks if an article with the supplied url already exists in the database.
   * @param url The url of the article.
   * @return True if the article exists, false otherwise.
   */
  public static boolean exists(String url) {
    NewsArticle article = NewsArticle.find().where().eq("url", url).findUnique();
    return (article != null);
  }


  /**
   * Gets a list of News Articles from the specified site and topic.
   * @param provider The site.
   * @param topic The topic.
   * @return A list of news articles.
   */
  public static List<NewsArticle> getArticles(String provider, String topic) {
    return NewsArticle.find().where().eq("provider", provider).where().eq("topic", topic).findList();
  }

  /**
   * Gets a list of News Articles from the specified NewsServiceSubscription.
   * @param subscription The NewsServiceSubscription object.
   * @return A list of news articles.
   */
  public static List<NewsArticle> getArticles(NewsServicesSubscription subscription) {
    return getArticles(subscription.getSite(), subscription.getTopic());
  }


  /**
   * Update the database with current news articles.
   */
  public static void updateDB() {

    // Honolulu Star Advertiser
    Thread hsaThread = new Thread(new StarAdvertiserUpdaterThread());
    hsaThread.start();

    // Maui News
    Thread mnThread = new Thread(new MauiNewsUpdaterThread());
    mnThread.start();

    // Civil Beat
    Thread cbThread = new Thread(new CivilBeatUpdaterThread());
    cbThread.start();

    try {
      hsaThread.join();
      mnThread.join();
      cbThread.join();
    }
    catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Done");

  }

  /**
   * A private nested class to update the database with Star Advertiser articles.
   */
  private static class StarAdvertiserUpdaterThread implements Runnable {

    /**
     * Retrieve Honolulu Star Advertiser articles.
     */
    public void run() {

      ArrayList<NewsArticle> articles = HonoluluStarAdvertiser.getBreakingArticles();
      articles.addAll(HonoluluStarAdvertiser.getPopularArticles());
      articles.addAll(HonoluluStarAdvertiser.getSportsArticles());

      for (NewsArticle article : articles) {
        if (!NewsArticleDB.exists(article.getUrl())) {
          NewsArticleDB.add(article);
        }
      }
    }
  }

  /**
   * A private nested class to update the database with Maui News articles.
   */
  private static class MauiNewsUpdaterThread implements Runnable {

    /**
     * Retrieve Maui News articles.
     */
    public void run() {

      ArrayList<NewsArticle> articles = MauiNews.getHawaiiNewsArticles();
      articles.addAll(MauiNews.getLocalNewsArticles());
      articles.addAll(MauiNews.getBreakingNewsArticles());
      articles.addAll(MauiNews.getBusinessNewsArticles());

      for (NewsArticle article : articles) {
        if (!NewsArticleDB.exists(article.getUrl())) {
          NewsArticleDB.add(article);
        }
      }
    }
  }

  /**
   * A private nested class to update the database with Civil Beat articles.
   */
  private static class CivilBeatUpdaterThread implements Runnable {

    /**
     * Retrieve Civil Beat articles.
     */
    public void run() {

      ArrayList<NewsArticle> articles = CivilBeat.getPopularArticles();
      articles.addAll(CivilBeat.getHonoluluArticles());
      articles.addAll(CivilBeat.getHawaiiArticles());
      articles.addAll(CivilBeat.getEducationArticles());
      articles.addAll(CivilBeat.getPoliticsArticles());
      articles.addAll(CivilBeat.getEnergyAndEnvironmentArticles());
      articles.addAll(CivilBeat.getDevelopmentArticles());

      for (NewsArticle article : articles) {
        if (!NewsArticleDB.exists(article.getUrl())) {
          NewsArticleDB.add(article);
        }
      }
    }
  }
}
