<?php
  require_once('inc/open_connection.php');
  
  $nama = $_POST['nama'];
  $nohp = $_POST['nohp'];
  $provinsi = $_POST['provinsi'];
  $kota = $_POST['kota'];
  $kecamatan = $_POST['kecamatan'];
  $kodepos = $_POST['kodepos'];
  $namajalan = $_POST['namajalan'];
  $detailalamat = $_POST['detailalamat'];

  $query = "INSERT INTO alamat_user (nama, nohp, provinsi, kota, kecamatan, kodepos, namajalan, detailalamat) 
            VALUES('$nama', '$nohp', '$provinsi', '$kota', '$kecamatan', '$kodepos', '$namajalan', '$detailalamat');";

  $query_run = mysqli_query($koneksi, $query);

  if ($query_run) {
        echo json_encode([
        "error" => false,
        "message" => 'Alamat berhasil ditambahkan!'
        ]);
    } else {
        echo json_encode([
        "error" => true,
        "message" => 'Alamat gagal ditambahkan'
        ]);
    }

  require_once('inc/close_connection.php');
?>