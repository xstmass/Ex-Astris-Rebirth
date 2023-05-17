package kr.loveholy.exastrisrebirth.compatibility;

import com.emoniph.witchery.Witchery;
import com.emoniph.witchery.entity.EntityCovenWitch;
import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.Fluids;
import exnihilo.registries.BarrelRecipeRegistry;
import exnihilo.registries.SieveRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class ModWitchery {
    public static void init() {
        addSifting();
        if (ExAstrisRebirthData.witcheryEnableCovenWitch)
            BarrelRecipeRegistry.addMobRecipe(Fluids.fluidWitchWater, new ItemStack(GameRegistry.findItem("witchery", "witchhand")), EntityCovenWitch.class, "portal", new ItemStack(GameRegistry.findItem("witchery", "witchhand")));
    }

    private static void addSifting() {
        SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_ARTICHOKE, 0, ExAstrisRebirthData.witcherySeedsChance);//seedsartichoke
        SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_WOLFSBANE, 0, ExAstrisRebirthData.witcherySeedsChance);//seedswolfsbane
        SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_MANDRAKE, 0, ExAstrisRebirthData.witcherySeedsChance);//seedsmandrake
        SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_BELLADONNA, 0, ExAstrisRebirthData.witcherySeedsChance);//seedsbelladonna
        SieveRegistry.register(Blocks.grass, 0, Witchery.Items.SEEDS_SNOWBELL, 0, ExAstrisRebirthData.witcherySeedsChance);//seedssnowbell
    }
}
