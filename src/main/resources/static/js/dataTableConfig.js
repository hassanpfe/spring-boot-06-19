/**
 * 
 */

$(document).ready(function() {
	$('#tableUsers').DataTable();
});


$('#tableUsers').on( 'click', 'tbody tr', function () {
	tableUsers.row( this ).edit( {
        buttons: [
            { label: 'Cancel', fn: function () { this.close(); } },
            'Edit'
        ]
    } );
} );
/*
$(document).ready(function() {
			var data = eval('${listUsers}');
			var table = $('#tableUsers').DataTable({
				"aaData" : data,
				"aoColumns" : [ {
					"mData" : "login"
				}, {
					"mData" : "firstName"
				}, {
					"mData" : "lastName"
				}, {
					"mData" : "birthDate"
				}, {
					"mData" : "email"
				} ]
			});
		});


 */