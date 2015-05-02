package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Representation of a News Story.
 */
@Entity
public class NewsArticle extends Model {

  @Id
  private long id;

  private String url = "";
  private String title = "";
  private String summary = "";

  /**
   * Construct a new instance of a News Article with the specified values.
   * @param url The articles url.
   * @param title The articles title.
   * @param summary The articles summary.
   */
  public NewsArticle(String url, String title, String summary) {
    this.url = url.trim();
    this.title = title.trim();
    this.summary = summary.trim();
  }

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, NewsArticle> find() {
    return new Finder<Long, NewsArticle>(Long.class, NewsArticle.class);
  }

  /**
   * Get the article url.
   * @return The url to the article.
   */
  public String getUrl() {
    return this.url;
  }

  /**
   * Get the article title.
   * @return The article title.
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Get the article summary.
   * @return The article summary.
   */
  public String getSummary() {
    return this.summary;
  }


  /**
   * Gets the id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets the id.
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Sets the url.
   * @param url The url.
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * Sets the title.
   * @param title The title.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Sets the summary.
   * @param summary The summary.
   */
  public void setSummary(String summary) {
    this.summary = summary;
  }

  /**
   * Gets the HTML representation of the article.
   * @return The HTML representation of the article.
   */
  public String getHtml() {
    String content = "<a href=\"" + this.url + "\">" + this.title + "</a>"; //<br>" + this.summary;
    content += (this.summary.length() > 0) ? "<br>" + this.summary : "";
    return content;
  }

  /**
   * Gets the SMS representation of the article.
   * @return The SMS representation of the article.
   */
  public String getSms() {
    return this.title + " (" + this.url + ")";
  }

}
