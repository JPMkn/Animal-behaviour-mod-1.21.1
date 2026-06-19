package net.abm.animalbehaviourmod.event;

import net.abm.animalbehaviourmod.entity.renderer.ABMBeeRenderer;
import net.abm.animalbehaviourmod.entity.renderer.ABMFrogRenderer;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = "animalbehaviourmod", value = Dist.CLIENT)
public class ClientEvents {

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityType.BEE, ABMBeeRenderer::new);
    }

    @SubscribeEvent
    public static void onRegisterRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityType.FROG, ABMFrogRenderer::new);
    }
}
