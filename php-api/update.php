<?php
  require_once('inc/open_connection.php');

  $id = $_POST['id'];
  $nama = $_POST['nama'];
  $nohp = $_POST['nohp'];
  $provinsi = $_POST['provinsi'];
  $kota = $_POST['kota'];
  $kecamatan = $_POST['kecamatan'];
  $kodepos = $_POST['kodepos'];
  $namajalan = $_POST['namajalan'];
  $detailalamat = $_POST['detailalamat'];

  $query = "UPDATE alamat_user SET 
            nama = '$nama',
            nohp = '$nohp',
            provinsi = '$provinsi',
            kota = '$kota',
            kecamatan = '$kecamatan',
            kodepos = '$kodepos',
            namajalan = '$namajalan',
            detailalamat = '$detailalamat'
  WHERE id = '$id';";

  $query_run = mysqli_query($koneksi, $query);

  if ($query_run) {
        echo json_encode([
        "error" => false,
        "message" => 'Alamat berhasil diubah!'
        ]);
    } else {
        echo json_encode([
        "error" => true,
        "message" => 'Alamat gagal diubah!'
        ]);
    }

  require_once('inc/close_connection.php');
?>