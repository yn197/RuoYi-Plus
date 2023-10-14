package com.ruoyi.common.kafka;

import com.alibaba.fastjson.JSON;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.StickyAssignor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.transaction.KafkaTransactionManager;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class KafkaServerConfiguration {
    //*****************生产者配置********************
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.producer.retries}")
    private Integer retries;

    @Value("${spring.kafka.producer.acks}")
    private String acks;

    @Value("${spring.kafka.producer.batch-size}")
    private Integer batchSize;

    @Value("${spring.kafka.producer.properties.linger.ms}")
    private Integer lingerMs;

    @Value("${spring.kafka.producer.buffer-memory}")
    private Integer bufferMemory;

    @Value("${spring.kafka.producer.transaction-id-prefix:tx}")
    private String transactionId_Prefix;
    /**
     *  生产者配置信息
     */
    @Bean
    public Map<String, Object> producerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.ACKS_CONFIG, acks);
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.RETRIES_CONFIG, retries);
//        props.put(ProducerConfig.REQUEST_TIMEOUT_MS_CONFIG,1);
        props.put(ProducerConfig.BATCH_SIZE_CONFIG, batchSize);
        props.put(ProducerConfig.LINGER_MS_CONFIG, lingerMs);
        props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, bufferMemory);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
//        props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, CustomizePartitioner.class);
        return props;
    }
    /**
     *  生产者工厂
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs());
        //添加事务id前缀
        producerFactory.transactionCapable();
        producerFactory.setTransactionIdPrefix(transactionId_Prefix);
        return producerFactory;
    }

    @Bean
    public ProducerFactory<String, String> producerFactory1() {
        DefaultKafkaProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(producerConfigs());
        //添加事务id前缀
//        producerFactory.setTransactionIdPrefix(transactionId_Prefix);
        return producerFactory;
    }

    /**
     *  生产者模板
     */
    @Bean(name = "kafkaTemplate")
    @Primary
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory1());
    }

    @Bean(name = "transactionKafkaTemplate")
    public KafkaTemplate<String, String> transactionKafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
    /**
     * kafka开启事务管理器
     */
    @Bean
    public KafkaTransactionManager<String, String> kafkaTransactionManager() {
        return new KafkaTransactionManager<>(producerFactory());
    }

    //****************************消费者配置**************************
    @Value("${spring.kafka.consumer.properties.group.id}")
    private String groupId;

    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private Boolean autoCommit;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    /**
     * 请求有超时时间
     */
    @Value("${spring.kafka.consumer.properties.request.timeout.ms}")
    private Integer requestTimeoutMs;

    /**
     * 建立会话超时时间
     */
    @Value("${spring.kafka.consumer.properties.session.timeout.ms}")
    private Integer sessionTimeoutMs;

    @Value("${spring.kafka.listener.ack-mode}")
    private String ackMode;

    /**
     * 并发消费,表示开启几个线程去消费
     */
    @Value("${spring.kafka.listener.concurrency}")
    private Integer concurrency;

    @Value("${spring.kafka.consumer.max-poll-records}")
    private Integer maxPollRecords;
    /**
     *  消费者配置信息
     */
    @Bean
    public Map<String, Object> consumerConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, autoCommit);
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);
        props.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeoutMs);
        props.put(ConsumerConfig.REQUEST_TIMEOUT_MS_CONFIG, requestTimeoutMs);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY_CONFIG, Collections.singletonList(StickyAssignor.class));
        return props;
    }

    /**
     * 消费者批量工厂
     */
    @Bean
    public KafkaListenerContainerFactory<?> batchFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
        //设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
        factory.setBatchListener(true);
//        factory.setConcurrency(concurrency);
        //AckMode
        /* 当每一条记录被消费者监听器（ListenerConsumer）处理之后提交
                RECORD,
                 当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后提交
                BATCH,
                 当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后，距离上次提交时间大于TIME时提交
                TIME,
                 当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后，被处理record数量大于等于COUNT时提交
                COUNT,
                 TIME |　COUNT　有一个条件满足时提交
                COUNT_TIME,
                 当每一批poll()的数据被消费者监听器（ListenerConsumer）处理之后, 手动调用Acknowledgment.acknowledge()后提交
                MANUAL,
                 手动调用Acknowledgment.acknowledge()后立即提交
                MANUAL_IMMEDIATE,*/
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return factory;
    }

    /**
     * 单条数据消费工厂
     */
    @Bean
    public KafkaListenerContainerFactory<?> singleFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
        //设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        factory.setReplyTemplate(kafkaTemplate());
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    /**
     * 消息过滤工厂
     */
    @Bean("filterContainerFactory2")
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
        //设置提交偏移量的方式 当Acknowledgment.acknowledge()侦听器调用该方法时，立即提交偏移量
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        // 被过滤的消息将被丢弃
        factory.setAckDiscarded(true);
        factory.setBatchListener(true);
        // 消息过滤策略
        factory.setRecordFilterStrategy(consumerRecord -> {
            int i = consumerRecord.value().hashCode();
            if (i % 2 == 0) {
                return false;
            }
            //返回true消息则被过滤
            System.out.println(JSON.toJSONString(consumerRecord.value())+"hashcode is"+i);
            return true;
        });
        return factory;
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory delayContainerFactory(@Autowired ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory container = new ConcurrentKafkaListenerContainerFactory();
        container.setConsumerFactory(consumerFactory);
        //禁止KafkaListener自启动
        container.setAutoStartup(false);
        container.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL);
        return container;
    }

}
