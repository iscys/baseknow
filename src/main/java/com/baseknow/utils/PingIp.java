package com.baseknow.utils;

import java.net.InetAddress;

public class PingIp {


    public static void main(String[] args)throws Exception {

        Process process;
        boolean reachable = false;
        try {
            String ipAddress = "47.95.245.138";
            process = Runtime.getRuntime().exec("ping " + ipAddress);

            System.out.println(reachable ? "Host is reachable" : "Host is NOT reachable");
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
