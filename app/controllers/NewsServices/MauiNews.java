package controllers.NewsServices;

import com.jaunt.Element;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.UserAgent;
import models.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Maui News News Services functions.
 */
public class MauiNews {


  private static final String PROVIDER = "Maui News";

  /** An enumeration of article types. */
  private static enum ArticleType { HAWAII_NEWS, LOCAL_NEWS, BREAKING_NEWS, BUSINESS_NEWS }

  /**
   * Gets a list of Maui News 'Breaking News' articles.
   * @return A list of 'Breaking News' articles.
   */
  public static ArrayList<NewsArticle> getBreakingNewsArticles() {
    return getArticles(ArticleType.BREAKING_NEWS);
  }

  /**
   * Gets a list of Maui News 'Local News' articles.
   * @return A list of 'Local News' articles.
   */
  public static ArrayList<NewsArticle> getLocalNewsArticles() {
    return getArticles(ArticleType.LOCAL_NEWS);
  }

  /**
   * Gets a list of Maui News 'Hawaii News' articles.
   * @return A list of 'Hawaii News' articles.
   */
  public static ArrayList<NewsArticle> getHawaiiNewsArticles() {
    return getArticles(ArticleType.HAWAII_NEWS);
  }

  /**
   * Gets a list of Maui News 'Hawaii News' articles.
   * @return A list of 'Hawaii News' articles.
   */
  public static ArrayList<NewsArticle> getBusinessNewsArticles() {
    return getArticles(ArticleType.BUSINESS_NEWS);
  }

  /**
   * Gets the Maui News articles of the specified ArticleType.
   * @param type The article type.
   * @return A list of News Articles for the specified type.
   */
  private static ArrayList<NewsArticle> getArticles(ArticleType type) {
    String url, topic;
    switch (type) {
      case HAWAII_NEWS:
        topic = "Hawaii";
        url = "http://www.mauinews.com/page/category.detail/nav/5031/Hawaii-News.html";
        break;
      case LOCAL_NEWS:
        topic = "Local";
        url = "http://www.mauinews.com/page/category.detail/nav/10/Local-News.html";
        break;
      case BREAKING_NEWS:
        topic = "Breaking";
        url = "http://www.mauinews.com/page/category.detail/nav/5161/Breaking-News.html";
        break;
      case BUSINESS_NEWS:
        topic = "Business";
        url = "http://www.mauinews.com/page/category.detail/nav/8/Business.html";
        break;
      default:
        topic = "";
        url = "";
        break;
    }
    return getArticles(url, topic);
  }

  /**
   * Extracts the details of news stories and returns a NewsArticle object.
   * @param pageUrl The of the page with stories to scrape.
   * @return A list NewsArticle objects.
   */
  private static ArrayList<NewsArticle> getArticles(String pageUrl, String topic) {

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(pageUrl);
    }
    catch (JauntException e) {
      System.err.println("Error in MauiNews.java visiting Maui News articles.");
    }

    List<Element> stories = userAgent.doc.findEach("<div class=\"contentShortL\">").getChildElements();
    ArrayList<NewsArticle> articles = new ArrayList<>();

    for (Element story : stories) {

      if (story.innerHTML().contains("/page/content.detail/")) {

        Element p, link;
        String html = "";
        String url = "";
        String title = "";
        String summary = "";
        String postDate = "";

        try {
          p = story.findFirst("<p>");
          link = p.findFirst("<a>");

          html = p.innerHTML().trim();
          url = cleanUrl(link.getAttx("href"));
          title = link.getAttx("title");
        }
        catch (NotFound notFound) {
          notFound.printStackTrace();
        }

        if (!html.equals("")) {

          // Extract post date
          int iStart = html.indexOf("<em class=\"dim\">") + 16;
          int iEnd = html.indexOf("</em>", iStart);
          postDate = html.substring(iStart, iEnd).trim();

          // Extract summary
          iStart = html.indexOf("</em>") + 5;
          iEnd = html.indexOf("<a href=");
          summary = html.substring(iStart, iEnd).trim();

          articles.add(new NewsArticle(topic, PROVIDER, url, title, summary, postDate));
        }
      }
    }
    return articles;
  }

  /**
   * Cleans the given url - removes '?=####' string.
   * @param url The url to clean.
   * @return A clean url.
   */
  private static String cleanUrl(String url) {
    int i = url.lastIndexOf("?nav=");
    if (i > 0) {
      url = url.substring(0, i);
    }
    return url;
  }

}
