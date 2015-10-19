var express = require('express');

var app = express();

app.get('/beer/strongest', function(req, res){
    res.send({
        name: 'Snake Venom',
        brewery: {
            name: 'Brewmeister',
            country: 'Scotland'
        },
        abv: '67.5',
        style: 'English Barleywine',
        capacities: [ 0.275 ]
    });
});

app.listen(8580);