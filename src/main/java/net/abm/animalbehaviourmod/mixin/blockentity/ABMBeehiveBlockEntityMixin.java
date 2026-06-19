package net.abm.animalbehaviourmod.mixin.blockentity;

import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import org.spongepowered.asm.mixin.*;

import java.util.List;


@Mixin(BeehiveBlockEntity.class)
@SuppressWarnings("unused")
public class ABMBeehiveBlockEntityMixin {

    @Shadow @Final
    private List<?> stored;

    @Shadow @Final @Mutable
    public static int MAX_OCCUPANTS = 10;

    @Overwrite
    public boolean isFull() {
        return this.stored.size() >= MAX_OCCUPANTS;
    }
}
