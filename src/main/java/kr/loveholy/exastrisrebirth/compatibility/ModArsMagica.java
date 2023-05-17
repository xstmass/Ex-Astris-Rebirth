package kr.loveholy.exastrisrebirth.compatibility;

import am2.blocks.BlocksCommonProxy;
import am2.items.ItemsCommonProxy;
import exnihilo.ENBlocks;
import exnihilo.Fluids;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.HeatRegistry;
import exnihilo.registries.SieveRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.init.Blocks;

public class ModArsMagica {
    public static void init() {
        addSieveRegistry();
        addHeatRegistry();
        addBarrelRegistry();
    }

    public static void addSieveRegistry() {
        SieveRegistry.register(Blocks.sand, 0, ItemsCommonProxy.itemOre, 0, ExAstrisRebirthData.oreAM2Chance);
        SieveRegistry.register(Blocks.sand, 0, ItemsCommonProxy.itemOre, 4, ExAstrisRebirthData.oreAM2Chance);
        SieveRegistry.register(Blocks.sand, 0, ItemsCommonProxy.itemOre, 5, ExAstrisRebirthData.oreAM2Chance);
        SieveRegistry.register(ENBlocks.NetherGravel, 0, ItemsCommonProxy.itemOre, 6, ExAstrisRebirthData.oreAM2Chance);
    }

    public static void addHeatRegistry() {
        if (ExAstrisRebirthData.allowAM2Heat) {
            HeatRegistry.register(BlocksCommonProxy.vinteumTorch, 0.1F);
        }
    }

    public static void addBarrelRegistry() {
        if (ExAstrisRebirthData.allowAM2Barrel) {
            BarrelRecipeRegistry.addFluidTransformRecipe(Fluids.fluidWitchWater, BlocksCommonProxy.AMOres, 6, BlocksCommonProxy.liquidEssence.getFluid());
        }
    }
}
