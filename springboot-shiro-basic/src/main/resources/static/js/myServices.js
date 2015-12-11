(function(window, angular, undefined) {'use strict';

var urlBase = "http://127.0.0.1:8080/api";
var authHeader = 'authorization';

var module = angular.module("myServices", ['ngResource']);

module.factory('Access', ['$http', function(){
	this.login = function(username, password){
		$http.post(urlBase+'/access/login',{username: username, password: password}).success(function(){
            //window.location.href = "Gulugulus/subMenu";
			console.log('/access/login successed!');
        });
	}
}]);

/*module.factory('Access', ['$resource',
   function($resource){
     return $resource(urlBase + '/access/logn', {}, {
       query: {method:'GET', params:{phoneId:'phones'}, isArray:true}
     });
   }]);

module.factory('User', ['$resource',
  function($resource){
    return $resource(urlBase + '/api/user/:id', {}, {
      query: {method:'GET', params:{id:'id'}, isArray:true}
    });
  }]);


module.factory(
  "AccessToken",
  ['LoopBackResource', 'LoopBackAuth', '$injector', function(Resource, LoopBackAuth, $injector) {
    var R = Resource(
      urlBase + "/accessTokens/:id",
      { 'id': '@id' },
      {

        // INTERNAL. Use AccessToken.user() instead.
        "prototype$__get__user": {
          url: urlBase + "/accessTokens/:id/user",
          method: "GET"
        },
        "create": {
          url: urlBase + "/accessTokens",
          method: "POST"
        },
        "createMany": {
          isArray: true,
          url: urlBase + "/accessTokens",
          method: "POST"
        },
        "upsert": {
          url: urlBase + "/accessTokens",
          method: "PUT"
        },
        "exists": {
          url: urlBase + "/accessTokens/:id/exists",
          method: "GET"
        },
        "findById": {
          url: urlBase + "/accessTokens/:id",
          method: "GET"
        },
        "find": {
          isArray: true,
          url: urlBase + "/accessTokens",
          method: "GET"
        },
        "findOne": {
          url: urlBase + "/accessTokens/findOne",
          method: "GET"
        },
        "updateAll": {
          url: urlBase + "/accessTokens/update",
          method: "POST"
        },
        "deleteById": {
          url: urlBase + "/accessTokens/:id",
          method: "DELETE"
        },
        "count": {
          url: urlBase + "/accessTokens/count",
          method: "GET"
        },
        "prototype$updateAttributes": {
          url: urlBase + "/accessTokens/:id",
          method: "PUT"
        },
        "createChangeStream": {
          url: urlBase + "/accessTokens/change-stream",
          method: "POST"
        },

        // INTERNAL. Use User.accessTokens.findById() instead.
        "::findById::user::accessTokens": {
          params: {
          'fk': '@fk'
          },
          url: urlBase + "/users/:id/accessTokens/:fk",
          method: "GET"
        },

        // INTERNAL. Use User.accessTokens.destroyById() instead.
        "::destroyById::user::accessTokens": {
          params: {
          'fk': '@fk'
          },
          url: urlBase + "/users/:id/accessTokens/:fk",
          method: "DELETE"
        },

        // INTERNAL. Use User.accessTokens.updateById() instead.
        "::updateById::user::accessTokens": {
          params: {
          'fk': '@fk'
          },
          url: urlBase + "/users/:id/accessTokens/:fk",
          method: "PUT"
        },

        // INTERNAL. Use User.accessTokens() instead.
        "::get::user::accessTokens": {
          isArray: true,
          url: urlBase + "/users/:id/accessTokens",
          method: "GET"
        },

        // INTERNAL. Use User.accessTokens.create() instead.
        "::create::user::accessTokens": {
          url: urlBase + "/users/:id/accessTokens",
          method: "POST"
        },

        // INTERNAL. Use User.accessTokens.createMany() instead.
        "::createMany::user::accessTokens": {
          isArray: true,
          url: urlBase + "/users/:id/accessTokens",
          method: "POST"
        },

        // INTERNAL. Use User.accessTokens.destroyAll() instead.
        "::delete::user::accessTokens": {
          url: urlBase + "/users/:id/accessTokens",
          method: "DELETE"
        },

        // INTERNAL. Use User.accessTokens.count() instead.
        "::count::user::accessTokens": {
          url: urlBase + "/users/:id/accessTokens/count",
          method: "GET"
        },
      }
    );


    return R;
  }]);
*/
})(window, window.angular);
