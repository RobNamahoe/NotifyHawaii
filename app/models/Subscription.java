package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * A class to manage subscription data.
 */
@Entity
public class Subscription extends Model {

  @Id
  private long id;

  private String type;
  private String name;

  @ManyToMany(mappedBy = "subscriptions")
  private List<UserInfo> users = new ArrayList<>();





}
