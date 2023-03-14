package poolControllerPD;
import poolControllerPD.*;
@SuppressWarnings("unused")

public class Pool 
{
	private Filter filter;	
	private Heater heater;	
	private Pump pump;
	private Lights lights;
	
	//constructor
	public Pool(Filter filterParam, Heater heaterParam, Pump pumpParam, Lights lightsParam)
	{
		//populate pool elements
		this.filter = filterParam;
		this.heater = heaterParam;
		this.pump = pumpParam;
		this.lights = lightsParam;
		// Begin operation
		//this.heater.autoMaintain();
	}
	
	//default constructor
	public Pool()
	{
		// Populate pool elements
		this.filter = new Filter();
		this.heater = new Heater();
		this.pump = new Pump();
		this.lights = new Lights();
		// Begin operation
		this.heater.autoMaintain();
	}
	
	//return filter condition
	public Filter getFilter()
	{
		return this.filter;
	}
	
	//return heater condition
	public Heater getHeater()
	{
		return this.heater;
	}
	
	//return pump condition
	public Pump getPump()
	{
		return this.pump;
	}
	
	//return lights condition
	public Lights getLights()
	{
		return this.lights;
	}
	
	//set filter condition
	public void setFilter(Filter filterParam)
	{
		this.filter = filterParam;
	}
	
	//set heater condition
	public void setHeater(Heater heaterParam)
	{
		this.heater = heaterParam;
	}
	
	//set pump condition
	public void setPump(Pump pumpParam)
	{
		this.pump = pumpParam;
	}
	
	//set light condition
	public void setLights(Lights lightsParam)
	{
		this.lights = lightsParam;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
