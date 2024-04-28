package me.duncanruns.netherrewind.mixin;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.NetherWastesBiome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(NetherWastesBiome.class)
public abstract class NetherWastesBiomeMixin extends Biome {
    protected NetherWastesBiomeMixin(Settings settings) {
        super(settings);
    }

    // Remove striders and piglins
    @Override
    protected void addSpawn(SpawnGroup group, SpawnEntry spawnEntry) {
        EntityType<?> type = spawnEntry.type;
        if (type == EntityType.PIGLIN || type == EntityType.STRIDER) {
            return;
        }
        super.addSpawn(group, spawnEntry);
    }

    // Remove ruined portals and bastions
    @Override
    public void addStructureFeature(ConfiguredStructureFeature<?, ?> f) {
        if (f == DefaultBiomeFeatures.NETHER_RUINED_PORTAL || f == DefaultBiomeFeatures.BASTION_REMNANT) {
            return;
        }
        super.addStructureFeature(f);
    }
}
