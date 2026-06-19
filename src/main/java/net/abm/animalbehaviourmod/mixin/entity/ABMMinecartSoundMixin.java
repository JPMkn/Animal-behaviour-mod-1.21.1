package net.abm.animalbehaviourmod.mixin.entity;

import net.minecraft.client.resources.sounds.MinecartSoundInstance;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(MinecartSoundInstance.class)
public class ABMMinecartSoundMixin {
    private static final float VOLUME_FACTOR = 0.2F;

    // Intercepta la asignación de volumen en tick()
    @ModifyVariable(
            method = "tick",
            at = @At("STORE"),
            ordinal = 0 // primer float almacenado en this.volume
    )
    private float animalbehaviourmod$lowerMinecartVolume(float original) {
        return original * VOLUME_FACTOR;
    }
}


