import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class parserTest {

    @Test
    public void testParseString(){
        assertEquals(Parser.evaluateExp("1+2"),3);
    }

    @Test
    public void testParseStringNeg(){
        assertEquals(Parser.evaluateExp("1-2"),-1);
    }
    @Test
    public void testParseStringDoubleNeg(){
        assertEquals(Parser.evaluateExp("1-2"),-1);
    }
    @Test
    public void testParseStringMul(){
        assertEquals(Parser.evaluateExp("1*2"),2);
    }


    @Test
    public void testPost(){
        String[] test = {"5", "5","5", "*","+"};
        assertEquals(Parser.evaluatePostfix(test), 30);
    }

    @Test
    public void evalExp(){

        assertEquals(Parser.evaluateExp("5+5*5"), 30);
    }
}
