package com.ruoyi.web.visualserialport;

/**
 * @author nisang
 * 2023/11/2 15:52
 * @version 1.0
 * Ruoyi-Cloud-Plus开发小组
 */

import com.fazecast.jSerialComm.SerialPort;

public class SerialSender {
    public static void main(String[] args) {
        SerialPort serialPort = SerialPort.getCommPort("COM2"); // 串口名，根据您的配置更改
        serialPort.openPort();
        serialPort.setComPortParameters(9600, 8, 1, 0); // 设置波特率、数据位、停止位和校验位

        String dataToSend = "Hello, Serial Receiver!";
        byte[] dataBytes = dataToSend.getBytes();

        serialPort.writeBytes(dataBytes, dataBytes.length); // 发送数据

        serialPort.closePort();
    }
}

