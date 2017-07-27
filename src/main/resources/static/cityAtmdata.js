$(document).ready(function() {

    Table = $('#cityAtmLocations').DataTable( {
        data:[],
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
        ]
    } );

    $("#search").click(function (event) {
        // Stop Event Bubbling
        event.preventDefault();
        event.stopPropagation();

        Table.clear().draw();
        var val = $("#cityname").val();
        var url;
        if (val != null && val) {
            url = "./camel-rest-jpa/findAtms/"+ val;
        } else {
            url =  "./getAtmLocations";
        }

        $.ajax({
            url: url,
            type: "get",
            cache: false
        }).done(function (result) {
            Table.rows.add(result).draw();
        }).fail(function (jqXHR, textStatus, errorThrown) {

        });
    });

} );

