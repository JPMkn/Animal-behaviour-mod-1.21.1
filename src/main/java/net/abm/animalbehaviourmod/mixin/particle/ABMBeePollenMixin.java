package net.abm.animalbehaviourmod.mixin.particle;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Bee.class)
@SuppressWarnings("unused")
public abstract class ABMBeePollenMixin extends Animal {

    public ABMBeePollenMixin(EntityType<? extends Animal> type, Level level) {
        super(type, level);
    }
    @Shadow
    public abstract boolean hasNectar();

    @Inject(method = "tick", at = @At("TAIL"))
    private void animalbehaviourmod$scalePollenParticlesArea(CallbackInfo ci) {
        if (this.hasNectar()) {
            this.level().addParticle(
                    ParticleTypes.FALLING_NECTAR,
                    this.getX(),
                    this.getY(0.5D),
                    this.getZ(),
                    0.0D, 0.0D, 0.0D
            );
        }
        if (this.hasNectar()) {

        }
    }
    /*
    @Inject(method = "spawnFluidParticle", at = @At("HEAD"), cancellable = true)
    private void animalbehaviourmod$scalePollenParticles(Level level, double startX, double endX, double startZ, double endZ, double posY,
                                                         ParticleOptions particleOption, CallbackInfo ci) {
        ci.cancel();
        level.addParticle(
        new DustParticleOptions(new Vector3f(1.0F, 1.0F, 0.0F), 0.1F),
                Mth.lerp(level.random.nextDouble(), startX, endX),
                posY,
                Mth.lerp(level.random.nextDouble(), startZ, endZ),
                0.0D, 0.0D, 0.0D
        );
    }
     */
}
