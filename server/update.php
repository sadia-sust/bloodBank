<?php
include "dbconfig.php";


$mob = $_GET['mob'];
$dt =  date("Y/m/d");
$query = "Select * from users where contact_no = '$mob'";
$res =  mysql_query($query);

$ans = mysql_result($res, 0 ,  'availability');
if($ans=='Yes')
mysql_query("update users set availability = 'No' where contact_no = '$mob';");
else
mysql_query("update users set availability = 'Yes' , last_donated = '$dt' where contact_no = '$mob';");



   //
   ?>