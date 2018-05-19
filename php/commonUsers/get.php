<?php
    class CommonUser {
        public $id;
        public $email;
        public $name;
        public $phone;
        public $experience;
       
       
        function __construct($id,$email,$name, $phone, $experience){
            $this->id = $id;
            $this->email = $email;
            $this->name = $name;
            $this->phone = $phone;
            $this->experience = $experience;   
        }
    }

   $con=mysqli_connect("localhost","app_user","UrLefigx^CvBQ5yoZp]LclfZkx3J6rDa","smart_cities");

   if (mysqli_connect_errno($con)) {
      echo "Failed to connect to MySQL: " . mysqli_connect_error();
   }
	
   $result = mysqli_query($con,"SELECT * FROM common_users where id = " . $_GET['id']);
   $row = mysqli_fetch_array($result);

   $data = new CommonUser($row['id'], $row['email'], $row['name'], $row['phone'], $row['experience']);
    
   echo json_encode($data);
   
	
   mysqli_close($con);
?>
