/* 
* Kira Tilcock 
* V00810384
* Assignment1
* 
*/ 


public class Player
{
	private String name;
	private int battingAvg;

	// Purpose:
	// 	Initialize this instance of Player
	// 	set the battingAvg to be 0
	//
	
	public Player(String name)
	{
	
	this.name = name;
	this.battingAvg = 0;
	
	}

	// Purpose:
	//	Initialize this instance of Player
	//
	
	public Player (String name, int battingAvg)
	{
	
	
	this.name = name; 
	this.battingAvg = battingAvg;
		
	}

	// Purpose:
	// 	Change the name associated with this Player
	// 	to be newname
	//
	
	public void setName (String newName)
	{
		name = newName;
	}

	// Purpose:
	//	Return the name associated with this Player
	//
	public String getName()
	{
		return this.name;
	}

	// Purpose:
	//	Change the battingAvg associated with this Player 
	//	to be newbattingAvg
	//	
	public void setBattingAvg (int newBattingAvg){

		this.battingAvg = newBattingAvg;

	}

	// Purpose:
	//	Return the battingAvg associated with this Player
	//
	public int getBattingAvg()
	{
        return this.battingAvg;
	}

	// Purpose:
	//	Compare this instance of Player to other
	//	return true if they are the same.
	//	
	//	We consider two Players to be equal if
	//	their name are the same.  We do NOT consider
	//	the battingAvg.
	//
	
	public boolean equals(Player other)
	{
	
	if(other.getName().equals(this.getName()))
		{
		
		return true; 
		
		}
		
		return false;
		
	}


	// Purpose:
	//	Return a String representation of this Player
	// 
	// Returns:
	//	name: battingAvg
	//	
	
	
public String toString()
	
	{
			String Player = this.name + ":" + this.battingAvg;
			
			return Player;
	}
}
