
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import play.data._
import play.core.j.PlayFormsMagicForJava._

object homePage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.1*/("""<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
 	    <meta name="viewport" content="width=device-width, initial-scale=1">
 	    <meta http-equiv="Content-Security-Policy" content="default-src *;img-src *;">
		<title>Tweets Application</title>
		<script type="text/javascript" src=""""),_display_(/*8.40*/routes/*8.46*/.Assets.versioned("javascripts/lib/angular.min.js")),format.raw/*8.97*/(""""></script>
		<script type="text/javascript" src=""""),_display_(/*9.40*/routes/*9.46*/.Assets.versioned("javascripts/lib/angular-ui-bootstrap-modal.js")),format.raw/*9.112*/(""""></script>
		<link rel="stylesheet" href=""""),_display_(/*10.33*/routes/*10.39*/.Assets.versioned("stylesheets/bootstrap.min.css")),format.raw/*10.89*/("""">
		<link rel="stylesheet" href=""""),_display_(/*11.33*/routes/*11.39*/.Assets.versioned("stylesheets/common-style.css")),format.raw/*11.88*/("""">
		<script type="text/javascript" src=""""),_display_(/*12.40*/routes/*12.46*/.Assets.versioned("javascripts/lib/jquery-3.3.1.min.js")),format.raw/*12.102*/(""""></script>
		<script type="text/javascript" src=""""),_display_(/*13.40*/routes/*13.46*/.Assets.versioned("javascripts/lib/bootstrap.min.js")),format.raw/*13.99*/(""""></script>
		<script type="text/javascript" src=""""),_display_(/*14.40*/routes/*14.46*/.Assets.versioned("javascripts/search/searchApp.js")),format.raw/*14.98*/(""""></script>
		<script type="text/javascript" src=""""),_display_(/*15.40*/routes/*15.46*/.Assets.versioned("javascripts/search/searchController.js")),format.raw/*15.105*/(""""></script>
		<script type="text/javascript" src=""""),_display_(/*16.40*/routes/*16.46*/.Assets.versioned("javascripts/search/searchService.js")),format.raw/*16.102*/(""""></script>

	</head>
	<body ng-app="searchTweets" >
		<div ng-controller="SearchController">
			<div class="container head-not-move">
				<div class="row">
					<div class="col-sm-12"><br></br></div>
			        <div class="col-sm-12">
			    		<h2 class="heading-center">Search Tweets</h2>
			            <div id="custom-search-input">
			                <div class="input-group col-sm-12">
			                    <input type="text" class="form-control input-lg" placeholder="enter search key" ng-model="searchKey" />
			                    <span class="input-group-btn">
			                        <button class="btn btn-info btn-lg" type="button" ng-click="searchTweets()">
			                        	<span>Search</span>
			                        </button>
			                    </span>
			                </div>
			            </div>
			        </div>
				</div>
			</div>
			<div class="container body-move">
				<div ng-repeat="(key,results) in allResults">
				<div class="searchHeading">
					<br></br>
					<caption>
						<a href="#" ng-click="$event.preventDefault(); openTweetWord(key)">"""),format.raw/*44.74*/("""{"""),format.raw/*44.75*/("""{"""),format.raw/*44.76*/("""key"""),format.raw/*44.79*/("""}"""),format.raw/*44.80*/("""}"""),format.raw/*44.81*/("""</a>&nbsp;
						<button ng-if="!results.showEmotion" class="btn btn-info btn-sm" ng-click="getTweetSentiment(key)" title="Get Emotion">Get Emotion</button>
						<span >"""),format.raw/*46.14*/("""{"""),format.raw/*46.15*/("""{"""),format.raw/*46.16*/("""results.emotion"""),format.raw/*46.31*/("""}"""),format.raw/*46.32*/("""}"""),format.raw/*46.33*/("""</span>
					</caption>
				</div>
				<table class="table table-stripped table-color">
					<thead>
						<tr>
							<th column="sr-column">S.No.</th>
							<th column="name-column">Name</th>
							<th column="location-column">Location</th>
							<th column="tweets-column">Tweet</th>
							<th column="hashtags-column">Hash Tags</th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat = "result in results.result">
							<td>"""),format.raw/*61.12*/("""{"""),format.raw/*61.13*/("""{"""),format.raw/*61.14*/("""$index+1"""),format.raw/*61.22*/("""}"""),format.raw/*61.23*/("""}"""),format.raw/*61.24*/("""</td>
							<td><a href="#" ng-click="$event.preventDefault(); openProfile(result.displayName)">"""),format.raw/*62.92*/("""{"""),format.raw/*62.93*/("""{"""),format.raw/*62.94*/("""result.name"""),format.raw/*62.105*/("""}"""),format.raw/*62.106*/("""}"""),format.raw/*62.107*/("""</a></td>
							<td>
								<div ng-if="result.showLocationLink">
									<a href="#" ng-click="$event.preventDefault(); openLocation(result.latitude,result.longitude,location)">"""),format.raw/*65.114*/("""{"""),format.raw/*65.115*/("""{"""),format.raw/*65.116*/("""result.location"""),format.raw/*65.131*/("""}"""),format.raw/*65.132*/("""}"""),format.raw/*65.133*/("""</a>
								</div>
								<div ng-if="!result.showLocationLink">
									<a class="linkDisabled" href="#" ng-click="$event.preventDefault(); openLocation(result.latitude,result.longitude,location)">"""),format.raw/*68.135*/("""{"""),format.raw/*68.136*/("""{"""),format.raw/*68.137*/("""result.location"""),format.raw/*68.152*/("""}"""),format.raw/*68.153*/("""}"""),format.raw/*68.154*/("""</a>
								</div>
							</td>
							<td>"""),format.raw/*71.12*/("""{"""),format.raw/*71.13*/("""{"""),format.raw/*71.14*/("""result.tweet"""),format.raw/*71.26*/("""}"""),format.raw/*71.27*/("""}"""),format.raw/*71.28*/("""</td>
							<td>
								<span ng-repeat="hashT in result.splitHashTags"><a href="#" ng-click="$event.preventDefault(); openHashTag(hashT)">"""),format.raw/*73.124*/("""{"""),format.raw/*73.125*/("""{"""),format.raw/*73.126*/("""hashT"""),format.raw/*73.131*/("""}"""),format.raw/*73.132*/("""}"""),format.raw/*73.133*/("""</a>&nbsp;&nbsp;&nbsp;</span>
							</td>
						</tr>
					</tbody>
				</table>
				</div>
			</div>
			
			 <div class="modal-color" modal="showUserProfileModal" close="cancel("USER_PROFILE")">
			      <div class="modal-header">
			          <h4>Profile For """),format.raw/*83.30*/("""{"""),format.raw/*83.31*/("""{"""),format.raw/*83.32*/("""userProfileQueryParam"""),format.raw/*83.53*/("""}"""),format.raw/*83.54*/("""}"""),format.raw/*83.55*/("""</h4>
			      </div>
			      <div class="modal-body">
			          <div class="user-profile">
			          	<p> Name: """),format.raw/*87.25*/("""{"""),format.raw/*87.26*/("""{"""),format.raw/*87.27*/("""userProfileQueryResult.userName"""),format.raw/*87.58*/("""}"""),format.raw/*87.59*/("""}"""),format.raw/*87.60*/("""</p><br>
			          	<img id="imgID" class="img-center" ng-src=""""),format.raw/*88.58*/("""{"""),format.raw/*88.59*/("""{"""),format.raw/*88.60*/("""userProfileQueryResult.userImageURL"""),format.raw/*88.95*/("""}"""),format.raw/*88.96*/("""}"""),format.raw/*88.97*/("""">
			          	<p> Display Name: """),format.raw/*89.33*/("""{"""),format.raw/*89.34*/("""{"""),format.raw/*89.35*/("""userProfileQueryResult.userScreenName"""),format.raw/*89.72*/("""}"""),format.raw/*89.73*/("""}"""),format.raw/*89.74*/("""<p><br>
			          	<p> Location: """),format.raw/*90.29*/("""{"""),format.raw/*90.30*/("""{"""),format.raw/*90.31*/("""userProfileQueryResult.userLocation"""),format.raw/*90.66*/("""}"""),format.raw/*90.67*/("""}"""),format.raw/*90.68*/("""<p><br>
			          	<p> Description: """),format.raw/*91.32*/("""{"""),format.raw/*91.33*/("""{"""),format.raw/*91.34*/("""userProfileQueryResult.userDescription"""),format.raw/*91.72*/("""}"""),format.raw/*91.73*/("""}"""),format.raw/*91.74*/("""<p><br>
			          	<p> Follower Count: """),format.raw/*92.35*/("""{"""),format.raw/*92.36*/("""{"""),format.raw/*92.37*/("""userProfileQueryResult.userFollowerCount"""),format.raw/*92.77*/("""}"""),format.raw/*92.78*/("""}"""),format.raw/*92.79*/("""<p><br>
			          	<p> Profile URL: """),format.raw/*93.32*/("""{"""),format.raw/*93.33*/("""{"""),format.raw/*93.34*/("""userProfileQueryResult.userProfileURL"""),format.raw/*93.71*/("""}"""),format.raw/*93.72*/("""}"""),format.raw/*93.73*/("""<p><br>
			          	<div ng-repeat="tweetTimeLine in userProfileQueryResult.splitTimelineTweets">
			          		<p>"""),format.raw/*95.19*/("""{"""),format.raw/*95.20*/("""{"""),format.raw/*95.21*/("""tweetTimeLine"""),format.raw/*95.34*/("""}"""),format.raw/*95.35*/("""}"""),format.raw/*95.36*/("""</p>
			          	</div>
			          </div>
			      </div>
			      <div class="modal-footer">
			        <button class="btn" ng-click="close(userProfileConstant)">Cancel</button>
			      </div>
		    </div>
		    
		    <div class="modal-color" modal="showLocationModal" close="cancel("LOCATION")">
			      <div class="modal-header">
			          <h4>Top 10 Tweets For Location"""),format.raw/*106.44*/("""{"""),format.raw/*106.45*/("""{"""),format.raw/*106.46*/("""locationQueryParam.location"""),format.raw/*106.73*/("""}"""),format.raw/*106.74*/("""}"""),format.raw/*106.75*/("""</h4>
			      </div>
			      <div class="modal-body">
			          <div ng-repeat="result in locationQueryResult">
			          	<p>"""),format.raw/*110.18*/("""{"""),format.raw/*110.19*/("""{"""),format.raw/*110.20*/("""$index+1"""),format.raw/*110.28*/("""}"""),format.raw/*110.29*/("""}"""),format.raw/*110.30*/(""". """),format.raw/*110.32*/("""{"""),format.raw/*110.33*/("""{"""),format.raw/*110.34*/("""result.tweet"""),format.raw/*110.46*/("""}"""),format.raw/*110.47*/("""}"""),format.raw/*110.48*/("""</p>
			          </div>
			      </div>
			      <div class="modal-footer">
			        <button class="btn" ng-click="close(locationConstant)">Cancel</button>
			      </div>
		    </div>
		    
		    <div class="modal-color" modal="showTweetWordModal" close="close(TWEET_WORD)">
			      <div class="modal-header">
			          <h4>Distict Word Count For """),format.raw/*120.41*/("""{"""),format.raw/*120.42*/("""{"""),format.raw/*120.43*/("""tweetWordQueryParam"""),format.raw/*120.62*/("""}"""),format.raw/*120.63*/("""}"""),format.raw/*120.64*/("""</h4>
			      </div>
			      <div class="modal-body">
			      	<table class="table table-stripped table-color">
						<thead>
							<tr>
								<th column="word-column">Word</th>
								<th column="word-column">Count</th>
							</tr>
						</thead>
						<tbody>
							<tr ng-repeat = "result in tweetWordQueryResult">
								<td>"""),format.raw/*132.13*/("""{"""),format.raw/*132.14*/("""{"""),format.raw/*132.15*/("""result.word"""),format.raw/*132.26*/("""}"""),format.raw/*132.27*/("""}"""),format.raw/*132.28*/("""</td>
								<td>"""),format.raw/*133.13*/("""{"""),format.raw/*133.14*/("""{"""),format.raw/*133.15*/("""result.count"""),format.raw/*133.27*/("""}"""),format.raw/*133.28*/("""}"""),format.raw/*133.29*/("""</td>
							</tr>
					</table>
			      </div>
			      <div class="modal-footer">
			        <button class="btn" ng-click="close(tweetWordConstant)">Cancel</button>
			      </div>
		    </div>
		    
		    <div class="modal-color" modal="showHashTagModal" close="cancel("HASH_TAG")">
			      <div class="modal-header">
			          <h4>Top 10 Tweet For #"""),format.raw/*144.36*/("""{"""),format.raw/*144.37*/("""{"""),format.raw/*144.38*/("""hashTagQueryParam"""),format.raw/*144.55*/("""}"""),format.raw/*144.56*/("""}"""),format.raw/*144.57*/("""</h4>
			      </div>
			      <div class="modal-body">
			          <div ng-repeat="result in hashTagQueryResult">
			          	<p>"""),format.raw/*148.18*/("""{"""),format.raw/*148.19*/("""{"""),format.raw/*148.20*/("""$index+1"""),format.raw/*148.28*/("""}"""),format.raw/*148.29*/("""}"""),format.raw/*148.30*/(""". """),format.raw/*148.32*/("""{"""),format.raw/*148.33*/("""{"""),format.raw/*148.34*/("""result.tweet"""),format.raw/*148.46*/("""}"""),format.raw/*148.47*/("""}"""),format.raw/*148.48*/("""</p>
			          </div>
			      </div>
			      <div class="modal-footer">
			        <button class="btn" ng-click="close(hashTagConstant)">Cancel</button>
			      </div>
		    </div>
    
		</div>
	</body>	
</html>"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  DATE: Tue Jul 31 13:07:55 EDT 2018
                  SOURCE: C:/Users/mohit/Downloads/Assignment1/Assignment1/app/views/homePage.scala.html
                  HASH: 6abbe59bbd9cbca1cff0a7d3d83f60f6c95b3ecd
                  MATRIX: 1033->0|1350->291|1364->297|1435->348|1512->399|1526->405|1613->471|1684->515|1699->521|1770->571|1832->606|1847->612|1917->661|1986->703|2001->709|2079->765|2157->816|2172->822|2246->875|2324->926|2339->932|2412->984|2490->1035|2505->1041|2586->1100|2664->1151|2679->1157|2757->1213|3887->2315|3916->2316|3945->2317|3976->2320|4005->2321|4034->2322|4232->2492|4261->2493|4290->2494|4333->2509|4362->2510|4391->2511|4860->2952|4889->2953|4918->2954|4954->2962|4983->2963|5012->2964|5137->3061|5166->3062|5195->3063|5235->3074|5265->3075|5295->3076|5505->3257|5535->3258|5565->3259|5609->3274|5639->3275|5669->3276|5899->3477|5929->3478|5959->3479|6003->3494|6033->3495|6063->3496|6135->3540|6164->3541|6193->3542|6233->3554|6262->3555|6291->3556|6461->3697|6491->3698|6521->3699|6555->3704|6585->3705|6615->3706|6905->3968|6934->3969|6963->3970|7012->3991|7041->3992|7070->3993|7218->4113|7247->4114|7276->4115|7335->4146|7364->4147|7393->4148|7487->4214|7516->4215|7545->4216|7608->4251|7637->4252|7666->4253|7729->4288|7758->4289|7787->4290|7852->4327|7881->4328|7910->4329|7974->4365|8003->4366|8032->4367|8095->4402|8124->4403|8153->4404|8220->4443|8249->4444|8278->4445|8344->4483|8373->4484|8402->4485|8472->4527|8501->4528|8530->4529|8598->4569|8627->4570|8656->4571|8723->4610|8752->4611|8781->4612|8846->4649|8875->4650|8904->4651|9050->4769|9079->4770|9108->4771|9149->4784|9178->4785|9207->4786|9619->5169|9649->5170|9679->5171|9735->5198|9765->5199|9795->5200|9958->5334|9988->5335|10018->5336|10055->5344|10085->5345|10115->5346|10146->5348|10176->5349|10206->5350|10247->5362|10277->5363|10307->5364|10692->5720|10722->5721|10752->5722|10800->5741|10830->5742|10860->5743|11228->6082|11258->6083|11288->6084|11328->6095|11358->6096|11388->6097|11435->6115|11465->6116|11495->6117|11536->6129|11566->6130|11596->6131|11984->6490|12014->6491|12044->6492|12090->6509|12120->6510|12150->6511|12312->6644|12342->6645|12372->6646|12409->6654|12439->6655|12469->6656|12500->6658|12530->6659|12560->6660|12601->6672|12631->6673|12661->6674
                  LINES: 33->1|40->8|40->8|40->8|41->9|41->9|41->9|42->10|42->10|42->10|43->11|43->11|43->11|44->12|44->12|44->12|45->13|45->13|45->13|46->14|46->14|46->14|47->15|47->15|47->15|48->16|48->16|48->16|76->44|76->44|76->44|76->44|76->44|76->44|78->46|78->46|78->46|78->46|78->46|78->46|93->61|93->61|93->61|93->61|93->61|93->61|94->62|94->62|94->62|94->62|94->62|94->62|97->65|97->65|97->65|97->65|97->65|97->65|100->68|100->68|100->68|100->68|100->68|100->68|103->71|103->71|103->71|103->71|103->71|103->71|105->73|105->73|105->73|105->73|105->73|105->73|115->83|115->83|115->83|115->83|115->83|115->83|119->87|119->87|119->87|119->87|119->87|119->87|120->88|120->88|120->88|120->88|120->88|120->88|121->89|121->89|121->89|121->89|121->89|121->89|122->90|122->90|122->90|122->90|122->90|122->90|123->91|123->91|123->91|123->91|123->91|123->91|124->92|124->92|124->92|124->92|124->92|124->92|125->93|125->93|125->93|125->93|125->93|125->93|127->95|127->95|127->95|127->95|127->95|127->95|138->106|138->106|138->106|138->106|138->106|138->106|142->110|142->110|142->110|142->110|142->110|142->110|142->110|142->110|142->110|142->110|142->110|142->110|152->120|152->120|152->120|152->120|152->120|152->120|164->132|164->132|164->132|164->132|164->132|164->132|165->133|165->133|165->133|165->133|165->133|165->133|176->144|176->144|176->144|176->144|176->144|176->144|180->148|180->148|180->148|180->148|180->148|180->148|180->148|180->148|180->148|180->148|180->148|180->148
                  -- GENERATED --
              */
          