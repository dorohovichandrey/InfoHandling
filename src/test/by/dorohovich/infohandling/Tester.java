package test.by.dorohovich.infohandling;

import by.dorohovich.infohandling.calculator.client.Calculator;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

/**
 * Created by User on 13.11.2016.
 */
public class Tester {
    @Test
    public void calculatorTest1()
    {
        Calculator calculator=new Calculator();
        int actual=calculator.calculate("3++-2*9--+3");
        int expected=-12;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatorTest2()
    {
        Calculator calculator=new Calculator();
        int actual=calculator.calculate("(3++-2)*9--+3");
        int expected=12;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatorTest3()
    {
        Calculator calculator=new Calculator();
        int actual=calculator.calculate("(++3-2)*9--+3");
        int expected=21;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatorTest4()
    {
        Calculator calculator=new Calculator();
        int actual=calculator.calculate("(-3-2)*9--+3");
        int expected=-42;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatorTest5()
    {
        Calculator calculator=new Calculator();
        int actual=calculator.calculate("-(-3-2)*9--+3");
        int expected=48;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculatorTest6()
    {
        Calculator calculator=new Calculator();
        int actual=calculator.calculate("-(-3-2)*9--+--3");
        int expected=47;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void inFileExistsTest()
    {
        File file=new File("inptoutpt\\inp.txt");
        boolean expected=true;
        boolean actual=file.exists();
    }

    @Test
    public void outFileExistsTest()
    {
        File file=new File("inptoutpt\\outp.txt");
        boolean expected=true;
        boolean actual=file.exists();
    }




}
