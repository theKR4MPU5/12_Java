import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IntegerDecodeTest {
    @Test
    public void testLength(){
        Assertions.assertThrows(NumberFormatException.class,() -> Integer.decode(""));
    }

    @Test
    public void testIsPositiveValue(){
        Assertions.assertEquals(1, Integer.decode("+1"));
    }

    @Test
    public void testIsNegativeValue(){
        Assertions.assertEquals(-1, Integer.decode("-1"));
    }

    @Test
    public void testIsHexRadix(){
        Assertions.assertEquals(18, Integer.decode("0x12"));
        Assertions.assertEquals(18, Integer.decode("0X12"));
        Assertions.assertEquals(18, Integer.decode("#12"));
    }

    @Test
    public void testIsOctRadix(){
        Assertions.assertEquals(18, Integer.decode("022"));
    }

    @Test
    public void testWrongPosition(){
        Assertions.assertThrows(NumberFormatException.class,() -> Integer.decode("++1"));
        Assertions.assertThrows(NumberFormatException.class,() -> Integer.decode("--1"));
    }

    @Test
    public void testConstant(){
        Assertions.assertEquals(Integer.MIN_VALUE, Integer.decode(Integer.toString(Integer.MIN_VALUE)));
        Assertions.assertEquals(Integer.MAX_VALUE, Integer.decode(Integer.toString(Integer.MAX_VALUE)));
    }

    @Test
    public void testRandomString(){
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("         "));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("sadqwrasd"));
        Assertions.assertThrows(NumberFormatException.class, () -> Integer.decode("_"));
    }
}
