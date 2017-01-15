package Controler;

import static exchangerate.Exchangerate.UAH;
import java.math.BigDecimal;

/**
 *
 * @author Sergey
 */
public class Conversion {

    public String convert(double current) {
        double result = UAH / current;
        String resultString = Double.toString(BigDecimal.valueOf(result).setScale(2, BigDecimal.ROUND_HALF_DOWN).doubleValue());
        return resultString;
    }
}
