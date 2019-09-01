// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mohit/Downloads/Assignment1/Assignment1/conf/routes
// @DATE:Tue Jul 31 13:07:54 EDT 2018

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }

  // @LINE:8
  class ReverseLocationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def searchTweetsByLocation(latitude:String, longitude:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchTweetsByLocation/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("latitude", latitude)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("longitude", longitude)))
    }
  
  }

  // @LINE:11
  class ReverseUserProfileController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getUserProfile(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUserProfile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def searchTweets(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchTweets/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
    // @LINE:6
    def welcomeScreen(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "home")
    }
  
  }

  // @LINE:10
  class ReverseSearchTweetWordController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def searchTweetDistinctWordCount(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchTweetDistinctWordCount/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
  }

  // @LINE:9
  class ReverseHashTagController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def searchTweetsByHashTag(searchKey:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchTweetsByHashTag/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("searchKey", searchKey)))
    }
  
  }


}
