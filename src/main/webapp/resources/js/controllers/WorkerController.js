/**
 * Created by tmichels on 8/3/14.
 */


var WorkerController = function($scope, $http){
/*
	$scope.items = [
	                { id: 1, name: 'foo' },
	                { id: 2, name: 'bar' },
	                { id: 3, name: 'blah' }
	              ];
	*/	
	$scope.departments = [
	                { id: 1, name: 'first' },
	                { id: 2, name: 'second' },
	                { id: 3, name: 'third' }
	              ];

    $scope.editMode = false;

    $scope.viewAllWorkers = function(){
        $http.get('worker/all.json').success(function(response){
            $scope.workers = response;
        })
    }

    $scope.addWorker = function(w) {
    	var json2 = angular.toJson(w);
    	alert(json2);
        $http.post('worker/add', json2).success(function(response){
        	
            $scope.viewAllWorkers();
            $scope.worker.firstName='';
            $scope.worker.lastName='';            
            $scope.worker.email='';
            $scope.worker.phone='';            
            $scope.worker.description = '';
        }).error(function(response){
        	alert(response);
            console.log(response);
        })
    }
    
    $scope.updateWorker = function(w) {
        $http.put('worker/update', w).success(function(response){
            $scope.worker.firstName='';
            $scope.worker.lastName='';            
            $scope.worker.email='';
            $scope.worker.phone='';
            $scope.viewAllWorkers();
            $scope.editMode = false;
            
            $scope.error = true;
            $scope.errorMessage = "Some type error";
        }).error(function(response){
            console.log(response);
        })
    }    
    
    $scope.resetWorkerField = function(){
        $scope.worker.firstName='';
        $scope.worker.lastName='';            
        $scope.worker.email='';
        $scope.worker.phone='';
        $scope.editMode = false;
    }

    $scope.deleteWorker = function(id) {
        $http.delete('worker/delete/' + id).success(function(response){
            $scope.viewAllWorkers();
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.editWorker = function(worker){
        $scope.worker = worker;
        $scope.editMode = true;
    }

    $scope.viewAllWorkers();
}