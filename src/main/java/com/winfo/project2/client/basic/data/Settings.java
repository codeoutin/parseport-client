package com.winfo.project2.client.basic.data;

import java.io.*;

/**
 * Created by Kevin on 12.06.17.
 */
public class Settings implements Serializable {
    private String ipaddress;
    private String port;

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public String getPort() {
        return port;
    }

}
