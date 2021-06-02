package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.GameRules;

@Mixin(GameRules.IntRule.class)
public interface GameRulesIntMixin {
	@Invoker
	public static GameRules.Type<GameRules.IntRule> invokeCreate(int initialValue) {
		throw new AssertionError();
	}
}
