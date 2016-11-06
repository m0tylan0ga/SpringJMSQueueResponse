/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.models.Queue;
import com.example.models.QueueDao;
import com.example.models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;

@Component
public class MessageQueueReceiver {

    @Autowired
    private QueueDao queueDao;

    static final Logger log = LoggerFactory.getLogger(MessageQueueReceiver.class);

    private static final String ORDER_QUEUE = "order-queue";

    @Transactional(rollbackFor = RuntimeException.class)
    @JmsListener(destination = ORDER_QUEUE, containerFactory = "jmsListenerContainerFactory")
    public void receiveMessage(final Message<User> message) throws JMSException {
//        throw new RuntimeException("Expected runtime exe thrown");
        MessageHeaders headers = message.getHeaders();
        log.info("Application : headers received : {}", headers);
        User response = message.getPayload();
        Queue q = new Queue();
        q.setUser(response);
        queueDao.create(q);
        log.info("Application : response received : {}", response);
    }
}
