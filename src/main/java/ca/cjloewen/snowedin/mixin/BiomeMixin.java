package ca.cjloewen.snowedin.mixin;

import org.spongepowered.asm.mixin.Mixin;

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
	public boolean canSetSnow(WorldView world, BlockPos blockPos) {
		if (blockPos.getY() >= 0 && blockPos.getY() < 256) {
            BlockState blockState = world.getBlockState(blockPos);
            if ((blockState.isAir() || blockState.getCollisionShape(world, blockPos).isEmpty()) && Blocks.SNOW.getDefaultState().canPlaceAt(world, blockPos)) {
               return true;
            }
         }

         return false;
	}
	
	/**
	 * Always snow!
	 */
	public Biome.Precipitation getPrecipitation() {
		return Biome.Precipitation.SNOW;
	}
	
	/**
	 * Ensures it always snows and water freezes.
	 */
	public final float getTemperature(BlockPos blockPos) {
		return -0.5f;
	}
}
