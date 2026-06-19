package net.abm.animalbehaviourmod.mixin.accessor;

import net.minecraft.client.particle.Particle;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(Particle.class)
public interface ParticleAccessor {
    @Invoker("setSize")
    void callsetSize(float width, float height);
}

