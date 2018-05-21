package grupo1.egibide;

import org.junit.Test;

import static org.junit.Assert.*;

public class JugadorBDTest {

    @Test
    public void salarioTotal() {

        assertEquals(3800, JugadorBD.salarioTotal(2));
    }


}