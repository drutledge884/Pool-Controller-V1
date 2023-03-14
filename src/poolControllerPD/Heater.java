package poolControllerPD;

public class Heater 
{
	private boolean active;
	private int targetTemp;
	private int readTemp;
	
	//default constructor
	public Heater()
	{
		this.active = false;
		this.targetTemp = 0;
		this.readTemp = 0;
	}
	
	//constructor
	public Heater(boolean activeParam, int targetTempParam)
	{
		this.active = activeParam;
		this.targetTemp = targetTempParam;
		this.readTemp = 0;
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
	}

	//set read temperature as an int
	public void setReadInt(int userTemp)
	{
		this.readTemp = userTemp;
	}
	
	//set target temperature as an int
	public void setTargetInt(int userTemp)
	{
		this.targetTemp = userTemp;
	}
	
	//set read temperature as a string
	public void setReadString(String userTemp)
	{
		this.readTemp = Integer.parseInt(userTemp);
	}

	//set target temperature as a string
	public void setTargetString(String userTemp)
	{
		this.targetTemp = Integer.parseInt(userTemp);
	}

	//returns actual temperature as an int
	public int getReadInt()
	{
		return this.readTemp;
	}
	
	//returns target temperature as an int
	public int getTargetInt()
	{
		return this.targetTemp;
	}
	
	//get current actual temperature as a string
	public String getReadString()
	{
		String str = String.valueOf(this.readTemp);
		return str;
	}
	
	//get the target temperature as a string
	public String getTargetString()
	{
		String str = String.valueOf(this.targetTemp);
		return str;
	}

	//automatically maintain the target temperature
	public void autoMaintain()
	{
		if(readTemp < targetTemp) //if the actual temperature is below the target temperature...
			this.setActive(true); //heater comes on to warm pool to target temperature
		else if(readTemp > targetTemp) //if the actual temperature is above the target temperature...
			this.setActive(false); //the heater turns off and allows it to cool
	}
}
