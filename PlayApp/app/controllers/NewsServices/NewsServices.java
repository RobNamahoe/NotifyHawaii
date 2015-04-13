package controllers.NewsServices;

import controllers.Communication.SendEmail;
import models.NewsArticle;
import models.NewsServicesSubscription;
import models.User;

import java.util.ArrayList;

/**
 * A class the executes the News Services services.
 */
public class NewsServices {

  /**
   *
   * @param user
   * @param subscription
   */
  public static void execute(User user, NewsServicesSubscription subscription) {

    String content = "";

    ArrayList<String> list = subscription.getEmailSubscriptions();

    if (list.size() > 0 ) {
      content = getContent(list, "html");
      SendEmail.sendEmail(user.getEmail(), "News Services", content);
    }

    list = subscription.getTextSubscriptions();

    if (list.size() > 0) {
      content = getContent(list, "non-html");
    }

  }



  private static String getContent(ArrayList<String> subscriptions, String messageType) {

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



}
