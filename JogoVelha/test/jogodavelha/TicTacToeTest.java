/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author udesc
 */
public class TicTacToeTest {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
        board.jogoTeste();
    }
    
    @Test
    public void rotinaUmTeste(){
        assertEquals(-1, board.won());
    }
}
