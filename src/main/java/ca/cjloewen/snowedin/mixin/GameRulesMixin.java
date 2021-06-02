package ca.cjloewen.snowedin.mixin;

import java.util.HashMap;
import java.util.Map;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ca.cjloewen.snowedin.world.SnowedInGameRules;
import net.minecraft.world.GameRules;

@Mixin(GameRules.class)
public class GameRulesMixin {
	@Shadow
	@Final
	private static Map<GameRules.Key<?>, GameRules.Type<?>> RULE_TYPES;
	@Shadow
	@Final
	private Map<GameRules.Key<?>, GameRules.Rule<?>> rules;
	
	@Inject(method = "<init>()V", at = @At("TAIL"))
	public void postConstruct(CallbackInfo callback) {
		// Hate having to replace the map, but Mojang forced my hand by making it immutable with no way to add new game rules!
		// Should really be a registry.
		Map<GameRules.Key<?>, GameRules.Rule<?>> newRules = new HashMap<GameRules.Key<?>, GameRules.Rule<?>>();
		GameRules.Type<GameRules.BooleanRule> doPileSnowType = GameRulesBooleanMixin.invokeCreate(true);
		GameRules.Type<GameRules.IntRule> snowPileHeightType = GameRulesIntMixin.invokeCreate(3);
		newRules.putAll(this.rules);
		newRules.put(SnowedInGameRules.DO_PILE_SNOW, doPileSnowType.createRule());
		RULE_TYPES.put(SnowedInGameRules.DO_PILE_SNOW, doPileSnowType);
		newRules.put(SnowedInGameRules.SNOW_PILE_HEIGHT, snowPileHeightType.createRule());
		RULE_TYPES.put(SnowedInGameRules.SNOW_PILE_HEIGHT, snowPileHeightType);
		this.rules = newRules;
	}
}
