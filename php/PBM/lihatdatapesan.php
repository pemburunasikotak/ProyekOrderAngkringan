<?php

require_once 'seting.php';
$query = "Select* from pesan";
$sql = mysqli_query($con, $query);
$aray = array();
while ($row = mysqli_fetch_array($sql)) {
    array_push($aray, array(
        "id" => $row['id_pesan'],
        "id_meja" => $row['id_meja'],
        "id_makanan" => $row['id_makanan'],
        "id_minuman" => $row['id_minuman'],
        "jml_makan" => $row['jml_makan'],
        "jml_minum" => $row['jml_minum'],
    ));
}
echo json_encode($aray);
mysqli_close($con);
