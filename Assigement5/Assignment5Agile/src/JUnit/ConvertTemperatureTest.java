package JUnit;

import junit.framework.TestCase;
import validate.ConvertTemperatureImpl;

public class ConvertTemperatureTest extends TestCase{
	ConvertTemperatureImpl impl = new ConvertTemperatureImpl();
//	Test Number : 1
//	Test Objective: Valid Celsius Min value
//	Test Type : jUnit
//	Input (s) : -273.15
//	Expected Output : true
	
	public void testCelsiusValid() {
		assertEquals(true, impl.validateCelsius("-273.15"));
	}
	
//	Test Number : 2
//	Test Objective: InValid Celsius value
//	Test Type : jUnit
//	Input (s) : -273.16 (1 value lower than -273.15) 
//	Expected Output : false
	public void testCelsiusInvalidLower1() {
		assertEquals(false, impl.validateCelsius("-273.16"));
	}
	
//	Test Number : 3
//	Test Objective: InValid Celsius value (Negative value)
//	Test Type : jUnit
//	Input (s) : Minimum Double
//	Expected Output : false
	public void testCelsiusInvalidLower2() {
		String str = String.valueOf(Double.MIN_VALUE);
		assertEquals(false, impl.validateCelsius((str)));
	}

//	Test Number : 4
//	Test Objective: Valid Celsius Maximum value
//	Test Type : jUnit
//	Input (s) : 100
//	Expected Output : True
	public void testCelsiusValidUpper() {
		assertEquals(true, impl.validateCelsius("100"));
	}
	
//	Test Number : 5
//	Test Objective: InValid Celsius 
//	Test Type : jUnit
//	Input (s) : 100.01
//	Expected Output : False
	public void testCelsiusInvalidUpper1() {
		assertEquals(false, impl.validateCelsius("100.01"));
	}	
	
//	Test Number : 6
//	Test Objective: InValid Celsius 
//	Test Type : jUnit
//	Input (s) : Double Maximum value
//	Expected Output : False
	public void testCelsiusInvalidUpper2() {
		String str = String.valueOf(Double.MAX_VALUE);
		assertEquals(false, impl.validateCelsius((str)));
	}	
	
//	Test Number : 7
//	Test Objective: Valid Fahrenheit 
//	Test Type : jUnit
//	Input (s) : -459.67
//	Expected Output : True
	public void testFahrenheitValid() {
		assertEquals(true, impl.validateFahrenheit("-459.67"));
	}	
//	Test Number : 8
//	Test Objective: Valid Fahrenheit 
//	Test Type : jUnit
//	Input (s) : 212
//	Expected Output : True
	public void testFahrenheitValidUpper() {
		assertEquals(true, impl.validateFahrenheit("212"));
	}	
//	Test Number : 9
//	Test Objective: InValid Fahrenheit 
//	Test Type : jUnit
//	Input (s) : -459.68
//	Expected Output : False
	public void testFahrenheitInValidLower() {
		assertEquals(false, impl.validateFahrenheit("-459.68"));
	}
//	Test Number : 10
//	Test Objective: InValid Fahrenheit 
//	Test Type : jUnit
//	Input (s) : Minimum Double
//	Expected Output : False
	public void testFahrenheitInValidLower2() {
		String str = String.valueOf(Double.MIN_VALUE);
		assertEquals(false, impl.validateFahrenheit((str)));
	}
//	Test Number : 11
//	Test Objective: InValid Fahrenheit 
//	Test Type : jUnit
//	Input (s) : 212.01 
//	Expected Output : False
	public void testFahrenheitInValidUpper1() {
		assertEquals(false, impl.validateFahrenheit("212.01"));
	}
//	Test Number : 12
//	Test Objective: InValid Fahrenheit 
//	Test Type : jUnit
//	Input (s) : Minimum Double
//	Expected Output : False
	public void testFahrenheitInValidUpper2() {
		String str = String.valueOf(Double.MAX_VALUE);
		assertEquals(false, impl.validateFahrenheit((str)));
	}
//	Test Number : 13
//	Test Objective: Valid Empty
//	Test Type : jUnit
//	Input (s) : Empty Value
//	Expected Output : False
	public void testEmptyValue() {
		assertEquals(false, impl.checkEmptyInput(""));
	}
//	Test Number : 13
//	Test Objective: Valid Empty
//	Test Type : jUnit
//	Input (s) : 15
//	Expected Output : Trues
	public void testNotEmptyValue() {
		assertEquals(true, impl.checkEmptyInput("15"));
	}	
	
	
}
