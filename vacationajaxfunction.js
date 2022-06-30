//-----------------------------------------------------------------------------//
//Section FamilyMember
// Laden der Tabelle FamilyMember
$(document).ready(function(){
	loadDataTable();
	
	$("#newFamilyMember").submit(function(){
		postFamilyMember(event);
		loadDataTable();	// Aktualisiert Tabelle
		
	});
});
//FamilyMember hinzufügen
function postFamilyMember(event){
	
	// welche Daten werden benötigt
	var formData = {
		'id': $('input[name=IDP]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'name': $('input[name=VN]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'birthdate': $('input[name=GT]').val()	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
	};
	// Was soll mit den Eingegebenen Daten gemacht werden
	$.ajax({
		type: 'POST',	// Zeigt was mit den Daten gemacht werden soll
		contentType: 'application/json',
		url: '/FamilyMember',	// Wo sollen die Daten gepostet werden
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
			"url": "/FamilyMember",		// Adresse der Tabelle die geladen werden soll
			"dataSrc": ""
		},
		"columns": [
			{"data": "id"},		// Attribute die geladen werden sollen
			{"data": "name"},
			{"data": "birthdate"}
		]
	});
}
// FamilyMember bearbeiten
function updateFamilyMember(event){
	
	// welche Daten werden benötigt
	var formData = {
		'id': $('input[name=IDP]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'name': $('input[name=VN]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'birthdate': $('input[name=GT]').val()	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
	};
	// Was soll mit den Eingegebenen Daten gemacht werden
	$.ajax({
		type: 'PUT',
		contentType: 'application/json',
		url: '/FamilyMember',	// Wo sollen die veränderten Daten hinkommen
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
		postVacationWish(event);	// Postet VacationWish daten
		loadDataTable2();	// Aktualisiert Tabelle
	});
});

function postVacationWish(event){
	
	// Attribute der VacationWish Tabelle
	var formData = {
		'vacationWishId': $('input[name=vacationwishid]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'description': $('input[name=BE]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'place': $('input[name=ORT]').val()		// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
	};
	
	$.ajax({
		type: 'POST',	// Zeigt was mit den Daten gemacht werden soll
		contentType: 'application/json',	
		url: '/VacationWish',	// Wo sollen die Daten gepostet werden
		data: JSON.stringify(formData),
		success: function(data, textStatus, jQxhr) {
			loadDataTable2();
		},
		error: function(jqXhr, textStatus, errorThrown) {
			console.log(errorThrown);
		}
	});
	event.preventDefault();
}

// VacationWish Daten in Tabelle laden
function loadDataTable2(){
	var table = $('#urlaubtable').DataTable({
		destroy: true,
		"ajax": {
			"url": "/VacationWish",	// Adresse der Tabelle die geladen werden soll
			"dataSrc": ""
		},
		"columns":[
			{"data": "vacationWishId"},		//Attribute der VacationWIsh Tabelle die geladen werden sollen
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
		'vacationWishId': $('input[name=vacationwishid]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'description': $('input[name=BE]').val(),	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
		'place': $('input[name=Ort]').val()	// Ziegt welche Daten, die auf der Webseite eingegeben wurden, zu welchem Attribut in der Datenbank gehört
	};
	// Was soll mit den Eingegebenen Daten gemacht werden
	$.ajax({
		type: 'PUT',	//Updaten der VacationWish Tabelle
		contentType: 'application/json',
		url: '/VacationWish',	// Wo sollen die veränderten Daten hinkommen
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