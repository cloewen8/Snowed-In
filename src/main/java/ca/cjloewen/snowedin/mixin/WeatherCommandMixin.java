package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.WeatherCommand;
import net.minecraft.text.Text;

@Mixin(WeatherCommand.class)
public class WeatherCommandMixin {
	@Overwrite
	private static int executeClear(ServerCommandSource source, int duration) {
		if (FabricLoader.getInstance().isModLoaded("fabric"))
			source.sendError(Text.translatable("commands.weather.set.snowedin"));
		else
			source.sendError(Text.literal("There is no escape from the snow."));
		return duration;
	}
}
