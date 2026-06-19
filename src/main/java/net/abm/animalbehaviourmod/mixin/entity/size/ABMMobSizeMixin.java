package net.abm.animalbehaviourmod.mixin.entity.size;

import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EntityType.class)
@SuppressWarnings("unused")
public class ABMMobSizeMixin {
    private static final float BEE_SCALE_FACTOR = 0.2f;
    private static final float FROG_SCALEFACTOR = 0.5f;

    @Inject(method = "getDimensions", at = @At("RETURN"), cancellable = true)
    private void animalbehaviourmod$scaleMobSize(CallbackInfoReturnable<EntityDimensions> cir) {
        EntityType<?> self = (EntityType<?>) (Object) this;

        if (self == EntityType.BEE) {
            cir.setReturnValue((cir.getReturnValue().scale(BEE_SCALE_FACTOR)));
        } else if (self == EntityType.FROG) {
            cir.setReturnValue((cir.getReturnValue().scale(FROG_SCALEFACTOR)));
        }
    }
}
