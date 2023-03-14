package poolControllerPD;

import poolControllerPD.*;
import java.time.*;

@SuppressWarnings("unused")
public class Chemical 
{
	private float ph;
	private LocalDateTime schedTime;
	
	public Chemical()
	{
		ph = 0;
		schedTime = null;
	}
	
	public Chemical(int phArg, LocalDateTime schedTimeArg)
	{
		ph = phArg;
		schedTime = schedTimeArg;
	}
	
	public void setPH(float phArg)
	{
		ph = phArg;
	}
	
	public float getPH()
	{
		return ph;
	}
	
	public void setSchedTime(LocalDateTime schedArg)
	{
		schedTime = schedArg;
	}
	
	public LocalDateTime getSchedTime()
	{
		return schedTime;
	}
	
	public float scheduleCheckPH(LocalDateTime schedTime)
	{
		if(schedTime == LocalDateTime.now())
			return this.getPH();
		else return this.getPH();
	}
}
