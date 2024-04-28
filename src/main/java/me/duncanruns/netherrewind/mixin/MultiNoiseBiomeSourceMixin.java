package me.duncanruns.netherrewind.mixin;

import com.google.common.collect.ImmutableList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.biome.source.MultiNoiseBiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(MultiNoiseBiomeSource.class)
public abstract class MultiNoiseBiomeSourceMixin extends BiomeSource {
    protected MultiNoiseBiomeSourceMixin(List<Biome> biomes) {
        super(biomes);
    }

    @SuppressWarnings("unchecked")
    @Redirect(method = "method_28467", at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableList;of(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableList;"))
    private static <E> ImmutableList<E> onlyWastes(E e1, E e2, E e3, E e4, E e5) {
        return (ImmutableList<E>) ImmutableList.of(Biomes.NETHER_WASTES);
    }
}