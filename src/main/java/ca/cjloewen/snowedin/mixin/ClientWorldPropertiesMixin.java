package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.client.world.ClientWorld.Properties;

@Mixin(Properties.class)
public class ClientWorldPropertiesMixin {
	/**
	 * Always (raining) snowing!
	 */
	public boolean isRaining() {
		return true;
	}
}
