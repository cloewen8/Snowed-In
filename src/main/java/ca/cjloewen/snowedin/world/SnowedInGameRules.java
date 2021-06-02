package ca.cjloewen.snowedin.world;

import net.minecraft.world.GameRules;

public class SnowedInGameRules {
	public static final GameRules.Key<GameRules.BooleanRule> DO_PILE_SNOW;
	public static final GameRules.Key<GameRules.IntRule> SNOW_PILE_HEIGHT;
	
	static {
		DO_PILE_SNOW = new GameRules.Key<GameRules.BooleanRule>(
			"doPileSnow",
			GameRules.Category.UPDATES);
		SNOW_PILE_HEIGHT = new GameRules.Key<GameRules.IntRule>(
			"snowPileHeight",
			GameRules.Category.MISC);
	}
}
