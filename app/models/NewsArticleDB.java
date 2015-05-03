package models;

import controllers.NewsServices.HonoluluStarAdvertiser;
import controllers.NewsServices.MauiNews;

import java.util.ArrayList;

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
   * Add the article to the database.
   * @param url The url of the article.
   * @param title The title of the article.
   * @param summary A summary of the article.
   * @param topic The topic.
   */
  public static synchronized void add(String url, String title, String summary, String topic) {
    NewsArticle article = new NewsArticle(url, title, summary, topic);
    article.save();
  }


  public static void add(String url, String title, String summary) {
    NewsArticle article = new NewsArticle(url, title, summary, "");
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
   * Update the database with current news articles.
   */
  public static void updateDB() {

    // Honolulu Star Advertiser
    Thread tHsaPopular = new Thread(new WorkerThread("hsa_popular"));
    tHsaPopular.start();

    Thread tHsaBreaking = new Thread(new WorkerThread("hsa_breaking"));
    tHsaBreaking.start();

    Thread tHsaSports = new Thread(new WorkerThread("hsa_sports"));
    tHsaSports.start();

    // Maui News
    Thread tMnHawaii = new Thread(new WorkerThread("mn_hawaii"));
    tMnHawaii.start();

    Thread tMnLocal = new Thread(new WorkerThread("mn_local"));
    tMnLocal.start();

    Thread tMnBreaking = new Thread(new WorkerThread("mn_breaking"));
    tMnBreaking.start();

    Thread tMnBusiness = new Thread(new WorkerThread("mn_business"));
    tMnBusiness.start();

    // Civil Beat


  }

  private static class WorkerThread implements Runnable {

    String topic;

    /**
     * Creates a new instance of the worker thread.
     * @param topic The topic to retrieve.
     */
    public WorkerThread(String topic) {
      this.topic = topic;
    }

    /**
     * Retrieve the articles.
     */
    public void run() {

      ArrayList<NewsArticle> articles = new ArrayList<>();

      switch (topic) {
        case "hsa_breaking":
          articles = HonoluluStarAdvertiser.getBreakingArticles();
          break;
        case "hsa_popular":
          articles = HonoluluStarAdvertiser.getPopularArticles();
          break;
        case "hsa_sports":
          articles = HonoluluStarAdvertiser.getSportsArticles();
          break;
        case "mn_hawaii":
          articles = MauiNews.getHawaiiNewsArticles();
          break;
        case "mn_local":
          articles = MauiNews.getLocalNewsArticles();
          break;
        case "mn_breaking":
          articles = MauiNews.getBreakingNewsArticles();
          break;
        case "mn_business":
          articles = MauiNews.getBusinessNewsArticles();
          break;





        default:
          break;
      }

      for (NewsArticle article : articles) {
          //System.out.println(article.getTopic() + ": " + article.getTitle());
        if (!NewsArticleDB.exists(article.getUrl())) {
          NewsArticleDB.add(article);
        }
      }
    }

  }

}
