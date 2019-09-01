// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mohit/Downloads/Assignment1/Assignment1/conf/routes
// @DATE:Tue Jul 31 13:07:54 EDT 2018

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:15
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:15
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseLocationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def searchTweetsByLocation: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.LocationController.searchTweetsByLocation",
      """
        function(latitude0,longitude1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchTweetsByLocation/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("latitude", latitude0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("longitude", longitude1))})
        }
      """
    )
  
  }

  // @LINE:11
  class ReverseUserProfileController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def getUserProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UserProfileController.getUserProfile",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUserProfile/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def searchTweets: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.searchTweets",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchTweets/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
    // @LINE:6
    def welcomeScreen: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.welcomeScreen",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseSearchTweetWordController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def searchTweetDistinctWordCount: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.SearchTweetWordController.searchTweetDistinctWordCount",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchTweetDistinctWordCount/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseHashTagController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def searchTweetsByHashTag: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HashTagController.searchTweetsByHashTag",
      """
        function(searchKey0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchTweetsByHashTag/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("searchKey", searchKey0))})
        }
      """
    )
  
  }


}
