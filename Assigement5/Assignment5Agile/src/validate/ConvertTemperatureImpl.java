package validate;

public class ConvertTemperatureImpl implements ConvertTemperatureInterface{

	@Override
	public boolean validateCelsius(String string) {
		double range = Double.parseDouble(string);
		if(range == Double.MIN_VALUE) {
			return false;
		}
		if(range < -273.15 ||range > 100) {
			return false;
		}
		return true;
			
	}

	@Override
	public boolean validateFahrenheit(String string) {
		double range = Double.parseDouble(string);
		if(range == Double.MIN_VALUE) {
			return false;
		}
		if(range < -459.67 || range > 212) {
			return false;
		}
		return true;
	}
	@Override
	public boolean checkEmptyInput(String temp) {
		if(temp.isEmpty())
		{
			return false;
		}
		return true;
	}

	public boolean NegativePeriodCheck(String temp) {
		if(temp == "-" || temp == ".") {
			System.out.println(temp);
			return false;
			
		} return true;
	}
}
