<?php

include("model/minuman.php");

require_once 'seting.php';
$query = "Select* from minuman";
$sql = mysqli_query($con, $query);
$arayminum = array();
while ($row = mysqli_fetch_array($sql)) {
    array_push($arayminum, array(
        "id" => $row['id_minuman'],
        "nama_minum" => $row['nama_minum'],
        "harga_minum" => $row['harga_minum'],
    ));
}
echo json_encode($arayminum);
mysqli_close($con);
