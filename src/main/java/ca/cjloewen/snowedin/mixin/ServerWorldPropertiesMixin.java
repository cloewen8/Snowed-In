package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.LevelProperties;

@Mixin(LevelProperties.class)
public class ServerWorldPropertiesMixin {
	/**
	 * Always (raining) snowing!
	 */
	public boolean isRaining() {
		return true;
	}
}
