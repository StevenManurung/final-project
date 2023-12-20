<?php
  require_once('inc/open_connection.php');
  
  $id = $_POST['id'];

  //menghapus alamat user berdasarkan id
  $query = "DELETE FROM alamat_user WHERE id = '$id';";

  $query_run = mysqli_query($koneksi, $query);

  if ($query_run) {
        echo json_encode([
        "error" => false,
        "message" => 'Alamat berhasil dihapus!'
        ]);
    } else {
        echo json_encode([
        "error" => true,
        "message" => 'Alamat gagal dihapus!'
        ]);
    }

  require_once('inc/close_connection.php');
?>