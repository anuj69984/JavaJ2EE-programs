package assignment_01;

/**
 * @author Anuj2.Kumar
 */

import java.io.PrintWriter;
import java.util.Observable;
import java.util.Observer;

//Observer
public class WeatherReport implements Observer {
	int observerNumber;
	public WeatherReport(int observerNumber)
	{
		this.observerNumber=observerNumber;
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		System.out.println("Observer "+observerNumber+"; current temprature is "+arg1+" degrees.");
	}

}
