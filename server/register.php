<?php
include "dbconfig.php";

$name = $_GET['name'];
$pass = $_GET['pass'];
//$avail = $_GET['avail'];
$loc = $_GET['loc'];
$grp = $_GET['grp'];
$mob = $_GET['mob'];




mysql_query("INSERT into users values('$name','$loc','$mob','$grp','$pass','yes');");
$sqldata = mysql_query("SELECT * FROM users");

$rows = array();
while($r = mysql_fetch_assoc($sqldata)) {
  $rows[] = $r;
}

echo json_encode($rows);
   //
   ?>