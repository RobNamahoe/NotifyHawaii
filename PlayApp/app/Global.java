import controllers.Communication.SendEmail;
import models.NewsArticle;
import models.User;
import models.UserDB;
import play.Application;
import play.GlobalSettings;

import java.util.ArrayList;

/**
 * Global settings for the Play application.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);

    ArrayList<NewsArticle> list;

    SendEmail.testmail("", "", "");

    //HonoluluStarAdvertiser.getBreakingArticles();
    //HonoluluStarAdvertiser.getPopularArticles();
    //HonoluluStarAdvertiser.getSportsArticles();

    //list = MauiNews.getLocalNewsArticles();
    //list = MauiNews.getBreakingNewsArticles();
    //list = MauiNews.getBusinessNewsArticles();

    //list = CivilBeat.getDevelopmentArticles();
    //list = CivilBeat.getEducationArticles();
    //list = CivilBeat.getEnergyAndEnvironmentArticles();
    //list = CivilBeat.getHawaiiArticles();
    //list = CivilBeat.getHonoluluArticles();
    //list = CivilBeat.getPoliticsArticles();
    //list = CivilBeat.getPopularArticles();

    //printList(list);

    User user = new User(1, "Rob", "Namahoe", "808-343-2159", "rnamahoe@hawaii.edu", "Verizon");
    UserDB.addUser(user);
  }

  /**
   * Prints the contents of the supplied list.
   * @param articles The list to print.
   */
  private void printList(ArrayList<NewsArticle> articles) {
    for (NewsArticle article : articles) {
      System.out.println(article.getUrl());
      System.out.println(article.getTitle());
      System.out.println(article.getSummary());
      System.out.println("------------------");
    }
  }

}
