package com.gluton.tntdr.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.block.TntBlock;
import net.minecraft.block.piston.PistonBehavior;

/**
 * @author Gluton
 */
@Mixin(TntBlock.class)
public class TntMixin {
	@Inject(method = "getPistonBehavior(Lnet/minecraft/block/BlockState;)Lnet/minecraft/block/piston/PistonBehavior;", at = @At("RETURN"), cancellable = true)
	private void injected(CallbackInfoReturnable<PistonBehavior> cir) {
		cir.setReturnValue(PistonBehavior.PUSH_ONLY);
	}
}
