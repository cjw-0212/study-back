package com.scst.controller;

import com.scst.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProduceController {

    @Autowired
    private ProduceService produceService;
    private String topic = "msg-topic";
    private String tag = "TagA";

    @GetMapping("/transactionMessage")
    public void testTransactionMessage() {
        produceService.sendTransactionMessage(topic, tag);
    }

    @GetMapping("/onewayMessage")
    public void testOnewayMessage() {
        produceService.sendOneWayMessage(topic, tag);
    }

    @GetMapping("/syncMessage")
    public void testSyncMessage() {
        produceService.sendSyncMessage(topic, tag);
    }

    @GetMapping("/asyncMessage")
    public void testAsyncMessage() {
        produceService.sendAsyncMessage(topic, tag);
    }

    @GetMapping("/delayMessage")
    public void testDelayMessage() {
        produceService.sendDelayMessage(topic, tag);
    }

    @GetMapping("/orderedMessages")
    public void testOrderedMessages() {
        produceService.sendOrderedMessages(topic, tag);
    }

    @GetMapping("/batchMessages")
    public void testBatchMessages() {
        produceService.sendBatchMessages(topic, tag);
    }
}

