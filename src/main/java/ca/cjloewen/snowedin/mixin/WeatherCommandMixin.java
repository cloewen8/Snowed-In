package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.WeatherCommand;
import net.minecraft.text.TranslatableText;

@Mixin(WeatherCommand.class)
public class WeatherCommandMixin {
	private static int executeClear(ServerCommandSource source, int duration) {
		source.sendError(new TranslatableText("commands.weather.set.snowedin"));
		return duration;
	}
}
