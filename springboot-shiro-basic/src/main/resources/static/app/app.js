'use strict';

var AngularSpringApp = {};

var App = angular.module('AngularSpringApp', ['AngularSpringApp.filters', 'AngularSpringApp.services', 'AngularSpringApp.directives']);

// Declare app level module which depends on filters, and services
App.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.when('/cars', {
        templateUrl: 'cars/layout.html',
        controller: CarController
    });

    $routeProvider.when('/trains', {
        templateUrl: 'trains/layout.html',
        controller: TrainController
    });
    
    $routeProvider.when('/users', {
        templateUrl: 'users/layout.html',
        controller: UserController
    });

    $routeProvider.otherwise({redirectTo: '/users'});
}]);
