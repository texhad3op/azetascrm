/**
 * Created by tmichels on 8/3/14.
 */


var DepartmentController = function($scope, $http){

    $scope.editMode = false;
    $scope.position = '';

    $scope.viewAllDepartments = function(){
        $http.get('department/all.json').success(function(response){
            $scope.departments = response;
        })
    }

    $scope.addDepartment = function(ab) {
        $http.post('department/add', ab).success(function(response){
            $scope.viewAllDepartments();
            $scope.department.name='';
            $scope.department.address='';
            $scope.department.description = '';
        }).error(function(response){
            console.log(response);
        })
    }
    
    $scope.updateDepartment = function(ab) {
        $http.put('department/update', ab).success(function(response){
            $scope.department.name='';
            $scope.department.address='';
            $scope.department.description = '';
            $scope.viewAllDepartments();
            $scope.editMode = false;
            
            $scope.error = true;
            $scope.errorMessage = "Some type error";
        }).error(function(response){
            console.log(response);
        })
    }    
    
    $scope.resetDepartmentField = function(){
        $scope.department.name='';
        $scope.department.address='';
        $scope.department.description = '';
        $scope.editMode = false;
    }

    $scope.deleteDepartment = function(id) {
        $http.delete('department/delete/' + id).success(function(response){
            $scope.viewAllDepartments();
        }).error(function(response){
            console.log(response);
        })
    }

    $scope.deleteAllDepartments = function(){
        $http.delete('department/delete/all').success(function(response){
            $scope.viewAllDepartments();
        })
    }

    $scope.editDepartment = function(department){
        $scope.department = department;
        $scope.editMode = true;
    }

    $scope.viewAllDepartments();
}