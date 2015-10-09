'use strict';
interviewSchedulerApp.controller('consultantController', function($scope,consultantsData, consultantService) {

	$scope.selectedRows = [];

	$scope.showModal = false;
	$scope.toggleModal = function(){
		console.log('togMod', $scope.selectedRows);
		$scope.showModal = !$scope.showModal;
	};
	$scope.closeModal = function(){
		console.log('Modal Closed');
		$scope.showModal = false;
	};

	/* $scope.editConsultant=[];*/

	$scope.gridOptions = {
			enableSorting: true,
			columnDefs: [
			             { name:'Name', field:'name'},
			             { name:'DOB', field: 'dob' },
			             { name:'PHONE', field: 'phone'},
			             { name:'Experience', field: 'yrsExp'}
			             ],
			             data : consultantsData

	};
	$scope.gridOptions.multiSelect = true;

	$scope.checkGridApi = function () {
		console.log('selec: ', $scope.gridApi);
	};

	$scope.consultantDeleteDisable = true;
	$scope.consultantEditDisable = true;

	$scope.gridOptions.onRegisterApi = function (gridApi) {
		$scope.gridApi = gridApi;


		gridApi.selection.on.rowSelectionChanged($scope, function (row) {
			console.log('ent: ', row.entity);
			var found = false;
			if ($scope.selectedRows.length > 0) {
				for(var i = 0; i < $scope.selectedRows.length; i++) {
					if ($scope.selectedRows[i].id === row.entity.id) {
						$scope.selectedRows.splice(i, 1);
						found = true;
						break;
					}
				}
				if (!found) {
					$scope.selectedRows.push(row.entity);
				} 
			} else {
				$scope.selectedRows.push(row.entity);
			}

		});
	};

	$scope.$watch('selectedRows', function() {
		console.log('watch ', $scope.selectedRows);
		if ($scope.selectedRows.length > 0) {
			if ($scope.selectedRows.length === 1) {
				$scope.consultantEditDisable = false;
				
			} else {
				$scope.consultantEditDisable = true;
			}
			$scope.consultantDeleteDisable = false;
		} else {
			$scope.consultantDeleteDisable = true;
			$scope.consultantEditDisable = true;
		}
	}, true);
	$scope.sendPost = function() {
		console.log('from sendpost');
		consultantService.editConsultant($scope.selectedRows[0]);
		
	}

	//make http call for edit submit click.
	//on delete click .. pop up a window asking for confirmation
	//http call for delete
});