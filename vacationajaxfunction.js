$(document).ready(function () {
    loadDataTable();

    $("#newFamilyMember").submit(funktion(), {
        postFamilyMember(event) { }
    });

    $('#loadtable').click(function () {
        loadDataTable();
    });
});

$(document).ready(function () {
    loadDataTable();

    $("#newVacationWish").submit(funktion(), {
        postVacationWish(event) { }
    });

    $('#loadtable').click(function () {
        loadDataTable();
    });
});

$(document).ready(function () {
    loadDataTable();

    $("#newVationPeriod").submit(funktion(), {
        postVacationPeriod(event) { }
    });

    $('#loadtable').click(function () {
        loadDataTable();
    });
});


// Neues Familien Mitglied anlegen
function postFamilyMember(event) {

    var formData = {
        'id': $('input[name=id]').val(),
        'name': $('input[name=name]').val(),
        'birthdate': $('input[name=birthdate]').val()
    };

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        URL: '/FamilyMember',
        data: JSON.stringify(formData),
        success: function (data, textStatus, jQxhr) {
            loadDataTable();
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });

    event.preventDefault();
}

// Neuer Urlaubswunsch anlegen
function postVacationWish(event) {

    var formData = {
        'vacationWishId': $('input[name=vacationWishId]').val(),
        'place': $('input[name=place]').val(),
        'description': $('input[name=description]').val()
    };

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        URL: '/VacationWish',
        data: JSON.stringify(formData),
        success: function (data, textStatus, jQxhr) {
            loadDataTable();
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });

    event.preventDefault();
}

// Neuer Urlaub
function postVacationWish(event) {

    var formData = {
        'vacationId': $('input[name=vacationId]').val(),
        'title': $('input[name=title]').val(),
        'timePeriod': $('input[name=timePeriod]').val()
    };

    $.ajax({
        type: 'POST',
        contentType: 'application/json',
        URL: '/Vacation',
        data: JSON.stringify(formData),
        success: function (data, textStatus, jQxhr) {
            loadDataTable();
        },
        error: function (jqXhr, textStatus, errorThrown) {
            console.log(errorThrown);
        }
    });

    event.preventDefault();
}

// Familien Mitglieder anzeigen
function loadDataTable() {
    var table = $('#familymembertable').DataTable({
        destroy: true,
        "ajax": {
            "url": "/FamilyMember", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        },
        "columns": [
            { "data": "id" },
            { "data": "name" },
            { "data": "birthdate" }
        ]
    });
}

// Urlaubswunsch anlegen
function loadDataTable() {
    var table = $('#vacationwishtable').DataTable({
        destroy: true,
        "ajax": {
            "url": "/VacationWish", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        },
        "columns": [
            { "data": "vacationWishId" },
            { "data": "description" },
            { "data": "place" }
        ]
    });
}

// Urlaub anlegen
function loadDataTable() {
    var table = $('#vacationperiodtable').DataTable({
        destroy: true,
        "ajax": {
            "url": "/Vacation", //URL
            "dataSrc": "" // Cause of flat JsonObjects
        },
        "columns": [
            { "data": "vacationId" },
            { "data": "title" },
            { "data": "timePeriod" }
        ]
    });
}