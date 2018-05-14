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
    private final int[][] bord;
    
    public Board(){
        this.bord = new int[3][3];
        clearBoard();
    }
    
    public void clearBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                bord[line][column]=0;
    }
    
    public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){
        
            for(int column=0 ; column<3 ; column++){
                
                if(bord[line][column]==-1){
                    System.out.print(" X ");
                }
                if(bord[line][column]==1){
                    System.out.print(" O ");
                }
                if(bord[line][column]==0){
                    System.out.print("   ");
                }
                
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }

    public int getPosition(int[] attempt){
        return bord[attempt[0]][attempt[1]];
    }
    
    public void setPosition(int[] attempt, int player){
        if(player == 1)
            bord[attempt[0]][attempt[1]] = -1;
        else
            bord[attempt[0]][attempt[1]] = 1;
    }

    public int checkLines(){
        for(int line=0 ; line<3 ; line++){

            if( (bord[line][0] + bord[line][1] + bord[line][2]) == -3)
                return -1;
            if( (bord[line][0] + bord[line][1] + bord[line][2]) == 3)
                return 1;
        }
        
        return 0;     
    }
    
    public int checkColumns(){
        for(int column=0 ; column<3 ; column++){

            if( (bord[0][column] + bord[1][column] + bord[2][column]) == -3)
                return -1;
            if( (bord[0][column] + bord[1][column] + bord[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
    
    public int checkDiagonals(){
        if( (bord[0][0] + bord[1][1] + bord[2][2]) == -3)
            return -1;
        if( (bord[0][0] + bord[1][1] + bord[2][2]) == 3)
            return 1;
        if( (bord[0][2] + bord[1][1] + bord[2][0]) == -3)
            return -1;
        if( (bord[0][2] + bord[1][1] + bord[2][0]) == 3)
            return 1;
        
        return 0;
    }
    
    public boolean fullBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( bord[line][column]==0 )
                    return false;
        return true;
    }
}