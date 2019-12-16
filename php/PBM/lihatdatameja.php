
<?php
require_once 'seting.php';
$query = "Select* from meja";
$sql = mysqli_query($con, $query);
$araymeja = array();
while ($row = mysqli_fetch_array($sql)) {
    array_push($araymeja, array(
        "id" => $row['id_meja'],
        "no_meja" => $row['no_meja'],
    ));
}
echo json_encode($aray);
mysqli_close($con);
