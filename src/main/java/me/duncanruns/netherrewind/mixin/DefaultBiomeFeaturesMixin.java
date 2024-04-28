package me.duncanruns.netherrewind.mixin;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @Redirect(method = "addNetherMineables", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/gen/feature/DefaultBiomeFeatures;addAncientDebris(Lnet/minecraft/world/biome/Biome;)V"))
    private static void removeAncientDebris(Biome biome) {
    }

    @Redirect(method = "addNetherOres", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;addFeature(Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)V", ordinal = 0))
    private static void removeGold(Biome instance, GenerationStep.Feature step, ConfiguredFeature<?, ?> configuredFeature) {
    }

    @Redirect(method = "addNetherMineables", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/biome/Biome;addFeature(Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)V", ordinal = 1))
    private static void removeBlackstone(Biome instance, GenerationStep.Feature step, ConfiguredFeature<?, ?> configuredFeature) {
    }
}
