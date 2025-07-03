package paulevs.notsofarlands.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.level.source.OverworldLevelSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import paulevs.notsofarlands.NotSoFarLands;

@Mixin(OverworldLevelSource.class)
public class OverworldLevelSourceMixin {
	@ModifyArgs(method = "shapeChunk", at = @At(
		value = "INVOKE",
		target = "Lnet/minecraft/level/source/OverworldLevelSource;calculateNoise([DIIIIII)[D"
	))
	private void notsofarlands_changeChunkPos(Args args) {
		if (!NotSoFarLands.GEN_OVERWORLD.getValue()) return;
		
		int pos = args.get(1);
		if (pos <= (NotSoFarLands.OVERWORLD_MIN_X.getValue()/4)) {
			pos -= 12550821;
			args.set(1, pos);
		}
		else if (pos >= (NotSoFarLands.OVERWORLD_MAX_X.getValue()/4)) {
			pos += 12550821;
			args.set(1, pos);
		}
		
		pos = args.get(3);
		if (pos <= (NotSoFarLands.OVERWORLD_MIN_Z.getValue()/4)) {
			pos -= 12550821;
			args.set(3, pos);
		}
		else if (pos >= (NotSoFarLands.OVERWORLD_MAX_Z.getValue()/4)) {
			pos += 12550821;
			args.set(3, pos);
		}
	}
}
