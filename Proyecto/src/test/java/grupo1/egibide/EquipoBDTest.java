package grupo1.egibide;

import org.junit.Test;

import static org.junit.Assert.*;

public class EquipoBDTest {

    @Test
    public void contarJugador() { //Cuenta los jugadores que hay en un equipo

        assertEquals(3,EquipoBD.contarJugador(1));
    }
}