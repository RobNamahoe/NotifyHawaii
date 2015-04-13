package models;

/**
 * Representation of a News Story.
 */
public class NewsArticle {

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
