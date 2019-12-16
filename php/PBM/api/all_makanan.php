<?php

include("../model/makanan.php");
include("../model/apidata.php");

require_once '../seting.php';

$data_api = new ApiData();

$query = "Select * from makanan";
$sql = mysqli_query($con, $query);

$array_makan = array();
while ($row = mysqli_fetch_array($sql)) {
    $makanan = new Makanan();
    $makanan->id = $row['id_makanan'];
    $makanan->nama = $row['nama_mkn'];
    $makanan->harga = $row['harga_mkn'];
    $makanan->image = "https://www.bbcgoodfood.com/sites/default/files/recipe-collections/collection-image/2013/05/roasted-aubergine-tomato-curry.jpg";
    array_push($array_makan,$makanan);
}

$data_api->data = $array_makan;

echo json_encode($data_api, JSON_UNESCAPED_SLASHES);
mysqli_close($con);

?>
