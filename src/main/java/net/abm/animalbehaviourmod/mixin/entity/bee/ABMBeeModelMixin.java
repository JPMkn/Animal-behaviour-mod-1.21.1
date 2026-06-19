package net.abm.animalbehaviourmod.mixin.entity.bee;

import net.minecraft.client.model.BeeModel;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BeeModel.class)
@SuppressWarnings("unused")
public class ABMBeeModelMixin {
    // ── Velocidad de alas ───
    // Vanilla = 120.32113F
    private static final float WING_SPEED = 360.96339F;
    // ────────────────────────────────────────────────────────────────────────

    /**
     * Argumento de multiplicación de ageInTicks en setupAnim.
     * Línea original:
     *   float f = ageInTicks * 120.32113F * ((float)Math.PI / 180F);
     */
    @ModifyArg(
            method = "setupAnim(Lnet/minecraft/world/entity/animal/Bee;FFFFF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/Mth;cos(F)F",
                    ordinal = 0
            ),
            index = 0
    )
    private float animalbehaviourmod$fasterWings(float original) {
        // original = ageInTicks * 120.32113F * (PI/180)
        // Dividimos por la velocidad vanilla y multiplicamos por la nueva
        return original / 120.32113F * WING_SPEED;
    }
}
