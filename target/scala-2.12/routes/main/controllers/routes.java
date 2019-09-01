// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mohit/Downloads/Assignment1/Assignment1/conf/routes
// @DATE:Tue Jul 31 13:07:54 EDT 2018

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLocationController LocationController = new controllers.ReverseLocationController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserProfileController UserProfileController = new controllers.ReverseUserProfileController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHomeController HomeController = new controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSearchTweetWordController SearchTweetWordController = new controllers.ReverseSearchTweetWordController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseHashTagController HashTagController = new controllers.ReverseHashTagController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLocationController LocationController = new controllers.javascript.ReverseLocationController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserProfileController UserProfileController = new controllers.javascript.ReverseUserProfileController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHomeController HomeController = new controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSearchTweetWordController SearchTweetWordController = new controllers.javascript.ReverseSearchTweetWordController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseHashTagController HashTagController = new controllers.javascript.ReverseHashTagController(RoutesPrefix.byNamePrefix());
  }

}
