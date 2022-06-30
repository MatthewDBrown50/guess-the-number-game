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

    private final Game game;

    // == Constructors ==

    @Autowired
    public MessageGeneratorImpl(Game game) {
        this.game = game;
    }

    // == Init Method ==

    @PostConstruct
    private void init(){
        log.info("game value = {}", game);
    }

    // == Public Methods ==

    @Override
    public String getMainMessage() {
        return "Number is between " +
                game.getSmallest() +
                " and " +
                game.getBiggest() +
                ". Can you guess it?";
    }

    @Override
    public String getResultMessage() {
        if(game.isGameWon()){

            return "You guessed it! The number was " +
                    game.getNumber() +
                    "!";

        } else if(game.isGameLost()){

            return "You lost. The number was " +
                    game.getNumber() +
                    "!";

        } else if(!game.isValidNumberRange()){

            return "Invalid number!";

        } else if(game.getRemainingGuesses() == game.getGuessCount()){

            return "What is your first guess?";

        }

        String direction = "Lower";

        if(game.getGuess() < game.getNumber()){

            direction = "Higher";

        }

        String guessWord = "guesses";

        if(game.getRemainingGuesses() == 1){

            guessWord = "guess";

        }

        return "Guess " +
                direction +
                "! You have " +
                game.getRemainingGuesses() +
                " " +
                guessWord +
                " left!";
    }
}
