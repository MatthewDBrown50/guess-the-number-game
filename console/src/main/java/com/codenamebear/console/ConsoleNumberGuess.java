package com.codenamebear.console;

import com.codenamebear.Game;
import com.codenamebear.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Slf4j
@Component
public class ConsoleNumberGuess {

    // == Constants ==

    private final Game game;

    private final MessageGenerator messageGenerator;

    // == Constructors ==

    @Autowired
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator){
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // == Public Methods ==

    @EventListener
    public void start(ContextRefreshedEvent event) {

        log.info(event.toString());
        log.info("Container ready for use.");

        Scanner scanner = new Scanner(System.in);

        while(true){

            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());

            int guess = scanner.nextInt();
            scanner.nextLine();

            game.setGuess(guess);
            game.check();

            if(game.isGameWon() || game.isGameLost()){
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again? y/n");

                char userChoice = scanner.nextLine().trim().charAt(0);
                boolean playAgain = (userChoice == 'y' || userChoice == 'Y');
                if(!playAgain){
                    break;
                }

                game.reset();
            }

        }

    }
}
