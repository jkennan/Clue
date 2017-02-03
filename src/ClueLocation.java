import java.util.*;

public class ClueLocation 
{
	//vars
	private String name;
	private String description;
	private ArrayList<String> exits;
	private ArrayList<String> connectedLocs;

	//constructors
	//partial
	public ClueLocation(String n, String d)
	{
		this.name = n;
		this.description = d;
		this.exits = new ArrayList<String>();
		this.connectedLocs = new ArrayList<String>();
	}

	//getters and setters
	//g/s/print name
	public String getName()
	{
		return this.name;
	}
 	public void setName(String n)
	{
		this.name = n;
	}
 	public void printName()
 	{
 		System.out.println(this.getName());
 	}
 	
 	//g/s description
 	public String getDescription()
 	{
 		return this.description;
 	}
 	public void setDescription(String d)
 	{
 		this.description = d;
 	}
	
	//Add exit
	public void addExit (String newExit, String destination)
	{
		this.connectedLocs.add(destination);
		this.exits.add(newExit);
	}
	
	//remove exit
	public void removeExit (String exit)
	{
		if (this.exits.contains(exit))
		{
			this.connectedLocs.remove(exits.indexOf(exit));
			this.exits.remove(exit); 
		}
	}
	
	//return arraylist  of exits (get func)
	public ArrayList<String> getExits()
	{
		return this.exits;
	}
	
	//return arraylist of connected locs
	public String getConnectedLoc(String exit)
	{
		return this.connectedLocs.get(exits.indexOf(exit));
	}
}

