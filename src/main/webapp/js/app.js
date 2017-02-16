/**
 * 
 */
var app = angular.module("app", [ 'ngRoute' ]).value('urlBase','http://localhost:8080/AppMobile/finanzas/');

app.config([ '$routeProvider', function($routeProvider) {

	$routeProvider.when('/', {
		templateUrl : "inicio.html",
		controller : "InicioController"
	})
	
	$routeProvider.when('/lista/personas', {
		templateUrl : "administracion/listaPersona.html",
		controller : "ListaPersonaController"
	})
	
	$routeProvider.when('/login', {
		templateUrl : "login.html",
		controller : "LoginController"
	})
	
	$routeProvider.when('/registrar', {
		templateUrl : "registrar.html",
		controller : "RegistrarController"
	})

} ]);