// var professoresModulo = angular.module('professoresModulo', []);
//
// professoresModulo.controller("professoresController", function($scope) {
//
// $scope.professores = [
// {codigo : 1, nome: 'Núbia Oliveira', email: 'nubia@gmail.com', fone: '35 9987
// 6785' },
// {codigo : 2, nome: 'Jhow Serpa', email: 'jhow@gmail.com', fone: '35 9977
// 6123' }
// ];
//
// $scope.selecinarProfessor = function(professorSelecionado){
//
// $scope.professor = professorSelecionado;
// }
//
// $scope.novo = function(){
// $scope.professor = "";
// }
//
// $scope.salvar = function(){
// $scope.professores.push($scope.professor);
// $scope.novo();
// }
//
// $scope.excluir = function(){
// $scope.professores.splice($scope.professores.indexOf($scope.professor), 1);
// $scope.novo();
// }
// });
angular.module("professoresModulo", []).value('urlBase',
		'http://localhost:8080/java-backend/rest/').controller(
		"ProfessoresController", function($http, urlBase) {
			var self = this;
			self.usuario = 'Jhow';

			self.professores = [];
			self.professor = undefined;

			self.novo = function() {
				self.professor = {};
			};

			self.salvar = function() {
				var metodo = 'POST';
				if (self.professor.id) {
					metodo = 'PUT';
				}

				$http({
					method : metodo,
					url : urlBase + 'professores/',
					data : self.professor
				}).then(function successCallback(response) {
					self.atualizarTabela();
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.alterar = function(professor) {
				self.professor = professor;
			};

			self.deletar = function(professor) {
				self.professor = professor;

				$http({
					method : 'DELETE',
					url : urlBase + 'professores/' + self.professor.id + '/'
				}).then(function successCallback(response) {
					self.atualizarTabela();
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.concluir = function(professor) {
				self.professor = professor;

				$http({
					method : 'PUT',
					url : urlBase + 'professores/' + self.professor.id + '/'
				}).then(function successCallback(response) {
					self.atualizarTabela();
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.ocorreuErro = function() {
				alert("Ocorreu um erro inesperado!");
			};

			self.atualizarTabela = function() {
				$http({
					method : 'GET',
					url : urlBase + 'professores/'
				}).then(function successCallback(response) {
					self.professores = response.data;
					self.professor = undefined;
				}, function errorCallback(response) {
					self.ocorreuErro();
				});
			};

			self.selecionarProfessor = function(professorSelecionado) {
				self.professor = professorSelecionado;
			}

			self.activate = function() {
				self.atualizarTabela();
			};
			self.activate();
		});