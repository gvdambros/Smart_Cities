<?php

   $con = new mysqli("localhost","app_user","UrLefigx^CvBQ5yoZp]LclfZkx3J6rDa","smart_cities");

   if ($con->connect_error) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }

	$email = $_POST['email'];
	$name = $_POST['name'];
	$phone = $_POST['phone'];
	$experience = $_POST['experience'];

   $result = $con->query("insert into common_users (email, name, phone, experience) values ('" . $email . "','" . $name . "','" . $phone . "'," . $experience  . ")");

    var_dump(http_response_code(201));

   mysqli_close($con);
?>
