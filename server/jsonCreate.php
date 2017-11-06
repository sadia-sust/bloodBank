<?php
include "dbconfig.php";
//mysql_query("INSERT into users values(1047,'h','gfga','a','a','a','a');");
$sqldata = mysql_query("SELECT * FROM users;");

$rows = array();
while($r = mysql_fetch_assoc($sqldata)) {
  $rows[] = $r;
}

echo json_encode($rows);
   //
   ?>