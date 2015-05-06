import models.Carrier;
import models.CarrierDB;
import models.NewsArticle;
import models.UserInfo;
import models.UserInfoDB;
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

    //ArrayList<NewsArticle> list;

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

    // Initialize the database

    /*
    addCarriers();

    if (!UserInfoDB.isUser("admin@notifyhawaii.com")) {
      Carrier carrier = Carrier.find().where().eq("name", "AT&T Wireless").findUnique();

    UserInfo user = new UserInfo("Notify", "Hawaii", "8085551234", "admin@notifyhawaii.com", carrier, "password");
    UserInfoDB.addUser(user);

      //NewsServicesFormData formData = new NewsServicesFormData();
    //  NewsServicesSubscription data = new NewsServicesSubscription(formData);
     // NewsServiceSubscriptionDB.addSubscription(1, data);

    }
    */
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

  /**
   * Initializes the database with a list of carriers.
   */
  private void addCarriers() {
    if (CarrierDB.getCount() == 0) {
      CarrierDB.addCarrier("Alltel Wireless", "@text.wireless.alltel.com");
      CarrierDB.addCarrier("AT&T Wireless", "@txt.att.net");
      CarrierDB.addCarrier("AT&T Mobility (formerly Cingular)", "@cingularme.com");
      CarrierDB.addCarrier("Boost Mobile", "@myboostmobile.com");
      CarrierDB.addCarrier("Cricket", "@sms.mycricket.com");
      CarrierDB.addCarrier("Metro PCS", "@mymetropcs.com");
      CarrierDB.addCarrier("Sprint (PCS)", "@messaging.sprintpcs.com");
      CarrierDB.addCarrier("Sprint (Nextel)", "@page.nextel.com");
      CarrierDB.addCarrier("Straight Talk", "@VTEXT.COM");
      CarrierDB.addCarrier("T-Mobile", "@tmomail.net");
      CarrierDB.addCarrier("U.S. Cellular", "@email.uscc.net");
      CarrierDB.addCarrier("Verizon", "@vtext.com");
    }
  }


}
