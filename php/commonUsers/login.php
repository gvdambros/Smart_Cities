<?php
   $con = new mysqli("localhost","app_user","UrLefigx^CvBQ5yoZp]LclfZkx3J6rDa","smart_cities");

   if ($con->connect_error) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }

	$email = $_POST['email'];
	$password = $_POST['password'];


    $result = $con->query("select * from common_users WHERE email='$email' and password='$password'");
    $count = mysqli_num_rows($result);

    echo $count; 

    if ($count == 1) {
        var_dump(http_response_code(200));
        echo "Login done successfully";
    } elseif ($count > 1) {
        var_dump(http_response_code(500));
        echo "More than one user with the same email";
    } else {
        var_dump(http_response_code(400));    
        echo "Invalid login info";
    }   

   mysqli_close($con);
?>
