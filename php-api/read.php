<?php
  require_once('inc/open_connection.php');
  
  $result = [];

  // menampilkan data alamat user berdasarkan id
  $query = "SELECT id AS id,
            nama AS nama, 
            nohp AS nohp, 
            provinsi AS provinsi, 
            kota AS kota, 
            kecamatan AS kecamatan,
            kodepos AS kodepos,
            namajalan AS namajalan,
            detailalamat AS detailalamat
            FROM alamat_user";

  $query_run = mysqli_query($koneksi, $query);

  while ($row = mysqli_fetch_assoc($query_run)) {
    $result[] = $row;
  }

  echo json_encode($result);

  require_once('inc/close_connection.php');
?>