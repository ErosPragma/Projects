<?php
class Connection {

    private static $connect = NULL;

    public static function getInstance() {
	    $database = "eventsproject";
	    $username = "testroot";
	    $password = "testroot";

            $connect = new mysqli("localhost", $username, $password);

            // Check connection
            if ($connect->connect_error) {
                die("Connection failed: " . $connect->connect_error);
            }
            echo "Connected successfully";


        return Connection::$connect;
    }

    public static function getMySQLDate($date) {
        $date_arr  = explode('-', $date);
        return $date_arr[2] . '-' . $date_arr[1] . '-' . $date_arr[0];
    }
}
