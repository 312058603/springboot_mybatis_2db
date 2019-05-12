//package com.wpx.controller;
//
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//
///**
// * Kafka生产者测试(2019.1.3 单机消费者 生产者测试成功)
// */
//@RestController
//@RequestMapping("/KafkaController")
//public class KafkaController {
//
//    @Resource
//    private KafkaTemplate<String, String> kafkaTemplate;
//
//    /**
//     * Kafka生产者
//     * @param msg
//     * @return
//     */
//    @RequestMapping("/KafkaProducer")
//    public String KafkaProducer(String msg) {
//        kafkaTemplate.send("test", msg);
//        return "success";
//    }
//
//}
