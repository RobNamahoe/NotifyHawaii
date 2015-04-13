package controllers.NewsServices;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.NotFound;
import com.jaunt.UserAgent;
import models.NewsArticle;

import java.util.ArrayList;

/**
 * Implements the Civil Beat News Services functions.
 */
public class CivilBeat {

  /** An enumeration of article types. */
  private static enum ArticleType { POPULAR, HONOLULU, HAWAII, EDUCATION,
      POLITICS, ENERGY_AND_ENVIRONMENT, DEVELOPMENT }

  /**
   * Gets a list of Civil Beat Popular News articles.
   * @return A list of popular news articles.
   */
  public static ArrayList<NewsArticle> getHonoluluArticles() {
    return getArticles(ArticleType.HONOLULU);
  }

  /**
   * Gets a list of Civil Beat Hawaii News articles.
   * @return A list of Hawaii News articles.
   */
  public static ArrayList<NewsArticle> getHawaiiArticles() {
    return getArticles(ArticleType.HAWAII);
  }

  /**
   * Gets a list of Civil Beat Education News articles.
   * @return A list of Education News articles.
   */
  public static ArrayList<NewsArticle> getEducationArticles() {
    return getArticles(ArticleType.EDUCATION);
  }

  /**
   * Gets a list of Civil Beat Politics News articles.
   * @return A list of Politics News articles.
   */
  public static ArrayList<NewsArticle> getPoliticsArticles() {
    return getArticles(ArticleType.POLITICS);
  }

  /**
   * Gets a list of Civil Beat Energy and Environment News articles.
   * @return A list of Energy and Environment News articles.
   */
  public static ArrayList<NewsArticle> getEnergyAndEnvironmentArticles() {
    return getArticles(ArticleType.ENERGY_AND_ENVIRONMENT);
  }

  /**
   * Gets a list of Civil Beat Development News articles.
   * @return A list of Development News articles.
   */
  public static ArrayList<NewsArticle> getDevelopmentArticles() {
    return getArticles(ArticleType.DEVELOPMENT);
  }

  /**
   * Gets the Civil Beat News articles of the specified ArticleType.
   * @param type The article type.
   * @return A list of News Articles for the specified type.
   */
  private static ArrayList<NewsArticle> getArticles(ArticleType type) {
    String url;
    switch (type) {
      case POPULAR:
        return getPopularArticles();
      case HONOLULU:
        url = "http://www.civilbeat.com/category/honolulu-beat/";
        break;
      case HAWAII:
        url = "http://www.civilbeat.com/category/hawaii-beat/";
        break;
      case EDUCATION:
        url = "http://www.civilbeat.com/category/education-beat/";
        break;
      case POLITICS:
        url = "http://www.civilbeat.com/category/election-2014-beat/";
        break;
      case ENERGY_AND_ENVIRONMENT:
        url = "http://www.civilbeat.com/category/energy-environment-beat/";
        break;
      case DEVELOPMENT:
        url = "http://www.civilbeat.com/category/development-beat/";
        break;
      default:
        return getPopularArticles();
    }
    return getArticles(url);
  }


  /**
   * Get a list of Civil Beats Honolulu Articles.
   * @param pageUrl The url of the page to scrape.
   * @return A list of Civil Beats Honolulu articles.
   */
  private static ArrayList<NewsArticle> getArticles(String pageUrl) {

    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(pageUrl);
    }
    catch (JauntException e) {
      System.err.println("Error in CivilBeat.java visiting Honolulu articles.");
    }

    Elements stories = userAgent.doc.findEach("<article>");

    for (Element story : stories) {
      String html = story.innerHTML();
      if (html.contains("<div class=\"body\">") && html.contains("<div class=\"excerpt indent\">")) {

        String url = "";
        String title = "";
        String summary = "";

        Element divMetaH2 = story.findEach("<div class=\"meta\">").findEach("<h2>");
        Element link = null;

        try {
          link = divMetaH2.findFirst("<a>");
          url = link.getAttx("href");
          title = link.innerHTML();
        }
        catch (NotFound notFound) {
          notFound.printStackTrace();
        }

        Element divBody = story.findEach("<div class=\"body\">");
        Element divBodyP = null;

        try {
          divBodyP = divBody.findFirst("<p>");
          summary = divBodyP.innerHTML();
        }
        catch (NotFound notFound) {
          notFound.printStackTrace();
        }

        articles.add(new NewsArticle(url, title, summary));

      }
    }

    return articles;

  }

  /**
   * Gets a list of Civil Beat Popular Articles.
   * @return A list of popular civil beat articles.
   */
  public static ArrayList<NewsArticle> getPopularArticles() {

    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit("http://www.civilbeat.com/");
    }
    catch (JauntException e) {
      System.err.println("Error in CivilBeat.java visiting Most Popular articles.");
    }

    Elements stories = userAgent.doc.findEach("<ol>").findEach("<li>");

    for (Element story : stories) {
      try {
        Element link = story.findFirst("<a>");
        String url = link.getAttx("href");
        String title = link.getAttx("title");
        String summary = "";
        articles.add(new NewsArticle(url, title, summary));
      }
      catch (NotFound notFound) {
        System.err.println("Error in CivilBeat.java line 36");
      }
    }
    return articles;
  }

}
