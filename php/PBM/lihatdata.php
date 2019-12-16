<?php
require_once 'seting.php';


//makan
$query = "Select* from makanan";
$sql = mysqli_query($con, $query);
$araymakan = array();
while ($row = mysqli_fetch_array($sql)) {
    array_push($araymakan, array(
        "id" => $row['id_makanan'],
        "nama_makan" => $row['nama_mkn'],
        "harga_makan" => $row['harga_mkn'],
    ));
}

echo json_encode($araymakan);



mysqli_close($con);
