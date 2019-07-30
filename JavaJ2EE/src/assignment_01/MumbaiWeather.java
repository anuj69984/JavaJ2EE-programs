package assignment_01;

/**
 * @author Anuj2.Kumar
 * 
 * 
 */

import java.util.Observable;

//Mumbai Whether is being Observed
public class MumbaiWeather extends Observable {
	int temprature;
	void notify(int temp)
	{
		
		/*
		 * An object that is being observed must follow two simple rules :
				If it is changed, it must call setChanged( ) method.
				When it is ready to notify observers of this change, 
				it must call notifyObservers( ) method. This causes the update( )
				 method in the observing object(s) to be called.
		 */
		setChanged();
		notifyObservers(temp); //notifyObservers() : Notifies all observers of the invoking object
								//that it has changed by calling update( ).
		
		/*
		 * if the object calls notifyObservers( ) method without having previously called
			setChanged( ) method, no action will take place.
		 */
	}

}
