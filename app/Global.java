import models.NewsArticle;
import models.NewsServiceSubscriptionDB;
import models.NewsServicesSubscription;
import models.User;
import models.UserDB;
import play.Application;
import play.GlobalSettings;
import views.formdata.NewsServicesFormData;

import java.util.ArrayList;

/**
 * Global settings for the Play application.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);

    ArrayList<NewsArticle> list;

    //SendEmail.testmail("", "", "");

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

    User user = new User(1, "Rob", "Namahoe", "8083432159", "rnamahoe@hawaii.edu", "AT&T Wireless");
    UserDB.addUser(user);

    NewsServicesFormData formData = new NewsServicesFormData();
    NewsServicesSubscription data = new NewsServicesSubscription(formData);
    NewsServiceSubscriptionDB.addSubscription(1, data);

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
