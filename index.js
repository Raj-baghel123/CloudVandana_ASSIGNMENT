
const express = require("express");
const bodyParser = require("body-parser");
const request = require("request");




const app = express();
app.use(bodyParser.urlencoded({extended:true}));

app.get("/", (req, res)=>{
    res.sendFile(__dirname+"/index.html");
});

app.post("/", (req, res)=>{
    
    var text = req.body.link;
   
    var data = {
        long_url : text,
        group_guid : "o_606vi4k15"
    }
        var jsonData = JSON.stringify(data);
    var options  = {
        url : 'https://api-ssl.bitly.com/v4/shorten',
        method : 'POST',
        headers : {
           'Authorization' : 'Bearer 8c8d00f420189a0e57690ac5d5f46a507cf2c167'      
        },
       body :jsonData

    }







console.log(options);
    request(options, (error, response)=>{
        if(error){
            res.send("wrong");
            console.log(error);
        }
        else if(response.statusCode!=200){
            res.send("wrong code");
            
            console.log(response.body);
            console.log(response.statusCode);
        }
        else{
            res.send("correct");
        }
        
    })


    
})

app.listen(3000, ()=>{
    console.log("server started on port 3000");
});


//8c8d00f420189a0e57690ac5d5f46a507cf2c167