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

  private static final String PROVIDER = "Civil Beat";

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
    String url, topic;
    switch (type) {
      case POPULAR:
        return getPopularArticles();
      case HONOLULU:
        topic = "Honolulu";
        url = "http://www.civilbeat.com/category/honolulu-beat/";
        break;
      case HAWAII:
        topic = "Hawaii";
        url = "http://www.civilbeat.com/category/hawaii-beat/";
        break;
      case EDUCATION:
        topic = "Education";
        url = "http://www.civilbeat.com/category/education-beat/";
        break;
      case POLITICS:
        topic = "Politics";
        url = "http://www.civilbeat.com/category/election-2014-beat/";
        break;
      case ENERGY_AND_ENVIRONMENT:
        topic = "Energy";
        url = "http://www.civilbeat.com/category/energy-environment-beat/";
        break;
      case DEVELOPMENT:
        topic = "Development";
        url = "http://www.civilbeat.com/category/development-beat/";
        break;
      default:
        return getPopularArticles();
    }
    return getArticles(url, topic);
  }


  /**
   * Get a list of Civil Beats Honolulu Articles.
   * @param pageUrl The url of the page to scrape.
   * @param topic The topic of the article.
   * @return A list of Civil Beats Honolulu articles.
   */
  private static ArrayList<NewsArticle> getArticles(String pageUrl, String topic) {

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
        String postDate = "";

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


        Element divTime = story.findEach("<time>");
        postDate = divTime.innerText();

        Element divBody = story.findEach("<div class=\"body\">");
        Element divBodyP = null;

        try {
          divBodyP = divBody.findFirst("<p>");
          summary = divBodyP.innerHTML();
        }
        catch (NotFound notFound) {
          notFound.printStackTrace();
        }

        articles.add(new NewsArticle(topic, PROVIDER, url, title, summary, postDate));
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
        String postDate = "";
        articles.add(new NewsArticle("Popular", PROVIDER, url, title, summary, postDate));
      }
      catch (NotFound notFound) {
        System.err.println("Error in CivilBeat.java line 36");
      }
    }
    return articles;
  }

}
