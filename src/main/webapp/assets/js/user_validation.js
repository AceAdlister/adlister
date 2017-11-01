"use strict";

$( "#register" ).validate({
    rules: {
        phone: {
            required: true,
            minlength: 10,
            maxlength: 11
        }
    }
});

function checkExist(){
    var username = document.getElementById("username").value;

    $.ajax({
        url: '/exists?username=' + username,
        data: {
            format: 'json'
        },
        error: function() {
            $('#isE').html('<p>An error has occurred</p>');
        },
        dataType: 'json',
        type: 'GET'
    }).done (function(data) {
        console.log(data);
        //postsjson = $.parseJSON(data);

        if (data.exists === 1) {
            $('#isE').css('color', 'red').html('User already exists. Please choose another. :-(');
        }else {
            $('#isE').css('color', 'green').html('That username is available! :-)');
        }

    });
}

function checkExistLogin(){
    var username = document.getElementById("username").value;

    $.ajax({
        url: '/exists?username=' + username,
        data: {
            format: 'json'
        },
        error: function() {
            $('#isE').html('<p>An error has occurred</p>');
        },
        dataType: 'json',
        type: 'GET'
    }).done (function(data) {
        console.log(data);
        //postsjson = $.parseJSON(data);

        if (data.exists === 1) {
            $('#isE').css('color', 'green').html('The username was found! You may continue to login :-)');
        }else {
            $('#isE').css('color', 'red').html("The username was not found, please go register for an account...");
        }

    });
}