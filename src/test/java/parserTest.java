import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class parserTest {

    @Test
    public void testParseString(){
        assertEquals(Parser.parseString("1+2"),3);
    }
    @Test
    public void testParseStringNegFirst(){
        assertEquals(Parser.parseString("-1+2"),1);
    }
    @Test
    public void testParseStringNeg(){
        assertEquals(Parser.parseString("1-2"),-1);
    }
    @Test
    public void testParseStringDoubleNeg(){
        assertEquals(Parser.parseString("1--2"),3);
    }
    @Test
    public void testParseStringMul(){
        assertEquals(Parser.parseString("1*2"),2);
    }
    @Test
    public void testParseStringMulNeg(){
        assertEquals(Parser.parseString("1*-2"),-2);
    }
}
