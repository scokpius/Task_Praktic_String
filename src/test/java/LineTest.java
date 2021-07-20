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
                {new Line(null), false},
                {new Line("hfbcnd73lc8sw"), false}, // содержит 2 повторяющихся символа
                {new Line("hSbnS73lc8Sw"), false}, // содержит 3 повторяющихся символа
                {new Line("h7bcnS73lc8Sw"), false},
                {new Line("hello Hello"), false},
                {new Line("hfbnd73l8sw"), true}, // без повторяющихся символов
                {new Line("h"), true},
                {new Line("тркнмтакаму"), false},// содержит 2 повторяющихся символа
                {new Line("ЕнмтЕавкЕ"), false},// содержит 3 повторяющихся символа
                {new Line("ЕнмвтаЕакЕ"), false},
                {new Line("Привет привет"), false},
                {new Line("ысвампирт"), false},
                {new Line("ы"), false},
                {new Line("258471654"), false},
                {new Line("2584716"), true},
                {new Line("5"), true},
                {new Line("+"), false},
                {new Line("+-09ипено"), false},
        });
    }
    @Test
    public void checkingForRepetitions() {
       Assert.assertEquals(result, line.getLine());
    }

}
