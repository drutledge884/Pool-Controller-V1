package poolControllerPD;

import java.time.Duration;
import java.time.LocalDateTime;
@SuppressWarnings("unused")

public class Lights 
{
	private boolean active;
	private LocalDateTime startTime;
	private Duration runTime;
	
	//default constructor
	public Lights()
	{
		this.active = false;
		this.startTime = null;
		this.runTime = null;
	}
	
	//constructor
	public Lights(boolean activeParam)
	{
		this.active = activeParam;
		if(activeParam)
			this.startTime = LocalDateTime.now();
		else
			this.startTime = null;
		this.runTime = null;
	}
	
	//get active state as a boolean
	public boolean getActive()
	{
		return this.active;
	}
	
	//set active state
	public void setActive(boolean status)
	{
		this.active = status;
		if(status) //if the filter is online
			this.startTime = LocalDateTime.now(); //sets start time to current time as a reference to calculate runtime later
	}
	
	//get run time as a duration
	public Duration getRunTime()
	{
		Duration duration = Duration.between(this.startTime, LocalDateTime.now()); //gets length of time between start time and call time
		this.runTime = duration;
		return duration;
	}
		
	//turns the runtime duration into a string that is usable for the UI
	public String toString()
	{
		int c = this.getRunTime().toMinutesPart();
		String str = String.valueOf(c);
		String durationString = new String(str + " minute(s)");
		return durationString;
	}
}
