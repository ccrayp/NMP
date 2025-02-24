import static java.lang.Math.*;

public class Division {
    static public Double function(Double x) {
        return (cos(x-0.5) - pow(x, 3));
    }

    static public Double findRoot(Double leftBorder, Double rightBorder, Double accuracy) {
        while (abs(rightBorder - leftBorder) > 2 * accuracy) {
            Double c = (leftBorder + rightBorder) / 2;
            if (function(leftBorder) * function(c) > 0)
                leftBorder = c;
            else
                rightBorder = c;
        }

        return (leftBorder + rightBorder) / 2;
    }
}