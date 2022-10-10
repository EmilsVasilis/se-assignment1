import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class parserTest {

    @Test
    public void testParseString(){
        assertEquals(Parser.evaluateExp("1+2"),3);
    }

    @Test
    public void testEvaluateExpNeg(){
        assertEquals(Parser.evaluateExp("1-2"),-1);
    }
    @Test
    public void testEvaluateExpDoubleNeg(){
        assertEquals(Parser.evaluateExp("(5-10)*(5-10)"),25);
    }
    @Test
    public void testEvaluateExpMul(){
        assertEquals(Parser.evaluateExp("1*2"),2);
    }

    @Test
    public void testEvaluateExp(){
        assertEquals(Parser.evaluateExp("5+5*5"), 30);
    }

    @Test
    public void testComplexExp(){
        assertEquals(Parser.evaluateExp("10-(5*5)+10"),-5);
    }


    @Test
    public void testPost(){
        String[] test = {"5", "5","5", "*","+"};
        assertEquals(Parser.evaluatePostfix(test), 30);
    }

    @Test
    public void testPostNeg(){
        String[] test = {"5", "5", "-"};
        assertEquals(Parser.evaluatePostfix(test), 0);
    }




}
