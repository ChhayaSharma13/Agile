package validate;

public interface ConvertTemperatureInterface {
	public boolean validateCelsius(String celsius);
	public boolean validateFahrenheit(String fahrenheit);
	//public boolean checkEmptyInput(double temp) ;
	public boolean checkEmptyInput(String temp);
	
	
	
}
