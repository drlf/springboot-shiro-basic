'use strict';

/**
 * UserController
 * @constructor
 */
var UserController = function($scope, $http) {
    $scope.user = {};
    $scope.editMode = false;

    $scope.fetchUsersList = function() {
        $http.get('/user').success(function(data){
            $scope.users = data;
        });
    };

    $scope.addNewUser = function(user) {
        $scope.resetError();
        user.password = 'sdfsfs';
        $http.post('/user', user).success(function() {
            $scope.fetchUsersList();
            $scope.user.name = '';
            $scope.user.speed = '';
            $scope.user.diesel = false;
        }).error(function() {
            $scope.setError('Could not add a new user');
        });
    };

    $scope.updateUser = function(user) {
        $scope.resetError();

        $http.put('/user/'+user.id, user).success(function() {
            $scope.fetchUsersList();
            $scope.user.name = '';
            $scope.user.speed = '';
            $scope.user.diesel = false;
            $scope.editMode = false;
        }).error(function() {
            $scope.setError('Could not update the user');
        });
    };

    $scope.editUser = function(user) {
        $scope.resetError();
        $scope.user = user;
        $scope.editMode = true;
    };

    $scope.removeUser = function(id) {
        $scope.resetError();

        $http.delete('/user/'+id).success(function() {
            $scope.fetchUsersList();
        }).error(function() {
            $scope.setError('Could not remove user');
        });
        $scope.user.name = '';
        $scope.user.speed = '';
    };

    $scope.removeAllUsers = function() {
        $scope.resetError();

        $http.delete('/user/removeAllUsers').success(function() {
            $scope.fetchUsersList();
        }).error(function() {
            $scope.setError('Could not remove all users');
        });

    };

    $scope.resetUserForm = function() {
        $scope.resetError();
        $scope.user = {};
        $scope.editMode = false;
    };

    $scope.resetError = function() {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function(message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchUsersList();

    $scope.predicate = 'id';
};