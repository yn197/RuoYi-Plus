//package com.ruoyi.framework.mqtt;
//
//import org.eclipse.paho.client.mqttv3.*;
//import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
//
//public class SubscribeSample {
//    public static void main(String[] args) {
//        String broker = "tcp://localhost:1883";
//        String topic = "asdfsdfa";
//        String clientid = "subscribe_client";
//        int qos = 0;
//
//        try {
//            MqttClient client = new MqttClient(broker, clientid, new MemoryPersistence());
//            // 连接参数
//            MqttConnectOptions options = new MqttConnectOptions();
//            options.setUserName("admin");
//            options.setPassword("admin".toCharArray());
//            options.setConnectionTimeout(60);
//            options.setKeepAliveInterval(60);
//            // 设置回调
//            client.setCallback(new MqttCallback() {
//
//                public void connectionLost(Throwable cause) {
//                    System.out.println("connectionLost: " + cause.getMessage());
//                }
//
//                public void messageArrived(String topic, MqttMessage message) {
//                    System.out.println("topic: " + topic);
//                    System.out.println("Qos: " + message.getQos());
//                    System.out.println("message content: " + new String(message.getPayload()));
//                }
//
//                public void deliveryComplete(IMqttDeliveryToken token) {
//                    System.out.println("deliveryComplete---------" + token.isComplete());
//                }
//
//            });
//            client.connect(options);
//            client.subscribe(topic, qos);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
