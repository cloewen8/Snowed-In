package ca.cjloewen.snowedin.mixin;

import java.util.function.Supplier;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import ca.cjloewen.snowedin.world.SnowedInGameRules;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SnowBlock;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.profiler.Profiler;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.MutableWorldProperties;
import net.minecraft.world.World;
import net.minecraft.world.chunk.WorldChunk;
import net.minecraft.world.dimension.DimensionType;

@Mixin(ServerWorld.class)
public abstract class ServerWorldMixin extends World {
	// Ignored
	protected ServerWorldMixin(MutableWorldProperties properties, RegistryKey<World> registryRef,
			DimensionType dimensionType, Supplier<Profiler> profiler, boolean isClient, boolean debugWorld, long seed) {
		super(properties, registryRef, dimensionType, profiler, isClient, debugWorld, seed);
	}

	@Inject(method = "tickChunk(Lnet/minecraft/world/chunk/WorldChunk;I)V", at = @At("TAIL"))
	public void postTickChunk(WorldChunk chunk, int randomTickSpeed, CallbackInfo callback) {
		Profiler profiler = this.getProfiler();
	    profiler.push("snowPiling");
	    // Pile snow
	    if (this.getGameRules().getBoolean(SnowedInGameRules.DO_PILE_SNOW) && this.random.nextInt(32) == 0) {
	    	ChunkPos chunkPos = chunk.getPos();
	    	// Start from the surface.
			BlockPos topPos = this.getTopPosition(Heightmap.Type.MOTION_BLOCKING,
				this.getRandomPosInChunk(chunkPos.getStartX(), 0, chunkPos.getStartZ(), 15));
			BlockState topState = this.getBlockState(topPos);
			if (topState.isOf(Blocks.SNOW)) {
				int groundLayers = topState.get(SnowBlock.LAYERS);
				int maxHeight = this.getGameRules().getInt(SnowedInGameRules.SNOW_PILE_HEIGHT);
				int height = 1;
				// Go up until not solid snow.
				while (topState.isOf(Blocks.SNOW) && groundLayers >= 8) {
					topPos = topPos.up();
					topState = this.getBlockState(topPos);
					if (topState.isOf(Blocks.SNOW))
						groundLayers = topState.get(SnowBlock.LAYERS);
					height++;
				}
				if (maxHeight == 0 || height <= maxHeight) {
					if (topState.isAir())
						// Add snow
						this.setBlockState(topPos, Blocks.SNOW.getDefaultState());
					else if (topState.isOf(Blocks.SNOW))
						// Increase the layers
						this.setBlockState(topPos, topState.with(SnowBlock.LAYERS, groundLayers + 1));
				}
			}
		}
	    profiler.pop();
	}
}
