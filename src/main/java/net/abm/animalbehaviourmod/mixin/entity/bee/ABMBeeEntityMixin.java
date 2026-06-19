package net.abm.animalbehaviourmod.mixin.entity.bee;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/*
@Mixin(EntityType.class)
@SuppressWarnings("unused")
public class ABMBeeEntityMixin {

    private static final float SCALE_FACTOR = 0.2F;

    @Inject(method = "getDimensions", at = @At("RETURN"), cancellable = true)
    private void animalbehaviourmod$scaleBeeSize(CallbackInfoReturnable<EntityDimensions> cir) {
        cir.setReturnValue(cir.getReturnValue().scale(SCALE_FACTOR));
    }
*/
    // ARREGLAR ESTO!!!! D:
/*
    @Inject(method = "<init>", at = @At("TAIL"), cancellable = true)
    private void animalbehaviourmod$onBeeCreated(
            EntityType<? extends Bee> entityType, Level level, CallbackInfo ci) {
        Bee self = (Bee) (Object) this;
        if (self.getPersistentData().getBoolean("animalbehaviourmod_extraBees")) {
            return;
        }
        if (level == null || level.isClientSide()) {
            return;
        }
        ABM_spawnExtraBees(level, self);
    }

    private static void ABM_spawnExtraBees(Level level, Bee originBee) {
        BlockPos pos = originBee.blockPosition();

            for (int i = 0; i < 2; i++) {
                Bee extraBee = new Bee(EntityType.BEE, level);
                extraBee.moveTo(pos.getX() + 0.5, pos.getY(), pos.getZ() + 0.5, 0, 0);
                extraBee.getPersistentData().putBoolean("animalbehaviourmod_extraBees", true);
                level.addFreshEntity(extraBee);
        }
    }

 */

//}