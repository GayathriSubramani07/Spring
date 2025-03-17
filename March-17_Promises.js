<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Promise Example</title>
</head>
<body>
    <script>
        let car = new Promise(function(resolve, reject) {
            let fuel_tank = true; // Declare fuel_tank inside the function
            if (fuel_tank)
                resolve("Tank is full");
            else
                reject("Tank is empty");
        });

        car.then(function(message) {
            document.write(message);
        }).catch(function(error) {
            document.write(error);
        });
    </script>
</body>
</html>
