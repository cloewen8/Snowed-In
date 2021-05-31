package ca.cjloewen.mod;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

public class Mod implements ModInitializer {
	public static final String NAMESPACE = "mod";
	public static final Logger LOGGER = LogManager.getLogger(NAMESPACE);

	@Override
	public void onInitialize() {
		// Register everything!

		if (FabricLoader.getInstance().getEnvironmentType().equals(EnvType.CLIENT))
			onInitializeClient();
	}

	@Environment(EnvType.CLIENT)
	private void onInitializeClient() {
		// Register everything on the client!
	}
}
