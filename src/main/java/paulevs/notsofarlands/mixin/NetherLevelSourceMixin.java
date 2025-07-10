package paulevs.notsofarlands.mixin;

import net.minecraft.level.source.NetherLevelSource;
import net.minecraft.level.source.OverworldLevelSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArgs;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;
import paulevs.notsofarlands.NotSoFarLands;

@Mixin(NetherLevelSource.class)
public class NetherLevelSourceMixin {
	@ModifyArgs(method = "generate", at = @At(
		value = "INVOKE",
		target = "Lnet/minecraft/level/source/NetherLevelSource;calculateNoise([DIIIIII)[D"
	))
	private void notsofarlands_changeChunkPos(Args args) {
		if (!NotSoFarLands.GEN_NETHER.getValue()) return;
		
		int pos = args.get(1);
		if (pos <= (NotSoFarLands.NETHER_MIN_X.getValue()/4)) {
			pos -= 12550821;
			args.set(1, pos);
		}
		else if (pos >= (NotSoFarLands.NETHER_MAX_X.getValue()/4)) {
			pos += 12550821;
			args.set(1, pos);
		}
		
		pos = args.get(3);
		if (pos <= (NotSoFarLands.NETHER_MIN_Z.getValue()/4)) {
			pos -= 12550821;
			args.set(3, pos);
		}
		else if (pos >= (NotSoFarLands.NETHER_MAX_Z.getValue()/4)) {
			pos += 12550821;
			args.set(3, pos);
		}
	}
}
