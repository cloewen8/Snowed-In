package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import net.minecraft.world.GameRules;

@Mixin(GameRules.BooleanRule.class)
public interface GameRulesBooleanMixin {
	@Invoker
	public static GameRules.Type<GameRules.BooleanRule> invokeCreate(boolean initialValue) {
		throw new AssertionError();
	}
}
