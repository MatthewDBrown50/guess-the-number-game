package com.codenamebear;


import lombok.AccessLevel;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Getter
@Component
public class NumberGeneratorImpl implements NumberGenerator{

    // == Constants ==

    @Getter(AccessLevel.NONE)
    private final Random random = new Random();
    private final int maxNumber;
    private final int minNumber;

    // == Constructors ==

    @Autowired
    public NumberGeneratorImpl(int maxNumber, int minNumber){
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

    // == Public Methods ==

    @Override
    public int next() {
        return this.random.nextInt(minNumber, maxNumber);
    }

}
