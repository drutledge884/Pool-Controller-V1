package poolControllerTest;

import poolControllerPD.*;
import poolControllerUI.*;

public class PoolTest
{
	public static void main(String args[])
	{
		/*
		 * known bug: when you set the starting state of the filter, pump, and light to false,
		 * the program crashes because run time in all these functions is calculated as soon as
		 * the function is called which means the period between start time and total run time
		 * is pretty much zero the duration function doesn't go lower than nanoseconds and so
		 * can't measure this. Always set the starting states to true.
		 */
		Filter myFilter = new Filter(true);
		Heater myHeater = new Heater(true, 80);
		Pump myPump = new Pump(true);
		Lights myLights = new Lights(true);
		Pool myPool = new Pool(myFilter, myHeater, myPump, myLights);
		PoolFrame.open(myPool);
	}
}
