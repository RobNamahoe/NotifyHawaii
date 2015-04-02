package controllers;

import play.mvc.Controller;
import play.mvc.Result;
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
    return ok(Account.render("Welcome to Your Account Page."));
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
    return ok(News.render("News Services"));
  }

}
