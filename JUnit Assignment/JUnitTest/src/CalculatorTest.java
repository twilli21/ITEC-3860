import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest
{
    /*
	 * Passes if the expected value matches the actual value
	 */
	@Test
	public void testAdd()
	{
		new Calculator();
		assertEquals(195, Calculator.add(95,100));
		assertEquals(0, Calculator.add(10,-10));
		assertEquals(-100, Calculator.add(-50,-50));
		assertEquals(-10, Calculator.add(-20,10));
		assertEquals(15, Calculator.add(15,0));
		assertEquals(0, Calculator.add(0,0));
	}
	
	/*
	 * Passes if the unexpected value does not match the actual value
	 * (meaning if the unexpected value were used in an assertEquals()
	 * test case, it would fail)
	 */
	@Test
	public void testAdd2()
	{
		new Calculator();
		assertNotEquals(-5, Calculator.add(95,100));
		assertNotEquals(90, Calculator.add(10,-10));
		assertNotEquals(120, Calculator.add(-50,-50));
		assertNotEquals(10, Calculator.add(-20,10));
		assertNotEquals(5, Calculator.add(15,0));
		assertNotEquals(10, Calculator.add(0,0));
	}
	
    /*
	 * Passes if the expected value matches the actual value
	 */
	@Test
	public void testSub()
	{
		new Calculator();
		assertEquals(-5, Calculator.sub(95,100));
		assertEquals(20, Calculator.sub(10,-10));
		assertEquals(0, Calculator.sub(-50,-50));
		assertEquals(-30, Calculator.sub(-20,10));
		assertEquals(-15, Calculator.sub(0,15));
		assertEquals(0, Calculator.sub(0,0));
	}

	/*
	 * Passes if the unexpected value does not match the actual value
	 * (meaning if the unexpected value were used in an assertEquals()
	 * test case, it would fail)
	 */
	@Test
	public void testSub2()
	{
		new Calculator();
		assertNotEquals(195, Calculator.sub(95,100));
		assertNotEquals(0, Calculator.sub(10,-10));
		assertNotEquals(100, Calculator.sub(-50,-50));
		assertNotEquals(30, Calculator.sub(-20,10));
		assertNotEquals(75, Calculator.sub(0,15));
		assertNotEquals(20, Calculator.sub(0,0));
	}
	
    /*
	 * Passes if the expected value matches the actual value
	 */
	@Test
	public void testMul()
	{
		new Calculator();
		assertEquals(9500, Calculator.mul(95,100));
		assertEquals(-100, Calculator.mul(10,-10));
		assertEquals(2500, Calculator.mul(-50,-50));
		assertEquals(-200, Calculator.mul(-20,10));
		assertEquals(0, Calculator.mul(0,15));
		assertEquals(0, Calculator.mul(0,0));
	}
	
	/*
	 * Passes if the unexpected value does not match the actual value
	 * (meaning if the unexpected value were used in an assertEquals()
	 * test case, it would fail)
	 */
	@Test
	public void testMul2()
	{
		new Calculator();
		assertNotEquals(195, Calculator.mul(95,100));
		assertNotEquals(20, Calculator.mul(10,-10));
		assertNotEquals(100, Calculator.mul(-50,-50));
		assertNotEquals(30, Calculator.mul(-20,10));
		assertNotEquals(19, Calculator.mul(0,15));
		assertNotEquals(10, Calculator.mul(0,0));
	}
	
    /*
	 * Passes if an IllegalArgumentException() is thrown
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testDivInt()
	{
		new Calculator();
		Calculator.divInt(0,0);
		Calculator.divInt(-1,0);
		Calculator.divInt(2,0);
		Calculator.divInt(-3,0);
		Calculator.divInt(4,0);
		Calculator.divInt(-5,0);
	}
	
    /*
	 * Passes if the expected value matches the actual value
	 */
	@Test
	public void testDivInt2()
	{
		new Calculator();
		assertEquals(0, Calculator.divInt(95,100));
		assertEquals(-1, Calculator.divInt(10,-10));
		assertEquals(1, Calculator.divInt(-50,-50));
		assertEquals(-2, Calculator.divInt(-20,10));
		assertEquals(0, Calculator.divInt(0,15));
	}
	
	/*
	 * Passes if the unexpected value does not match the actual value
	 * (meaning if the unexpected value were used in an assertEquals()
	 * test case, it would fail)
	 */
	@Test
	public void testDivInt3()
	{
		new Calculator();
		assertNotEquals(1, Calculator.divInt(95,100));
		assertNotEquals(0, Calculator.divInt(10,-10));
		assertNotEquals(5, Calculator.divInt(-50,-50));
		assertNotEquals(7, Calculator.divInt(-20,10));
		assertNotEquals(2, Calculator.divInt(0,15));
	}
}