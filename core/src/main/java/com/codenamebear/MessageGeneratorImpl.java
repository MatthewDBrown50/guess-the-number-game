package com.codenamebear;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator{

    // == Constants ==

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == Fields ==

    @Autowired
    private Game game;

    private int guessCount = 10;

    // == Init Method ==

    @PostConstruct
    private void init(){
        log.info("game value = {}", game);
    }

    // == Public Methods ==

    @Override
    public String getMainMessage() {
        return "getMainMessageCalled";
    }

    @Override
    public String getResultMessage() {
        return "getResultMessageCalled";
    }
}
