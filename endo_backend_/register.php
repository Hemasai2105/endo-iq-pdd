<?php
header("Content-Type: application/json");
require 'db_connect.php';

$data = json_decode(file_get_contents("php://input"));

if (isset($data->email) && isset($data->password)) {
    $email = $conn->real_escape_string($data->email);
    $password_hash = password_hash($data->password, PASSWORD_BCRYPT);

    $sql = "INSERT INTO users (email, password_hash) VALUES ('$email', '$password_hash')";

    if ($conn->query($sql) === TRUE) {
        echo json_encode(["status" => "success", "message" => "User created successfully"]);
    } else {
        echo json_encode(["status" => "error", "message" => "Error: " . $conn->error]);
    }
} else {
    echo json_encode(["status" => "error", "message" => "Invalid input data"]);
}
$conn->close();
?>
