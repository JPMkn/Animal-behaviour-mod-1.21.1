package net.abm.animalbehaviourmod.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.BeeRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.animal.Bee;

public class ABMBeeRenderer extends BeeRenderer {

    private static final float VISUAL_SCALE = 0.2F; // igual que SCALE_FACTOR del mixin
    private static final float VANILLA_SHADOW = 0.35F;

    public ABMBeeRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = VANILLA_SHADOW * VISUAL_SCALE;
    }

    @Override
    protected void scale(Bee entity, PoseStack poseStack, float partialTick) {
        super.scale(entity, poseStack, partialTick);
        poseStack.scale(VISUAL_SCALE, VISUAL_SCALE, VISUAL_SCALE);
    }
}
