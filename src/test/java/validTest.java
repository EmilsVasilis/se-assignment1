import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class validTest {
    calcInterface testInterface = new calcInterface();
    String expression = "";
    @Test
    public void testValidExpression() {
        expression = "9+9";
        Assertions.assertEquals(true , testInterface.isValidExpression(expression),
                "Testing if valid expression returns true for isValidExpression function");
        expression = "999+989";
        Assertions.assertEquals(true,testInterface.isValidExpression(expression),
                "Testing if valid expression returns true for isValidExpression function");
        expression = "9+a";
        Assertions.assertEquals(true,testInterface.isValidExpression(expression),
                "Testing if expression with letters returns false for isValidExpression function");
        expression = "';'@+9";
        Assertions.assertEquals(true,testInterface.isValidExpression(expression),
                "Testing if expression with symbols returns false for isValidExpression function");
    }

}
