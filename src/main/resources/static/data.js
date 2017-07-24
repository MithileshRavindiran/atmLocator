$(document).ready(function() {

    var mytable = $('#atmLocations').DataTable( {
        "ajax": {
            "url": "./locateAtm",
            "dataSrc": ""
        },
        columns: [
            { data: "address.street" },
            { data: "address.housenumber" },
            { data: "address.postalcode" },
            { data: "address.city" },
            { data: "address.geoLocation.latitude" },
            { data: "address.geoLocation.longitude" },
            { data: "distance" },
            { data: "bank" }
        ],
        dom: 'Bfrtip'
    } );

} );