package controllers;

import controllers.NewsServices.NewsServices;
import models.NewsServiceSubscriptionDB;
import models.NewsServicesSubscription;
import models.UserDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.NewsServicesFormData;
import views.formdata.ServiceProviders;
import views.formdata.UserFormData;
import views.html.Blogs;
import views.html.Commute;
import views.html.Index;
import views.html.Account;
import views.html.News;
import views.html.Services;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  private static long currentUserId = 1;

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page"));
  }

  /**
   * Returns the users account page.
   * @return The Account page.
   */
  public static Result account() {
    UserFormData data = new UserFormData(UserDB.getUser(currentUserId));
    Form<UserFormData> formData = Form.form(UserFormData.class).fill(data);
    return ok(Account.render("Welcome to Your Account Page.", formData, ServiceProviders.getCarriers(data.carrier)));
  }

  /**
   * Returns the Services page.
   * @return The Services page.
   */
  public static Result services() {
    return ok(Services.render("Current Services"));
  }

  /**
   * Returns the Blogs services page.
   * @return The Blogs services page.
   */
  public static Result blogs() {
    return ok(Blogs.render("Blog Services"));
  }

  /**
   * Returns the Commute services page.
   * @return The Commute services page.
   */
  public static Result commute() {
    return ok(Commute.render("Commute Services"));
  }

  /**
   * Returns the News services page.
   * @return The News services page.
   */
  public static Result news() {
    NewsServicesFormData data = (currentUserId == 0) ? new NewsServicesFormData() :
        new NewsServicesFormData(NewsServiceSubscriptionDB.getSubscription(currentUserId));
    Form<NewsServicesFormData> formData = Form.form(NewsServicesFormData.class).fill(data);

    NewsServices.execute(UserDB.getUser(currentUserId), NewsServiceSubscriptionDB.getSubscription(currentUserId));

    return ok(News.render("News Services", formData, NewsServiceSubscriptionDB.getSubscription(currentUserId)));
  }

  /**
   * Update the current users News subscriptions.
   * @return Redirect to the news page.
   */
  public static Result updateNewsSubscriptions() {
    Form<NewsServicesFormData> formData = Form.form(NewsServicesFormData.class).bindFromRequest();
    NewsServicesFormData data = formData.get();
    NewsServiceSubscriptionDB.addSubscription(currentUserId, new NewsServicesSubscription(data));
    return redirect(routes.Application.news());
  }

  /**
   * Updates the current users contact information.
   * @return The Account page with updated information.
   */
  public static Result updateUserInfo() {

    Form<UserFormData> userForm = Form.form(UserFormData.class).bindFromRequest();

    if (userForm.hasErrors()) {
      return badRequest(Account.render("Account", userForm, ServiceProviders.getCarriers()));
    }
    else {
      UserFormData formData = userForm.get();
      UserDB.updateUser(formData);
      return ok(Account.render("Account", userForm, ServiceProviders.getCarriers(formData.carrier)));
    }

  }

}
