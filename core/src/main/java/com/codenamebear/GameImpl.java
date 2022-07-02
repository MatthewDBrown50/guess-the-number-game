package com.codenamebear;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    // == Constants ==

    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;
    private final int guessCount;

    // == Fields ==

    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;
    @Setter
    private int guess;

    // == Constructors ==

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, int guessCount){
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    // == Init/Destroy Methods ==

    @PostConstruct
    @Override
    public void reset() {
        this.smallest = numberGenerator.getMinNumber();
        this.guess = 0;
        this.remainingGuesses = guessCount;
        this.biggest = numberGenerator.getMaxNumber();
        this.number = numberGenerator.next();
        log.debug("The number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("In Game preDestroy");
    }

    // == Public Methods ==

    @Override
    public void check() {
        checkValidNumberRange();

        if(validNumberRange){
            if(guess > number){
                biggest = guess - 1;
            } else if(guess < number){
                smallest = guess + 1;
            }
        }

        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return this.guess == this.number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == Private Methods ==

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }

}
