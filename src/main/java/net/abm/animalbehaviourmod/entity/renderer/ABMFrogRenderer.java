package net.abm.animalbehaviourmod.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.FrogRenderer;
import net.minecraft.world.entity.animal.frog.Frog;

public class ABMFrogRenderer extends FrogRenderer {

    private static final float VISUAL_SCALE = 0.5F;
    private static final float VANILLA_SHADOW = 0.31F;

    public ABMFrogRenderer(EntityRendererProvider.Context context) {
        super(context);
        this.shadowRadius = VANILLA_SHADOW * VISUAL_SCALE;
    }

    @Override
    protected void scale(Frog entity, PoseStack poseStack, float partialTick) {
        super.scale(entity, poseStack, partialTick);
        poseStack.scale(VISUAL_SCALE, VISUAL_SCALE, VISUAL_SCALE);
    }
}