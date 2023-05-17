package kr.loveholy.exastrisrebirth;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.registry.GameRegistry;
import kr.loveholy.exastrisrebirth.block.*;
import kr.loveholy.exastrisrebirth.compatibility.ModThaumcraft;
import kr.loveholy.exastrisrebirth.itemblock.*;
import net.minecraft.block.Block;

public class ExAstrisRebirthBlock {
    public static Block blockSieveAutomatic;
    public static Block blockHammerAutomatic;
    public static Block blockEndCake;
    public static Block blockBeeTrapInfused;
    public static Block blockBarrelTweak;
    public static Block blockBarrelBOP;
    public static Block blockBarrelThaumium;
    public static Block blockBarrelStone;

    public static Block blockHardStone;


    public static Block blockOreCobalt;
    public static Block blockOreArdite;

    public static void init() {
        if (ExAstrisRebirthData.allowSieveAutomatic) {
            blockSieveAutomatic = new BlockSieveAutomatic();
            GameRegistry.registerBlock(blockSieveAutomatic, ItemBlockSieveAutomatic.class, ExAstrisRebirthData.SIEVE_AUTOMATIC);
        }

        if (ExAstrisRebirthData.allowHammerAutomatic) {
            blockHammerAutomatic = new BlockHammerAutomatic();
            GameRegistry.registerBlock(blockHammerAutomatic, ExAstrisRebirthData.HAMMER_AUTOMATIC);
        }

        blockEndCake = new BlockEndCake();
        GameRegistry.registerBlock(blockEndCake, ExAstrisRebirthData.END_CAKE);

        blockBeeTrapInfused = new BlockBeeTrapInfused();
        GameRegistry.registerBlock(blockBeeTrapInfused, ExAstrisRebirthData.BEE_TRAP_INFUSED);

        blockBarrelTweak = new BlockBarrelTweak();
        GameRegistry.registerBlock(blockBarrelTweak, ItemBlockBarrelTweak.class, ExAstrisRebirthData.BARREL_TWEAK);

        if (Loader.isModLoaded("BiomesOPlenty")) {
            blockBarrelBOP = new BlockBarrelBOP();
            GameRegistry.registerBlock(blockBarrelBOP, ItemBlockBarrelBOP.class, ExAstrisRebirthData.BARREL_BOP);
        }

        blockBarrelStone = new BlockBarrelStone();
        GameRegistry.registerBlock(blockBarrelStone, ExAstrisRebirthData.BARREL_STONE);

        if (Loader.isModLoaded("Thaumcraft")) {
            blockBarrelThaumium = ModThaumcraft.blockBarrelThaumium();
            GameRegistry.registerBlock(blockBarrelThaumium, ExAstrisRebirthData.BARREL_THAUMIUM);
        }

        blockHardStone = new BlockHardStone();
        GameRegistry.registerBlock(blockHardStone, ItemBlockHardStone.class, ExAstrisRebirthData.HARD_STONE);

        blockOreCobalt = new BlockOre("blockOreCobalt");
        GameRegistry.registerBlock(blockOreCobalt, ItemBlockOre.class, "blockOreCobalt");

        blockOreArdite = new BlockOre("blockOreArdite");
        GameRegistry.registerBlock(blockOreArdite, ItemBlockOre.class, "blockOreArdite");
    }
}
