package models;

import com.avaje.ebean.annotation.CreatedTimestamp;
import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Representation of a News Story.
 */
@Entity
public class NewsArticle extends Model {

  @Id
  private long id;

  private String topic = "";
  private String provider = "";
  private String url = "";
  private String title = "";
  private String summary = "";
  private String articleDate = "";

  @CreatedTimestamp
  private Timestamp timestamp;

  /**
   * Construct a new instance of a News Article with the specified values.
   * @param topic The article topic.
   * @param provider The provider of the article.
   * @param url The articles url.
   * @param title The articles title.
   * @param summary The articles summary.
   * @param articleDate The date the article was posted.
   */
  public NewsArticle(String topic, String provider, String url, String title, String summary, String articleDate) {
    this.topic = topic;
    this.provider = provider;
    this.url = url.trim();
    this.title = title.trim();
    this.summary = (summary.length() > 255) ? summary.substring(0, 240) : summary;
    this.articleDate = articleDate;
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
   * Gets the article topic (Breaking, Popular, Sports, etc).
   * @return The article topic.
   */
  public String getTopic() {
    return topic;
  }

  /**
   * Sets the article topic.
   * @param topic The topic.
   */
  public void setTopic(String topic) {
    this.topic = topic;
  }

  /**
   * Gets the HTML representation of the article.
   * @return The HTML representation of the article.
   */
  public String getHtml() {
    String content = "<strong><a href=\"" + this.url + "\">" + this.title + "</a></strong>"; //<br>" + this.summary;
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

  /**
   * Gets the date and time the article was posted.
   * @return The date and time the article was posted.
   */
  public String getArticleDate() {
    return articleDate;
  }

  /**
   * Sets the date and time the article was posted.
   * @param articleDate The date and time the article was posted.
   */
  public void setArticleDate(String articleDate) {
    this.articleDate = articleDate;
  }

  /**
   * Gets the provider of the article.
   * @return The provider.
   */
  public String getProvider() {
    return provider;
  }

  /**
   * Sets the provider of the article.
   * @param provider The provider.
   */
  public void setProvider(String provider) {
    this.provider = provider;
  }

  /**
   * Gets the timestamp (time the article was added to the database).
   * @return The timestamp.
   */
  public Timestamp getTimestamp() {
    return timestamp;
  }

  /**
   * Sets the timestamp (time the article was added to the database).
   * @param timestamp The timestamp.
   */
  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }
}
