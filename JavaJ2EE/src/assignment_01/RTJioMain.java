package assignment_01;

/**
 * 
 * @author Anuj2.Kumar
 *
 */

public class RTJioMain {
	public static void main(String[] args) {
		MumbaiWeather mumbaiWeather1=new MumbaiWeather();
		MumbaiWeather mumbaiWeather2=new MumbaiWeather();
		MumbaiWeather mumbaiWeather3=new MumbaiWeather();

		WeatherReport weatherReport1=new WeatherReport(1);
		WeatherReport weatherReport2=new WeatherReport(2);
		WeatherReport weatherReport3=new WeatherReport(3);
		WeatherReport weatherReport4=new WeatherReport(4);
		
		mumbaiWeather1.addObserver(weatherReport1);
		mumbaiWeather1.addObserver(weatherReport2);
		mumbaiWeather1.addObserver(weatherReport3);
		mumbaiWeather1.addObserver(weatherReport4);
		mumbaiWeather1.notify(32);
		
		mumbaiWeather2.addObserver(weatherReport1);
		mumbaiWeather2.addObserver(weatherReport2);
		mumbaiWeather2.addObserver(weatherReport3);
		mumbaiWeather2.addObserver(weatherReport4);
		mumbaiWeather2.notify(31);
		
		mumbaiWeather3.addObserver(weatherReport1);
		mumbaiWeather3.addObserver(weatherReport2);
		mumbaiWeather3.addObserver(weatherReport3);
		mumbaiWeather3.addObserver(weatherReport4);
		mumbaiWeather3.notify(30);
		
		//mumbaiWeather1.addObserver(arg0);
	}


}
