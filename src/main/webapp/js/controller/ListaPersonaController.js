/**
 * 
 */
app.controller("ListaPersonaController", function ($scope,$http, urlBase,$location) {

			$scope.personas = [];

			$scope.persona = undefined;

			$scope.listarDatos = function() {

				$http({
					method : 'GET',
					url : urlBase + 'personas/'
				}).then(function successCallback(response) {
					$scope.personas = response.data;
					$scope.persona = undefined;
					$location.path('/lista/personas')
				}, function errorCallback(response) {
					$scope.ocurrioError();
				});
			};
			
			$scope.ocurrioError = function () {
                alert("Ocurrio un error inesperado!");
            };
            
			$scope.activate = function () {
                $scope.listarDatos();
            };
            
            $scope.activate();
		} );