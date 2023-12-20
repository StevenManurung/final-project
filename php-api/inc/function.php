<?php

    function get_account_list() {
        global $koneksi;

        $query = "SELECT * FROM akun";

        $query_run = mysqli_query($koneksi, $query);

        if ($query_run) {
            if (mysqli_num_rows($query_run) > 0) {
                
                $res = mysqli_fetch_assoc($query_run);

                $data = [
                    'status' => 200,
                    'message' => "Data fetched successfully!",
                    'data' => $res
                ];
                header("HTTP/1.0 200 OK");
    
                return json_encode($data);
            } else {
                $data = [
                    'status' => 404,
                    'message' => "Data not found!"
                ];
                header("HTTP/1.0 404 Data not found");
    
                return json_encode($data);
            }
        } else {
            $data = [
                'status' => 500,
                'message' => "Internal server problem!"
            ];
            header("HTTP/1.0 500 Internal server problem");

            return json_encode($data);
        }
    }

?>