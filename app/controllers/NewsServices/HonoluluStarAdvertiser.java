package controllers.NewsServices;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import models.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the Honolulu Star Advertiser News Services functions.
 */
public class HonoluluStarAdvertiser {

  private static final String PROVIDER = "Honolulu Star Advertiser";
  private static final String BREAKING = "Breaking";
  private static final String POPULAR = "Popular";
  private static final String SPORTS = "Sports";

  /**
   * Gets a list of Honolulu Star Advertiser Breaking SPORTS News Articles.
   * @return articles A list of the breaking SPORTS news articles.
   */
  public static ArrayList<NewsArticle> getSportsArticles() {

    String url = "http://www.staradvertiser.com/sports/breaking/";
    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(url);
    }
    catch (JauntException e) {
      System.err.println("Error in HonoluluStarAdvertiser.java visiting breaking Sports HSA articles");
    }

    Elements stories = userAgent.doc.findEach("<a>");

    for (Element story : stories) {
      if (story.outerHTML().contains("www.staradvertiser.com/sports/breaking") &&
          story.outerHTML().contains("redesign-lede-container") ) {
        articles.add(getStarAdvertiserBreakingNewsArticles(story, SPORTS));
      }
    }

    return articles;

  }

  /**
   * Gets a list of the Honolulu Star Advertiser Most Popular stories.
   * @return A list of the most popular stories.
   */
  public static ArrayList<NewsArticle> getPopularArticles() {

    String url = "http://www.staradvertiser.com/mostpopular/";
    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(url);
    }
    catch (JauntException e) {
      System.err.println("Error in HonoluluStarAdvertiser.java visiting most popular HSA articles");
    }

    Elements div = userAgent.doc.findEvery("<div id=weird_news>");
    Elements stories = div.findEvery("<span class=hsa_content_article_title|hsa_content_premium_title>");

    for (Element story : stories) {
      articles.add(getStarAdvertiserPopularNewsArticles(story));
    }

    return articles;
  }

  /**
   * Extracts the details of the news story and returns a NewsArticle object.
   * @param story The news story.
   * @return A NewsArticle object.
   */
  private static NewsArticle getStarAdvertiserPopularNewsArticles(Element story) {

    String url = "";
    String title = "";

    List<Element> elements = story.getChildElements();

    for (Element e : elements) {
      if (e.getName().equals("a")) {
        url = cleanUrl(e.getAttx("href"));
        title = e.innerHTML();
      }
    }

    return new NewsArticle(POPULAR, PROVIDER, url, title, "", "");

  }



  /**
   * Gets a list of Honolulu Star Advertiser Breaking News Articles.
   * @return A list of the breaking news articles.
   */
  public static ArrayList<NewsArticle> getBreakingArticles() {

    String url = "http://www.staradvertiser.com/news/breaking/";
    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(url);
    }
    catch (JauntException e) {
      System.err.println("Error in HonoluluStarAdvertiser.java visiting breaking HSA articles");
    }

    Elements stories = userAgent.doc.findEach("<a>");

    for (Element story : stories) {
      if (story.outerHTML().contains("www.staradvertiser.com/news/breaking") &&
          story.outerHTML().contains("redesign-lede-container") ) {
        articles.add(getStarAdvertiserBreakingNewsArticles(story, BREAKING));
      }
    }

    return articles;

  }

  /**
   * Extracts the details of the news story and returns a NewsArticle object.
   * @param story The news story.
   * @param topic The article topic.
   * @return A NewsArticle object.
   */
  private static NewsArticle getStarAdvertiserBreakingNewsArticles(Element story, String topic) {

    // Extract URL
    String url = cleanUrl(story.getAttx("href"));
    String text = story.innerHTML().trim();

    // Extract title
    int iStart = text.indexOf("<h2>") + 4;
    int iEnd = text.indexOf("</h2>");
    String title = text.substring(iStart, iEnd);

    // Extract post date
    iStart = text.indexOf("redesign-SA-timestamp");
    iStart = text.indexOf(">", iStart) + 1;
    iEnd = text.indexOf("</span>", iStart);
    String postDate = text.substring(iStart, iEnd).trim();


    // Extract summary
    iStart = text.indexOf("</div>", iEnd) + 6;
    iEnd = text.indexOf("<!--ICONS-->", iStart);
    String summary = text.substring(iStart, iEnd).trim();

    return new NewsArticle(topic, PROVIDER, url, title, summary, postDate);

  }

  /**
   * Cleans the given url - removes '?=####' string.
   * @param url The url to clean.
   * @return A clean url.
   */
  private static String cleanUrl(String url) {
    int i = url.lastIndexOf("?id=");
    if (i > 0) {
      url = url.substring(0, i);
    }
    return url;
  }

}
