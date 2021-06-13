package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;
import net.minecraft.world.biome.Biome;

@Mixin(Biome.class)
public class BiomeMixin {
	/**
	 * Can snow everywhere, even over non-collidable blocks.
	 */
	@Overwrite
	public boolean canSetSnow(WorldView world, BlockPos blockPos) {
		if (blockPos.getY() >= 0 && blockPos.getY() < 256) {
			BlockState blockState = world.getBlockState(blockPos);
			if ((blockState.isAir() || blockState.getCollisionShape(world, blockPos).isEmpty())
					&& Blocks.SNOW.getDefaultState().canPlaceAt(world, blockPos)) {
				return true;
			}
		}

		return false;
	}
	
	/**
	 * Always snow!
	 */
	@Overwrite
	public Biome.Precipitation getPrecipitation() {
		return Biome.Precipitation.SNOW;
	}
	
	/**
	 * Ensures it always snows and water freezes.
	 */
	@Overwrite
	public final float getTemperature(BlockPos blockPos) {
		return -0.5f;
	}
}
