//-----------------------------------------------------------------------------//
//Section FamilyMember
// Laden der Tabelle FamilyMember
$(document).ready(function(){
	loadDataTable();
	
	$("#newFamilyMember").submit(function(){
		postFamilyMember(event);
		loadDataTable();
		
	});
});
//FamilyMember hinzufügen
function postFamilyMember(event){
	
	// welche Daten werden benötigt
	var formData = {
		'id': $('input[name=IDP]').val(),
		'name': $('input[name=VN]').val(),
		'birthdate': $('input[name=GT]').val()
	};
	// Was soll mit den Eingegebenen Daten gemacht werden
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/FamilyMember',
		data: JSON.stringify(formData),
		success: function(data, textStatus, jQxhr){
			loadDataTable();
		},
		error: function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
	event.preventDefault();
}
//FamilyMember Daten in Tabelle laden
function loadDataTable(){
	var table = $('#famtable').DataTable({
		destroy: true,
		"ajax": {
			"url": "/FamilyMember",
			"dataSrc": ""
		},
		"columns": [
			{"data": "id"},
			{"data": "name"},
			{"data": "birthdate"}
		]
	});
}
// FamilyMember bearbeiten
function updateFamilyMember(event){
	
	// welche Daten werden benötigt
	var formData = {
		'id': $('input[name=IDP]').val(),
		'name': $('input[name=VN]').val(),
		'birthdate': $('input[name=GT]').val()
	};
	// Was soll mit den Eingegebenen Daten gemacht werden
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: '/FamilyMember',
		data: JSON.stringify(formData),
		success: function(data, textStatus, jQxhr){
			loadDataTable();
		},
		error: function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
	event.preventDefault();
}


//-----------------------------------------------------------------------------//
//Section VacationWish
// Laden der Tabelle VacationWish
$(document).ready(function(){
	loadDataTable2();
	
	$("#newVacationWish").submit(function(){
		postVacationWish(event);
		loadDataTable2();
	});
});

function postVacationWish(event){
	
	var formData = {
		'vacationWishId': $('input[name=vacationwishid]').val(),
		'description': $('input[name=BE]').val(),
		'place': $('input[name=ORT]').val()
	};
	
	$.ajax({
		type: 'POST',
		contentType: 'application/json',
		url: '/VacationWish',
		data: JSON.stringify(formData), // data we want to POST
		success: function(data, textStatus, jQxhr) {
			loadDataTable2();
		},
		error: function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
	event.preventDefault();
}
function loadDataTable2(){
	var table = $('#urlaubtable').DataTable({
		destroy: true,
		"ajax": {
			"url": "/VacationWish",
			"dataSrc": ""
		},
		"columns":[
			{"data": "vacationWishId"},
			{"data": "description"},
			{"data": "place"}
		]
	});
}

// Ende VacationWish Tabelle laden
// VacationWish updaten
function updateVacationWish(event){
	
	// welche Daten werden benötigt
	var formData = {
		'vacationWishId': $('input[name=vacationWishId]').val(),
		'description': $('input[name=BE]').val(),
		'place': $('input[name=Ort]').val()
	};
	// Was soll mit den Eingegebenen Daten gemacht werden
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: '/VacationWish',
		data: JSON.stringify(formData),
		success: function(data, textStatus, jQxhr){
			loadDataTable2();
		},
		error: function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
	event.preventDefault();
}
// Ende VacationWish Tabelle hinzufügen