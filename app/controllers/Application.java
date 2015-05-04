package controllers;

import controllers.NewsServices.NewsServices;
import models.CarrierDB;
import models.NewsServiceSubscriptionDB;
import models.NewsServicesSubscription;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import views.formdata.LoginFormData;
import views.formdata.NewsServicesFormData;
import views.formdata.RegistrationFormData;
import views.formdata.UserFormData;
import views.html.Blogs;
import views.html.Commute;
import views.html.Index;
import views.html.Account;
import views.html.Login;
import views.html.News;
import views.html.Services;

import java.util.List;

/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Provides the Login page (only to unauthenticated users).
   * @return The Login page.
   */
  public static Result login() {
    if (Secured.isLoggedIn(ctx())) {
      return redirect(routes.Application.services());
    }
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class);
    Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), "login",
        CarrierDB.getCarrierMap(), loginFormData, regFormData));
  }

  /**
   * Provides the registration page (only to unauthenticated users).
   * @return The Registration page.
   */
  public static Result registration() {
    if (Secured.isLoggedIn(ctx())) {
      return redirect(routes.Application.services());
    }
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class);
    Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), "registration",
        CarrierDB.getCarrierMap(), loginFormData, regFormData));
  }


  /**
   * Logs out (only for authenticated users) and returns them to the Index page.
   * @return A redirect to the Index page.
   */
  @Security.Authenticated(Secured.class)
  public static Result logout() {
    session().clear();
    return redirect(routes.Application.index());
  }

  /**
   * Returns the users account page.
   * @return The Account page.
   */
  @Security.Authenticated(Secured.class)
  public static Result account() {
    String userEmail = Secured.getUser(ctx());

    // Get a list of current news subscriptions for the current user
    List<NewsServicesSubscription> newsSubscriptions = NewsServiceSubscriptionDB.getSubscriptions(userEmail);

    UserFormData data = new UserFormData(UserInfoDB.getUser(userEmail));
    Form<UserFormData> formData = Form.form(UserFormData.class).fill(data);
    return ok(Account.render("Welcome to Your Account Page.", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
        formData, CarrierDB.getCarrierMap(data.carrier), newsSubscriptions));
  }

  /**
   * Returns the Services page.
   * @return The Services page.
   */
  @Security.Authenticated(Secured.class)
  public static Result services() {
    return ok(Services.render("Current Services", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Returns the Blogs services page.
   * @return The Blogs services page.
   */
  @Security.Authenticated(Secured.class)
  public static Result blogs() {
    return ok(Blogs.render("Blog Services", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }

  /**
   * Returns the Commute services page.
   * @return The Commute services page.
   */
  @Security.Authenticated(Secured.class)
  public static Result commute() {
    return ok(Commute.render("Commute Services", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx())));
  }







  /**
   * Returns the News services page.
   * @return The News services page.
   */
  @Security.Authenticated(Secured.class)
  public static Result news() {

    // Get a list of current news subscriptions for the current user
    String userEmail = Secured.getUser(ctx());
    List<NewsServicesSubscription> subscriptions = NewsServiceSubscriptionDB.getSubscriptions(userEmail);

    NewsServicesFormData data = new NewsServicesFormData(subscriptions);
    Form<NewsServicesFormData> formData = Form.form(NewsServicesFormData.class).fill(data);

    return ok(News.render("News Services", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), formData));
  }

  /**
   * Update the current users News subscriptions.
   * @return Redirect to the news page.
   */
  @Security.Authenticated(Secured.class)
  public static Result updateNewsSubscriptions() {
    Form<NewsServicesFormData> formData = Form.form(NewsServicesFormData.class).bindFromRequest();
    NewsServicesFormData data = formData.get();
    String userEmail = Secured.getUser(ctx());
    NewsServiceSubscriptionDB.updateUserSubscription(userEmail, data);
    return redirect(routes.Application.news());
  }

  /**
   * Deletes the news subscription with the specified id.
   * @param id The id of the subscription to delete.
   * @return Redirect to the account page.
   */
  public static Result deleteNewsSubscription(long id) {
    NewsServiceSubscriptionDB.deleteSubscription(id);
    return redirect(routes.Application.account());
  }

  /**
   * Updates the current users contact information.
   * @return The Account page with updated information.
   */
  @Security.Authenticated(Secured.class)
  public static Result updateUserInfo() {

    NewsServices.execute();

    // Get a list of current news subscriptions for the current user
    String userEmail = Secured.getUser(ctx());
    List<NewsServicesSubscription> newsSubscriptions = NewsServiceSubscriptionDB.getSubscriptions(userEmail);

    Form<UserFormData> userForm = Form.form(UserFormData.class).bindFromRequest();
    if (userForm.hasErrors()) {
      return badRequest(Account.render("Account", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          userForm, CarrierDB.getCarrierMap(), newsSubscriptions));
    }
    else {
      UserFormData formData = userForm.get();
      UserInfoDB.updateUser(formData);
      return ok(Account.render("Account", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          userForm, CarrierDB.getCarrierMap(formData.carrier), newsSubscriptions));
    }
  }

  /**
   * Processes a login form submission from an unauthenticated user.
   * First we bind the HTTP POST data to an instance of LoginFormData.
   * The binding process will invoke the LoginFormData.validate() method.
   * If errors are found, re-render the page, displaying the error data.
   * If errors not found, render the page with the good data.
   * @return The index page with the results of validation.
   */
  public static Result postLogin() {

    // Get the submitted form data from the request object, and run validation.
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class).bindFromRequest();
    Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);

    if (loginFormData.hasErrors()) {
      flash("error", "Login credentials are not valid.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          "login", CarrierDB.getCarrierMap(), loginFormData, regFormData));
    }
    else {
      // email/password OK, so now we set the session variable and only go to authenticated pages.
      session().clear();
      session("email", loginFormData.get().email);
      return redirect(routes.Application.services());
    }
  }

  /**
   * Processes a registration form submission from a new user.
   * If errors are found, re-render the page, displaying the error data.
   * If errors not found, render the page with the good data.
   * @return The services page if successful, registration page if not.
   */
  public static Result postRegistration() {
    // Get the submitted form data from the request object, and run validation.
    Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class).bindFromRequest();
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class);

    if (regFormData.hasErrors()) {
      flash("regerror", "* Please correct errors.");
      return badRequest(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()),
          "registration", CarrierDB.getCarrierMap(), loginFormData, regFormData));
    }
    else {
      // registration info OK, so now we set the session variable and create the user in the database.
      session().clear();
      RegistrationFormData data = regFormData.get();
      session("email", data.regEmail);

      UserInfo newUser = new UserInfo(data.regFirstName, data.regLastName, data.regPhone, data.regEmail,
          CarrierDB.getCarrier(data.regCarrier), data.regPassword);
      UserInfoDB.addUser(newUser);

      return redirect(routes.Application.services());
    }


  }



}
