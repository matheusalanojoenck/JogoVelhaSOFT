package jogodavelha;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public class Computer extends Player{
    private final Random RANDOM = new Random();
    
    public Computer(int player){
        super(player);
        this.player = player;
        System.out.println("Player 'Computer' created");
    }
    
    @Override
    public void play(Board board){
        tentativa(board);
        board.setPosition(attempt, player);
    }
    
    @Override
    public void tentativa(Board board){
        do{
            do{
                System.out.print("Line: ");
                attempt[0] =  RANDOM.nextInt(3)+1;
                             //RANDOM.nextInt(3) + 1;
                
                if( attempt[0] > 3 ||attempt[0] < 1)
                    System.out.println("Invalid line. It's 1, 2 or 3");
                
            }while( attempt[0] > 3 ||attempt[0] < 1);
            
            do{
                System.out.print("Column: ");
                attempt[1] = RANDOM.nextInt(3)+1;
                
                if(attempt[1] > 3 ||attempt[1] < 1)
                    System.out.println("Invalid column. É 1, 2 or 3");
                
            }while(attempt[1] > 3 ||attempt[1] < 1);
            
            attempt[0]--; 
            attempt[1]--;
            
            if(!checkTry(attempt, board))
                System.out.println("Placed already marked. Try other.");
        }while( !checkTry(attempt, board) );
    }
}