import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WolfTest
{
	LevelGenerator beach = new BeachLevel();
	LevelGenerator levelGenerator = new WolfDecorator(beach);
	String beachExpected = "beach";

	@Test
	void beachLevelGenerator(){
		assertTrue(beach.generateLevel().toLowerCase().contains(beachExpected));
	}
	
	@Test
	void wolfTest()
	{
		assertEquals(BeachLevel.BEACH_DESCRIPTION + WolfDecorator.WOLF_DESCRIPTION, levelGenerator.generateLevel());
	}
}
