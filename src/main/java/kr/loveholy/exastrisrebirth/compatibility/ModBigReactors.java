package kr.loveholy.exastrisrebirth.compatibility;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.SieveRegistry;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.init.Blocks;

public class ModBigReactors {
    public static void init() {
        addSieveRegistry();
    }

    public static void addSieveRegistry() {
        SieveRegistry.register(Blocks.sand, 0, GameRegistry.findItem("BigReactors", "BRIngot"), 4, ExAstrisRebirthData.oreYelloriumChance);
    }
}
