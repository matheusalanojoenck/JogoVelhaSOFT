package jogodavelha;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrador
 */
public final class Board {
    private final int[][] board;
    
    public Board(){
        this.board = new int[3][3];
        clearBoard();
    }
    
    public void clearBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                board[line][column]=0;
    }
    
    public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){
        
            for(int column=0 ; column<3 ; column++){
                
                if(board[line][column]==-1){
                    System.out.print(" X ");
                }
                if(board[line][column]==1){
                    System.out.print(" O ");
                }
                if(board[line][column]==0){
                    System.out.print("   ");
                }
                
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosition(int[] attempt){
        return board[attempt[0]][attempt[1]];
    }
    
    public void setPosition(int[] attempt, int player){
        if(player == 1)
            board[attempt[0]][attempt[1]] = -1;
        else
            board[attempt[0]][attempt[1]] = 1;
    }

    public int checkLines(){
        for(int line=0 ; line<3 ; line++){

            if( (board[line][0] + board[line][1] + board[line][2]) == -3)
                return -1;
            if( (board[line][0] + board[line][1] + board[line][2]) == 3)
                return 1;
        }
        
        return 0;     
    }
    
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (board[0][column] + board[1][column] + board[2][column]) == -3)
                return -1;
            if( (board[0][column] + board[1][column] + board[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkDiagonals(){
        if( (board[0][0] + board[1][1] + board[2][2]) == -3)
            return -1;
        if( (board[0][0] + board[1][1] + board[2][2]) == 3)
            return 1;
        if( (board[0][2] + board[1][1] + board[2][0]) == -3)
            return -1;
        if( (board[0][2] + board[1][1] + board[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( board[line][column]==0 )
                    return false;
        return true;
    }
    
    public void jogoTeste(){
        board[0][0]=-1;
        board[1][1]= 1;
        board[0][1]=-1;
        board[1][2]= 1;
        board[0][2]=-1;
    }
    
    public int won(){
        if(this.checkLines() == 1)
            return 1;
        if(this.checkColumns() == 1)
            return 1;
        if(this.checkDiagonals() == 1)
            return 1;
        
        if(this.checkLines() == -1)
            return -1;
        if(this.checkColumns() == -1)
            return -1;
        if(this.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }
}