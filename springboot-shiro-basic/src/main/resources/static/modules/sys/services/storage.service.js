(function () {
  'use strict';
  angular
    .module('com.module.sys')
    .service('StorageService', function () {

    	var storage = window.localStorage;
    	var appNamespace = 'sbp';
      this.setCredentials = function(credentials){
    	  	storage.setItem(appNamespace + '.credentials.username', credentials.username);
  	  	//storage.setItem(appNamespace + '.credentials.password', credentials.password);
  	  	storage.setItem(appNamespace + '.credentials.rememberMe', credentials.rememberMe ? true : false);
  	  	storage.setItem(appNamespace + '.credentials.refereshToken', credentials.refereshToken ? credentials.refereshToken : "");
  	  	storage.setItem(appNamespace + '.credentials.accessToken', credentials.accessToken ? credentials.accessToken : "");
    	  }
      
      this.getCredentials = function(){
    	  	var credentials = {};
    	  	credentials.username = storage.getItem(appNamespace + '.credentials.username');
    	  	//credentials.password = storage.getItem(appNamespace + '.credentials.password');
    	  	credentials.rememberMe = storage.getItem(appNamespace + '.credentials.rememberMe') == 'true'? true : false;
    	  	credentials.refereshToken = storage.getItem(appNamespace + '.credentials.refereshToken') ;
    	  	credentials.accessToken = storage.getItem(appNamespace + '.credentials.accessToken');
    	  	return credentials;
      }
      
      });

})();
