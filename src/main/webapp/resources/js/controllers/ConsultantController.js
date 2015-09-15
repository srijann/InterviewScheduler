'use strict';

/**
 * CarController
 * @constructor
 */
var ConsultantController = function($scope, $http) {
    $scope.fetchConsultantsList = function() {
        $http.get('consultants/consultantlist.json').success(function(consultantList){
            $scope.consultants = consultantList;
        });
    };

    $scope.addNewCar = function(newCar) {
        $http.post('cars/addCar/' + newCar).success(function() {
            $scope.fetchConsultantsList();
        });
        $scope.consultantName = '';
    };

    $scope.removeCar = function(car) {
        $http.
        delete('cars/removeCar/' + car).success(function() {
            $scope.fetchCarsList();
        });
    };

    $scope.removeAllCars = function() {
        $http.delete('cars/removeAllCars').success(function() {
            $scope.fetchCarsList();
        });

    };

    $scope.fetchCarsList();
};