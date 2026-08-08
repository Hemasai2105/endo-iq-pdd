<?php
header("Content-Type: application/json");
require 'db_connect.php';

$sql = "SELECT * FROM patients ORDER BY created_at DESC";
$result = $conn->query($sql);

$patients = [];
if ($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        // Decode JSON fields back to arrays
        $row['selected_teeth'] = json_decode($row['selected_teeth']);
        $row['conditions'] = json_decode($row['conditions']);
        $patients[] = $row;
    }
}

echo json_encode(["status" => "success", "data" => $patients]);
$conn->close();
?>
