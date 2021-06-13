package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.world.level.LevelProperties;

@Mixin(LevelProperties.class)
public class ServerWorldPropertiesMixin {
	/**
	 * Always (raining) snowing!
	 */
	@Overwrite
	public boolean isRaining() {
		return true;
	}
}
