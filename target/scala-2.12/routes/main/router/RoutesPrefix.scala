// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/mohit/Downloads/Assignment1/Assignment1/conf/routes
// @DATE:Tue Jul 31 13:07:54 EDT 2018


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
