$(document).ready(function() {

    var mytable = $('#atmLocations').DataTable( {
        "ajax": {
            "url": "./getAtmLocations",
            "dataSrc": ""
        },
        columns: [
            { data: "address.street",
                "defaultContent": ""},
            { data: "address.housenumber",
                "defaultContent": ""},
            { data: "address.postalcode",
                "defaultContent": ""},
            { data: "address.city",
                "defaultContent": ""},
            { data: "address.geoLocation.latitude",
                "defaultContent": ""},
            { data: "address.geoLocation.longitude",
                "defaultContent": ""},
            { data: "distance",
                "defaultContent": ""},
            { data: "bank",
                "defaultContent": ""}
        ],
        dom: 'Bfrtip'
    } );

} );