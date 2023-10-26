import calculator.Calculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import javafx.util.Pair;

public class CalculatorTest {
    private Calculator calc;
    private static final double DELTA = 1e-15;

    @Before
    public void setUp(){
        calc = new Calculator();
    }

    @Test
    public void test_add_crct(){
        int a = 1;
        int b = 2;
        int groundTruth = 3;
        Assert.assertEquals(groundTruth, calc.myAdd(a, b));
    }

    @Test
    public void test_add_notcrct(){
        int a = 1;
        int b = 2;
        int groundTruth = 0;
        Assert.assertNotEquals(groundTruth, calc.myAdd(a, b));
    }

    @Test
    public void test_sub_crct(){
        int a = 1;
        int b = 2;
        int groundTruth = -1;
        Assert.assertEquals(groundTruth, calc.mySub(a, b));
    }

    @Test
    public void test_sub_notcrct(){
        int a = 1;
        int b = 2;
        int groundTruth = 0;
        Assert.assertNotEquals(groundTruth, calc.mySub(a, b));
    }

    @Test
    public void test_mul_crct(){
        int a = 1;
        int b = 2;
        int groundTruth = 2;
        Assert.assertEquals(groundTruth, calc.myMul(a, b));
    }

    @Test
    public void test_mul_notcrct(){
        int a = 1;
        int b = 2;
        int groundTruth = 0;
        Assert.assertNotEquals(groundTruth, calc.myMul(a, b));
    }

    @Test
    public void test_div_crct(){
        int a = 1;
        int b = 2;
        double groundTruth = 0.5;
        Pair<Boolean, Double> ans = calc.myDiv(a, b);
        Assert.assertEquals(groundTruth, ans.getValue(), DELTA);
    }

    @Test
    public void test_div_notcrct(){
        int a = 1;
        int b = 2;
        double groundTruth = 0;
        Pair<Boolean, Double> ans = calc.myDiv(a, b);
        Assert.assertNotEquals(groundTruth, ans.getValue(), DELTA);
    }

    @Test
    public void test_wrng_input_div(){
        int a = 1;
        int b = 0;
        boolean groundTruth = false;
        Pair<Boolean, Double> ans = calc.myDiv(a, b);
        Assert.assertEquals(groundTruth, ans.getKey());
    }
}
