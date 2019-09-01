app.factory('searchFactory',['$http',function($http){
	var services={};
	services.searchTweets = function(searchKey){
		console.log(searchKey);
		return $http.get('http://localhost:9000/searchTweets/'+searchKey);
	}
	
	services.searchTweetsByLocation = function(latitude,longitude){
		console.log("location");
		return $http.get('http://localhost:9000/searchTweetsByLocation/'+latitude+'/'+longitude);
	}
	
	services.searchTweetsByHashTag = function(searchKey){
		return $http.get('http://localhost:9000/searchTweetsByHashTag/'+searchKey);
	}
	
	services.searchTweetDistinctWordCount = function(searchKey){
		return $http.get('http://localhost:9000/searchTweetDistinctWordCount/'+searchKey);
	}
	
	services.getTweetEmotion = function(searchKey){
		return $http.get('http://localhost:9000/getTweetEmotion/'+searchKey);
	}
	
	services.getUserProfile = function(searchKey){
		console.log(searchKey);
		return $http.get('http://localhost:9000/getUserProfile/'+searchKey);
	}
	return services
}]);