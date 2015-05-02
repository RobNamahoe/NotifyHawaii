package controllers;

import models.CarrierDB;
import models.NewsServiceSubscriptionDB;
import models.NewsServicesSubscription;
import models.UserInfo;
import models.UserInfoDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.LoginFormData;
import views.formdata.NewsServicesFormData;
import views.formdata.RegistrationFormData;
import views.formdata.ServiceProviders;
import views.formdata.UserFormData;
import views.html.Blogs;
import views.html.Commute;
import views.html.Index;
import views.html.Account;
import views.html.Login;
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
   * Provides the Login page (only to unauthenticated users).
   * @return The Login page.
   */
  public static Result login() {
    Form<LoginFormData> loginFormData = Form.form(LoginFormData.class);
    Form<RegistrationFormData> regFormData = Form.form(RegistrationFormData.class);
    return ok(Login.render("Login", Secured.isLoggedIn(ctx()), Secured.getUserInfo(ctx()), "login",
        CarrierDB.getCarrierMap(), loginFormData, regFormData));
  }

  /**
   * Returns the users account page.
   * @return The Account page.
   */
  public static Result account() {
    UserFormData data = new UserFormData(UserInfoDB.getUser(currentUserId));
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
    NewsServicesFormData data = (currentUserId == 0) ? new NewsServicesFormData()
        : new NewsServicesFormData(NewsServiceSubscriptionDB.getSubscription(currentUserId));
    Form<NewsServicesFormData> formData = Form.form(NewsServicesFormData.class).fill(data);

    //NewsServices.execute(UserDB.getUser(currentUserId), NewsServiceSubscriptionDB.getSubscription(currentUserId));

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
      UserInfoDB.updateUser(formData);
      return ok(Account.render("Account", userForm, ServiceProviders.getCarriers(formData.carrier)));
    }
  }

  // TODO

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
      System.out.println("Authentication OK: " + loginFormData.get().email + ", " + loginFormData.get().password);
      return redirect(routes.Application.index());

    }
  }

  /**
   * Processes a registration form submission from a new user.
   * If errors are found, re-render the page, displaying the error data.
   * If errors not found, render the page with the good data.
   * @return The services page if successful, registration page if not.
   */
  public static Result postRegistration() {
    System.out.println("Post Login method called from post Registration");


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

      return redirect(routes.Application.index());
    }


  }



}
