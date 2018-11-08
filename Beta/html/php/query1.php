<?php
include 'conn.php';
$username = USERNAME; //defined in conenction.php
$password = PASSWORD; //defines in connection.php
// Create connection
$conn = new mysqli("localhost", $username, $password, "swc_one");
//Query
$sql = "SELECT * FROM products order by kategori desc";
// Check connection
//test
if ($conn->connect_error) {
   die("Connection failed: " . $conn->connect_error);
}
//resultsvar
 $result = $conn->query($sql);
 if ($result->num_rows > 0) {
    // output data of each row
    while($row = $result->fetch_assoc()) {
echo "<p>
".$row[nr]"
</p>";
    }
?>
