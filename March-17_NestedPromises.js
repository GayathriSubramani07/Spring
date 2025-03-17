<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Promise Chain Example</title>
</head>
<body>
   <script>
     let empty_tank = function(){
        return new Promise(function(resolve, reject){
            resolve("The car doesn't have enough fuel..");
        });
     };

     let engine = function(){
        return new Promise(function(resolve, reject){
            resolve("The engine is over heating..");
        });
     };

     let travel = function(){
        return new Promise(function(resolve, reject){
            resolve("The car is not safe for travelling..");
        });
     };

     empty_tank().then(function(message){
        console.log(message);
        return engine(); // Call function
     }).then(function(message){
        console.log(message);
        return travel(); // Call function
     }).then(function(message){
        console.log(message);
        console.log("Done");
     });
   </script>
</body>
</html>
