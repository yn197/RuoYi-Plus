package com.ruoyi.web.visualserialport;

import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;

public class SerialReceiver {
    public static void main(String[] args) {
        SerialPort serialPort = SerialPort.getCommPort("COM3"); // 串口名，根据您的配置更改
        serialPort.openPort();
        serialPort.setComPortParameters(9600, 8, 1, 0); // 设置波特率、数据位、停止位和校验位

        serialPort.addDataListener(new SerialPortDataListener() {
            @Override
            public int getListeningEvents() {
                return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
            }

            @Override
            public void serialEvent(SerialPortEvent event) {
                if (event.getEventType() == SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                    byte[] newData = new byte[serialPort.bytesAvailable()];
                    int numRead = serialPort.readBytes(newData, newData.length);

                    String receivedData = new String(newData, 0, numRead);
                    System.out.println("Received Data: " + receivedData);
                }
            }
        });

        while (true) {
            // 继续监听串口数据
        }
    }
}

