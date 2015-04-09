package controllers;

import com.jaunt.Element;
import com.jaunt.Elements;
import com.jaunt.JauntException;
import com.jaunt.UserAgent;
import models.NewsArticle;

import java.util.ArrayList;
import java.util.List;

/**
 * Implements the News Services services.
 */
public class NewsServices {

  /**
   * Gets a list of Honolulu Star Advertiser Breaking SPORTS News Articles.
   * @return articles A list of the breaking SPORTS news articles.
   */
  public static ArrayList<NewsArticle> getStarAdvertiserBreakingNewsSportsArticles() {

    String url = "http://www.staradvertiser.com/sports/breaking/";
    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(url);
    }
    catch (JauntException e) {
      System.err.println("Error in NewsServices.java visiting breaking Sports HSA articles");
    }

    Elements stories = userAgent.doc.findEach("<div id=\"redesign-digest-container\">").findEvery("<a>");

    for (Element story : stories) {
      articles.add(getStarAdvertiserBreakingNewsArticles(story));
    }

    return articles;

  }

  /**
   * Gets a list of the Honolulu Star Advertiser Most Popular stories.
   * @return A list of the most popular stories.
   */
  public static ArrayList<NewsArticle> getStartAdvertiserPopularNewsArticles() {

    String url = "http://www.staradvertiser.com/mostpopular/";
    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(url);
    }
    catch (JauntException e) {
      System.err.println("Error in NewsServices.java visiting most popular HSA articles");
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

    return new NewsArticle(url, title, "");
  }



  /**
   * Gets a list of Honolulu Star Advertiser Breaking News Articles.
   * @return A list of the breaking news articles.
   */
  public static ArrayList<NewsArticle> getStarAdvertiserBreakingNewsArticles() {

    String url = "http://www.staradvertiser.com/news/breaking/";
    ArrayList<NewsArticle> articles = new ArrayList<>();

    UserAgent userAgent = new UserAgent();
    try {
      userAgent.visit(url);
    }
    catch (JauntException e) {
      System.err.println("Error in NewsServices.java visiting breaking HSA articles");
    }

    Elements stories = userAgent.doc.findEach("<div id=\"redesign-digest-container\">").findEvery("<a>");

    for (Element story : stories) {
      articles.add(getStarAdvertiserBreakingNewsArticles(story));
    }

    return articles;

  }


  /**
   * Extracts the details of the news story and returns a NewsArticle object.
   * @param story The news story.
   * @return A NewsArticle object.
   */
  private static NewsArticle getStarAdvertiserBreakingNewsArticles(Element story) {

    String url = cleanUrl(story.getAttx("href"));
    String text = story.innerHTML().trim();

    int iStart = text.indexOf("<h2>") + 4;
    int iEnd = text.indexOf("</h2>");

    String title = text.substring(iStart, iEnd);

    // remove last </div> tag
    text = text.substring(0, text.length() - 6);

    iStart = text.lastIndexOf("</div>") + 6;
    iEnd = text.length();

    String summary = text.substring(iStart, iEnd).trim();

    return new NewsArticle(url, title, summary);

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
