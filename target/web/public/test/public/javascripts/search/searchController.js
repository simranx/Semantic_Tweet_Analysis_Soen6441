app.controller('SearchController', ['$scope','searchFactory', function($scope,searchFactory){
	$scope.testVariable = 'Akshay Bansal';
	$scope.searchKey = '';
	$scope.searchResults = {};
	$scope.searchResults.result=[];
	$scope.searchResults.emotion='';
	$scope.searchResults.showEmotion=false;
	$scope.allResults = {};
	$scope.nameForProfile = '';
	$scope.userProfileConstant = "USER_PROFILE";
	$scope.locationConstant = "LOCATION";
	$scope.tweetWordConstant = "TWEET_WORD";
	$scope.hashTagConstant = "HASH_TAG";
	$scope.locationQueryParam = {};
	$scope.locationQueryParam.latitude;
	$scope.locationQueryParam.longitude;
	$scope.locationQueryParam.location;
	$scope.locationQueryResult = {};
	$scope.hashTagQueryParam = '';
	$scope.hashTagQueryResult = {};
	$scope.userProfileQueryParam='';
	$scope.userProfileQueryResult = {};
	$scope.tweetWordQueryParam = '';
	$scope.tweetWordQueryResult = {};
	$scope.tweetSentiment = {};
	$scope.emotionQueryParam='';
	
	$scope.searchTweets = function(){
		console.log(JSON.stringify($scope.allResults));
		console.log($scope.searchKey);
		var searchK = $scope.searchKey;
		console.log(JSON.stringify($scope.allResults));
		searchFactory.searchTweets(searchK).then(
				function(response){
					var key = '';
					key = $scope.searchKey;
					$scope.searchKey = '';
					var staticResult = {};
					staticResult.result=[];
					staticResult.emotion='';
					staticResult.showEmotion = false;
					console.log(JSON.stringify($scope.allResults));
					console.log(JSON.stringify(response.data));
					staticResult.result = response.data;
					var result = response.data;
					staticResult.emotion = '';
					staticResult.showEmotion = false;
					var newStaticResult = {};
					newStaticResult.result=[];
					newStaticResult.emotion='';
					newStaticResult.showEmotion = false;
					for(index=0;index<result.length-1;index++){
						var hashtags = result[index].hashTags;
						console.log(hashtags);
						if(hashtags || hashtags!=="" || hashtags!=null){
							var hashSplit = hashtags.split(",");
							console.log(hashSplit);
							staticResult.result[index].splitHashTags = hashSplit;
						} 
						newStaticResult.result[index] = staticResult.result[index];
					}
					newStaticResult.emotion=result[result.length-1].tweetEmotion;
					newStaticResult.showEmotion = true;
					console.log(JSON.stringify($scope.newStaticResult));
					$scope.allResults[key] = newStaticResult;

					console.log(JSON.stringify($scope.allResults));
				},function(error){
					console.log(error);
				});
	}
	
	$scope.openProfile = function(name){
		console.log("here" + name);
		$scope.userProfileQueryParam = name;
		searchFactory.getUserProfile(name).then(
			function(response){
				console.log(JSON.stringify(response.data));
				$scope.userProfileQueryResult = response.data[0];
				var splitTimeline = response.data[0].userTimeLineTweets.split("<br>");
				$scope.userProfileQueryResult.splitTimelineTweets = splitTimeline;
				console.log($scope.userProfileQueryResult);
				$scope.open("USER_PROFILE");
			},function(error){
				console.log(error);
			});
		
	}
	 
	 $scope.openLocation = function(latitude,longitude,location){
		$scope.locationQueryParam.latitude = latitude;
		$scope.locationQueryParam.longitude = longitude;
		$scope.locationQueryParam.location = location;
		if(latitude && longitude)
		{
			searchFactory.searchTweetsByLocation(latitude,longitude).then(
					function(response){
						console.log(JSON.stringify(response.data));
						$scope.locationQueryResult = response.data;
						$scope.open("LOCATION");
					},function(err){
						console.log.err;
					});
		}
		
		
	 }
		 
	 $scope.openTweetWord = function(name){
		 console.log("here2");
		$scope.tweetWordQueryParam = name;
		searchFactory.searchTweetDistinctWordCount(name).then(
				function(response){
					console.log(JSON.stringify(response.data));
					$scope.tweetWordQueryResult = response.data;
					$scope.open("TWEET_WORD");
				},function(error){
					console.log(error);
				});
		
	}
	 
	 $scope.openHashTag = function(name){
		 console.log("here3");
		$scope.hashTagQueryParam = name;
		searchFactory.searchTweetsByHashTag(name).then(
				function(response){
					console.log(JSON.stringify(response.data));
					$scope.hashTagQueryResult = response.data;
					$scope.open("HASH_TAG");
				},function(error){
					console.log(error);
				});
		
	 }
	
	$scope.open = function(modalName) {
		if(modalName == "USER_PROFILE")
		    $scope.showUserProfileModal = true;
		if(modalName == "LOCATION")
			$scope.showLocationModal = true;
		if(modalName == "TWEET_WORD")
			$scope.showTweetWordModal = true;
		if(modalName == "HASH_TAG")
			$scope.showHashTagModal = true;
	  };
	  
	  $scope.close = function(modalName){
		  if(modalName == "USER_PROFILE"){
			  $scope.showUserProfileModal = false;
			  $scope.userProfileQueryParam = '';
			  $scope.userProfileQueryResult = {};
		  }
		  if(modalName == "LOCATION"){
			  $scope.showLocationModal = false;
			  $scope.locationQueryParam = {};
			  $scope.locationQueryResult = {};
		  }
		  if(modalName == "TWEET_WORD"){
			  $scope.showTweetWordModal = false;
			  $scope.tweetWordQueryParam = '';
			  $scope.tweetWordQueryResult = {};
		  }
		  if(modalName == "HASH_TAG"){
			  $scope.showHashTagModal = false;
			  $scope.hashTagQueryParam = '';
			  $scope.hashTagQueryResult = {};
		  }
	  }
	  
	 $scope.getTweetSentiment = function(tweetKey){
		 $scope.emotionQueryParam = tweetKey;
		 searchFactory.getTweetEmotion(tweetKey).then(
					function(response){
						console.log(JSON.stringify(response.data));
						$scope.allResults[tweetKey].emotion = response.data[0];
						$scope.allResults[tweetKey].showEmotion = true;
						console.log(JSON.stringify($scope.allResults));
						 $scope.emotionQueryParam = '';
					},function(err){
						console.log(error);
					});
		
	 }
	  
}]);