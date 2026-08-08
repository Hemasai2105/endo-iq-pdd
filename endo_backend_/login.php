<?php
header("Content-Type: application/json");
require 'db_connect.php';

$data = json_decode(file_get_contents("php://input"));

if (isset($data->email) && isset($data->password)) {
    $email = $conn->real_escape_string($data->email);
    
    $sql = "SELECT id, password_hash FROM users WHERE email='$email'";
    $result = $conn->query($sql);

    if ($result->num_rows > 0) {
        $row = $result->fetch_assoc();
        if (password_verify($data->password, $row['password_hash'])) {
            echo json_encode(["status" => "success", "message" => "Login successful", "user_id" => $row['id']]);
        } else {
            echo json_encode(["status" => "error", "message" => "Invalid password"]);
        }
    } else {
        echo json_encode(["status" => "error", "message" => "User not found"]);
    }
} else {
    echo json_encode(["status" => "error", "message" => "Invalid input data"]);
}
$conn->close();
?>
