
public class WolfDecorator extends LevelDecorator
{

	protected static final String WOLF_DESCRIPTION = "Beyond that you see wolves \n";
	
	public WolfDecorator(LevelGenerator level)
	{
		this.level=level;
	}
	
	public String generateLevel()
	{
		return WOLF_DESCRIPTION + level.generateLevel();
	}


}
