// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mohit/Downloads/Assignment1/Assignment1/conf/routes
// @DATE:Tue Jul 31 13:07:54 EDT 2018

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_1: controllers.HomeController,
  // @LINE:8
  LocationController_5: controllers.LocationController,
  // @LINE:9
  HashTagController_0: controllers.HashTagController,
  // @LINE:10
  SearchTweetWordController_3: controllers.SearchTweetWordController,
  // @LINE:11
  UserProfileController_2: controllers.UserProfileController,
  // @LINE:15
  Assets_4: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_1: controllers.HomeController,
    // @LINE:8
    LocationController_5: controllers.LocationController,
    // @LINE:9
    HashTagController_0: controllers.HashTagController,
    // @LINE:10
    SearchTweetWordController_3: controllers.SearchTweetWordController,
    // @LINE:11
    UserProfileController_2: controllers.UserProfileController,
    // @LINE:15
    Assets_4: controllers.Assets
  ) = this(errorHandler, HomeController_1, LocationController_5, HashTagController_0, SearchTweetWordController_3, UserProfileController_2, Assets_4, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_1, LocationController_5, HashTagController_0, SearchTweetWordController_3, UserProfileController_2, Assets_4, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.HomeController.welcomeScreen"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchTweets/""" + "$" + """searchKey<[^/]+>""", """controllers.HomeController.searchTweets(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchTweetsByLocation/""" + "$" + """latitude<[^/]+>/""" + "$" + """longitude<[^/]+>""", """controllers.LocationController.searchTweetsByLocation(latitude:String, longitude:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchTweetsByHashTag/""" + "$" + """searchKey<[^/]+>""", """controllers.HashTagController.searchTweetsByHashTag(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchTweetDistinctWordCount/""" + "$" + """searchKey<[^/]+>""", """controllers.SearchTweetWordController.searchTweetDistinctWordCount(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUserProfile/""" + "$" + """searchKey<[^/]+>""", """controllers.UserProfileController.getUserProfile(searchKey:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_welcomeScreen0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_HomeController_welcomeScreen0_invoker = createInvoker(
    HomeController_1.welcomeScreen,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "welcomeScreen",
      Nil,
      "GET",
      this.prefix + """home""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_searchTweets1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchTweets/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HomeController_searchTweets1_invoker = createInvoker(
    HomeController_1.searchTweets(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "searchTweets",
      Seq(classOf[String]),
      "GET",
      this.prefix + """searchTweets/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_LocationController_searchTweetsByLocation2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchTweetsByLocation/"), DynamicPart("latitude", """[^/]+""",true), StaticPart("/"), DynamicPart("longitude", """[^/]+""",true)))
  )
  private[this] lazy val controllers_LocationController_searchTweetsByLocation2_invoker = createInvoker(
    LocationController_5.searchTweetsByLocation(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.LocationController",
      "searchTweetsByLocation",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """searchTweetsByLocation/""" + "$" + """latitude<[^/]+>/""" + "$" + """longitude<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_HashTagController_searchTweetsByHashTag3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchTweetsByHashTag/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_HashTagController_searchTweetsByHashTag3_invoker = createInvoker(
    HashTagController_0.searchTweetsByHashTag(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HashTagController",
      "searchTweetsByHashTag",
      Seq(classOf[String]),
      "GET",
      this.prefix + """searchTweetsByHashTag/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_SearchTweetWordController_searchTweetDistinctWordCount4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchTweetDistinctWordCount/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_SearchTweetWordController_searchTweetDistinctWordCount4_invoker = createInvoker(
    SearchTweetWordController_3.searchTweetDistinctWordCount(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.SearchTweetWordController",
      "searchTweetDistinctWordCount",
      Seq(classOf[String]),
      "GET",
      this.prefix + """searchTweetDistinctWordCount/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UserProfileController_getUserProfile5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUserProfile/"), DynamicPart("searchKey", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UserProfileController_getUserProfile5_invoker = createInvoker(
    UserProfileController_2.getUserProfile(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UserProfileController",
      "getUserProfile",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getUserProfile/""" + "$" + """searchKey<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_4.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_welcomeScreen0_route(params@_) =>
      call { 
        controllers_HomeController_welcomeScreen0_invoker.call(HomeController_1.welcomeScreen)
      }
  
    // @LINE:7
    case controllers_HomeController_searchTweets1_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_HomeController_searchTweets1_invoker.call(HomeController_1.searchTweets(searchKey))
      }
  
    // @LINE:8
    case controllers_LocationController_searchTweetsByLocation2_route(params@_) =>
      call(params.fromPath[String]("latitude", None), params.fromPath[String]("longitude", None)) { (latitude, longitude) =>
        controllers_LocationController_searchTweetsByLocation2_invoker.call(LocationController_5.searchTweetsByLocation(latitude, longitude))
      }
  
    // @LINE:9
    case controllers_HashTagController_searchTweetsByHashTag3_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_HashTagController_searchTweetsByHashTag3_invoker.call(HashTagController_0.searchTweetsByHashTag(searchKey))
      }
  
    // @LINE:10
    case controllers_SearchTweetWordController_searchTweetDistinctWordCount4_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_SearchTweetWordController_searchTweetDistinctWordCount4_invoker.call(SearchTweetWordController_3.searchTweetDistinctWordCount(searchKey))
      }
  
    // @LINE:11
    case controllers_UserProfileController_getUserProfile5_route(params@_) =>
      call(params.fromPath[String]("searchKey", None)) { (searchKey) =>
        controllers_UserProfileController_getUserProfile5_invoker.call(UserProfileController_2.getUserProfile(searchKey))
      }
  
    // @LINE:15
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_4.versioned(path, file))
      }
  }
}
