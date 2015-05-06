package controllers.NewsServices;

import controllers.Communication.Email;
import controllers.Communication.TextMessage;
import models.NewsArticle;
import models.NewsArticleDB;
import models.NewsServiceSubscriptionDB;
import models.NewsServicesSubscription;
import models.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * A class the executes the News Services services.
 */
public class NewsServices {

  /**
   * Executes the subscribed services.
   */
  public static void execute() {

    String content;
    List<UserInfo> subscribers = NewsServiceSubscriptionDB.getSubscriptionHolders();

    NewsArticleDB.updateDB();

    for (UserInfo subscriber : subscribers) {
      // Send Email
      content = getEmailHtml(subscriber);
      Email.send(subscriber.getEmail(), "News Services", content);

      // Send Text
      if (subscriber.notifyNewsByText()) {
        content = "Aloha! Here's your news articles: http://www.notifyhawaii.com/viewmyarticles?id="
                  + subscriber.getId();
        TextMessage.send(subscriber.getTelephone(), subscriber.getCarrier(), content);
      }
    }
  }

  /**
   * Gets the HTML content of the View file for the specified user.
   * @param user The user.
   * @return The HTML content.
   */
  public static String getTextHtml(UserInfo user) {

    String content = "<h2>Aloha " + user.getFirstName() + ",<br><br>Here are the news articles you've requested:</h2>";

    List<NewsServicesSubscription> subscriptions = NewsServiceSubscriptionDB.getSubscriptions(user.getEmail());
    for (NewsServicesSubscription subscription : subscriptions) {

      if (subscription.getMethod().equals("Text")) {

        String header = subscription.getHeader();
        List<NewsArticle> articles = NewsArticleDB.getArticles(subscription);

        if (articles.size() > 0) {
          content += "<h3><u>" + header + "</u></h3><ul>";
          for (NewsArticle article : articles) {
            content += "<li>" + article.getHtml() + "</li>";
          }
          content += "</ul>";
        }
      }
    }

    return content;
  }

  /**
   * Gets the list of articles as an HTML document.
   * @param user The user.
   * @return The message content as an HTML document.
   */
  private static String getEmailHtml(UserInfo user) {

    String content = "<h2>Aloha " + user.getFirstName() + ",<br><br>Here are the news articles you've requested:</h2>";

    List<NewsServicesSubscription> subscriptions = NewsServiceSubscriptionDB.getSubscriptions(user.getEmail());
    for (NewsServicesSubscription subscription : subscriptions) {

      if (subscription.getMethod().equals("Email")) {

        String header = subscription.getHeader();
        List<NewsArticle> articles = NewsArticleDB.getArticles(subscription);

        if (articles.size() > 0) {
          content += "<h3><u>" + header + "</u></h3><ul>";
          for (NewsArticle article : articles) {
            content += "<li>" + article.getHtml() + "</li>";
          }
          content += "</ul>";
        }
      }
    }

    return content;
  }


  /**
   * Gets the list of articles as an HTML document.
   * @param subscriptions The users current subscriptions.
   * @return The message content as an HTML document.
   */
  private static String getHtmlContent(ArrayList<String> subscriptions) {

    String content = "<h3>Aloha,<br><br>Here are the news articles you've requested:</h3>";
    String header = "";
    ArrayList<NewsArticle> articles = null;

    for (String s : subscriptions) {
      switch (s) {
        case "hsaBreaking":
          header = "Honolulu Star Advertiser: Breaking News";
          articles = HonoluluStarAdvertiser.getBreakingArticles();
          break;
        case "hsaPopular":
          header = "Honolulu Star Advertiser: Popular Stories";
          articles = HonoluluStarAdvertiser.getPopularArticles();
          break;
        case "hsaSports":
          header = "Honolulu Star Advertiser: Sports";
          articles = HonoluluStarAdvertiser.getSportsArticles();
          break;
        case "mnBreaking":
          header = "Maui News: Breaking News";
          articles = MauiNews.getBreakingNewsArticles();
          break;
        case "mnBusiness":
          header = "Maui News: Business News";
          articles = MauiNews.getBusinessNewsArticles();
          break;
        case "mnHawaii":
          header = "Maui News: Hawai'i News";
          articles = MauiNews.getHawaiiNewsArticles();
          break;
        case "mnLocal":
          header = "Maui News: Local News";
          articles = MauiNews.getLocalNewsArticles();
          break;
        case "cbPopular":
          header = "Civil Beat: Popular News";
          articles = CivilBeat.getPopularArticles();
          break;
        case "cbHonolulu":
          header = "Civil Beat: Honolulu News";
          articles = CivilBeat.getHonoluluArticles();
          break;
        case "cbHawaii":
          header = "Civil Beat: Hawaii News";
          articles = CivilBeat.getHawaiiArticles();
          break;
        case "cbEducation":
          header = "Civil Beat: Education News";
          articles = CivilBeat.getEducationArticles();
          break;
        case "cbPolitics":
          header = "Civil Beat: Politics News";
          articles = CivilBeat.getPoliticsArticles();
          break;
        case "cbEnergyAndEnvironment":
          header = "Civil Beat: Energy and Environment News";
          articles = CivilBeat.getEnergyAndEnvironmentArticles();
          break;
        case "cbDevelopment":
          header = "Civil Beat: Development News";
          articles = CivilBeat.getDevelopmentArticles();
          break;
        default:
          break;
      }

      if (articles.size() > 0) {
        content += "<h3>" + header + "</h3><ul>";
        for (NewsArticle article : articles) {
          content += "<li>" + article.getHtml() + "</li>";
        }
        content += "</ul>";
      }

    }
    return "<html>" + content + "</html>";

  }

  /**
   * Gets the list of articles formatted as simple text.
   * @param subscriptions The users current subscriptions.
   * @return The message content in simple text.
   */
  private static String getSmsContent(ArrayList<String> subscriptions) {

    String content = "Aloha, Here are the news articles you've requested: ";
    String header = "";
    ArrayList<NewsArticle> articles = null;

    for (String s : subscriptions) {
      switch (s) {
        case "hsaBreaking":
          header = "Honolulu Star Advertiser: Breaking News";
          articles = HonoluluStarAdvertiser.getBreakingArticles();
          break;
        case "hsaPopular":
          header = "Honolulu Star Advertiser: Popular Stories";
          articles = HonoluluStarAdvertiser.getPopularArticles();
          break;
        case "hsaSports":
          header = "Honolulu Star Advertiser: Sports";
          articles = HonoluluStarAdvertiser.getSportsArticles();
          break;
        case "mnBreaking":
          header = "Maui News: Breaking News";
          articles = MauiNews.getBreakingNewsArticles();
          break;
        case "mnBusiness":
          header = "Maui News: Business News";
          articles = MauiNews.getBusinessNewsArticles();
          break;
        case "mnHawaii":
          header = "Maui News: Hawai'i News";
          articles = MauiNews.getHawaiiNewsArticles();
          break;
        case "mnLocal":
          header = "Maui News: Local News";
          articles = MauiNews.getLocalNewsArticles();
          break;
        case "cbPopular":
          header = "Civil Beat: Popular News";
          articles = CivilBeat.getPopularArticles();
          break;
        case "cbHonolulu":
          header = "Civil Beat: Honolulu News";
          articles = CivilBeat.getHonoluluArticles();
          break;
        case "cbHawaii":
          header = "Civil Beat: Hawaii News";
          articles = CivilBeat.getHawaiiArticles();
          break;
        case "cbEducation":
          header = "Civil Beat: Education News";
          articles = CivilBeat.getEducationArticles();
          break;
        case "cbPolitics":
          header = "Civil Beat: Politics News";
          articles = CivilBeat.getPoliticsArticles();
          break;
        case "cbEnergyAndEnvironment":
          header = "Civil Beat: Energy and Environment News";
          articles = CivilBeat.getEnergyAndEnvironmentArticles();
          break;
        case "cbDevelopment":
          header = "Civil Beat: Development News";
          articles = CivilBeat.getDevelopmentArticles();
          break;
        default:
          break;
      }

      if (articles.size() > 0) {
        content += header + "\n";
        for (NewsArticle article : articles) {
          content += article.getSms();
        }
        content += "\n";
      }

    }
    return content;

  }


}
