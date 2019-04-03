"use strict";

app.controller('ctrlHome',function($scope,$ionicModal,$ionicPlatform,betaOneService){

	$scope.titulo = "Cartões";
	$scope.myswipe = true;

	// Initialize the database.
    $ionicPlatform.ready(function() {
        betaOneService.getAllDados('contato').then(function(contatos) {
            $scope.contatos = contatos;
        });
    });
    

    //MODAL DE CADASTRO
    $ionicModal.fromTemplateUrl('template/adicionarContato.html', {
		scope: $scope,
		animation: 'slide-in-up'
	}).then(function(modal) {
		$scope.modal = modal;
	});
	$scope.openModal = function() {
		$scope.modal.show();
	};
	$scope.closeModal = function() {
		$scope.modal.hide();
	};


	//LOCATION DO CADASTRO
	$scope.data = {};
	//Optional
	$scope.countryCode = 'BR';
	//Optional
	$scope.onAddressSelection = function (location) {
		//Do something
		var a = location.address_components;
		//console.log(a);
	};


});