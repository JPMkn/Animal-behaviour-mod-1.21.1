package net.abm.animalbehaviourmod.mixin.particle;

import net.abm.animalbehaviourmod.mixin.accessor.ParticleAccessor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.DripParticle;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(DripParticle.class)
public abstract class ABMNectarDropParticleMixin {

    @Inject(method = "createNectarFallParticle", at = @At("RETURN"))
    private static void animalbehaviourmod$resizeNectar(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed, CallbackInfoReturnable<TextureSheetParticle> cir) {
        TextureSheetParticle particle = cir.getReturnValue();
        if (particle instanceof ParticleAccessor accessor) {
           accessor.callsetSize(0.01F, 0.01F); // tamaño reducido
        }
    }
}
