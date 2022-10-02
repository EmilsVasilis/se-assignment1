import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calcTest {

    calc c = new calc();

    @Test
    public void testAdd(){
        assertEquals(4, c.add(2,2));
    }

}
