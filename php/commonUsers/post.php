<?php

   $con = new mysqli("localhost","app_user","UrLefigx^CvBQ5yoZp]LclfZkx3J6rDa","smart_cities");

   if ($con->connect_error) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
      exit();
   }

	$email = $_POST['email'];
	$password = $_POST['password'];
	$name = $_POST['name'];
	$phone = $_POST['phone'];
	$experience = $_POST['experience'];


   echo "1"; 
   if( $result = $con->query("SELECT * FROM common_users where email = '$email'" )) {

       $count = $result->num_rows;


        echo "1"; 

        if ($count >= 1) {
            var_dump(http_response_code(400));
            echo "Email already registered";
        }
        else{
            $result = $con->query("insert into common_users (email, password, name, phone, experience) values ('" . $email . "','" . $password . "','" . $name . "','" . $phone . "'," . $experience  . ")");

            if ($result === TRUE) {
                var_dump(http_response_code(201));
                echo "New record created successfully";
            } else {
                var_dump(http_response_code(400));    
                echo "Error: " . $sql . "<br>" . $conn->error;
            }   
        }
    }
   mysqli_close($con);
?>
