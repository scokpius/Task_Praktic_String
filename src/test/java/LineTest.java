import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LineTest {

    private Line line;
    private boolean result;

    public LineTest(Line line, boolean result) {
        this.line = line;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> primeNumbers(){
        return Arrays.asList(new Object[][] {
                {new Line(""), false},
                {new Line("hfbnd73l8sw"), true},
                {new Line("hfbcnd73lc8sw"), false},
                {new Line("тркнмтакаму"), false},
                {new Line("+-09ипено"), false},
        });
    }
    @Test
    public void checkingForRepetitions() {
       Assert.assertEquals(result, line.getLine());
    }

}
