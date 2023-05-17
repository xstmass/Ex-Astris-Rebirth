package kr.loveholy.exastrisrebirth;


import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import kr.loveholy.exastrisrebirth.compatibility.*;
import kr.loveholy.exastrisrebirth.creativetab.CreativeTabExAstrisRebirth;
import kr.loveholy.exastrisrebirth.gui.GuiHandler;
import kr.loveholy.exastrisrebirth.proxy.CommonProxy;
import kr.loveholy.exastrisrebirth.util.RegistryRecipe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = ExAstrisRebirthData.MODID, version = ExAstrisRebirthData.VERSION, dependencies = ExAstrisRebirthData.DEPENDENCIES)
public class ExAstrisRebirth {
    @Instance(ExAstrisRebirthData.MODID)
    public static ExAstrisRebirth instance;
    public static CreativeTabs TAB = new CreativeTabExAstrisRebirth();

    @SidedProxy(clientSide = "kr.loveholy.exastrisrebirth.proxy.ClientProxy", serverSide = "kr.loveholy.exastrisrebirth.proxy.CommonProxy")
    public static CommonProxy proxy;
    public static Configuration config;
    public static Logger log;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log = LogManager.getLogger(ExAstrisRebirthData.MODNAME);

        ExAstrisRebirthItem.init();
        ExAstrisRebirthBlock.init();

        proxy.initializeRenderers();

        config = new Configuration(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + "ExAstrisRebirth.cfg"));
        config.load();

        ExAstrisRebirthData.load(config);

        MinecraftForge.EVENT_BUS.register(this);

        if (config.hasChanged())
            config.save();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
        FMLInterModComms.sendMessage("Waila", "register", "kr.loveholy.exastrisrebirth.compatibility.ModWaila.callbackRegister");

        RegistryRecipe.craftingRecipe();
        RegistryRecipe.furnaceRecipe();
        RegistryRecipe.removeRecipe();

        if (Loader.isModLoaded("chisel")) {
            log.info("+++ - Found Chisel!");
            ModChisel.sendIMC();
        }
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        if (Loader.isModLoaded("ThermalExpansion")) {
            log.info("+++ - Found ThermalExpansion!");

            ModThermalExpansion.init();
        }

        if (Loader.isModLoaded("WitchingGadgets")) {
            log.info("+++ - Found Witching Gadgets!");

            ModThaumcraft.witchingGadgetsLoaded();
        }

        if (Loader.isModLoaded("Thaumcraft")) {
            log.info("+++ - Found Thaumcraft!");

            ModThaumcraft.init();
        }


        if (Loader.isModLoaded("TConstruct")) {
            log.info("+++ - Found TConstruct!");

            ModTConstruct.init();
        }

        if (Loader.isModLoaded("TSteelworks")) {
            log.info("+++ - Found TSteelworks!");

            ModTSteelworks.init();
        }

        if (Loader.isModLoaded("MineFactoryReloaded")) {
            log.info("+++ - Found MineFactoryReloaded!");

            ModMineFactoryReloaded.init();
        }
        if (Loader.isModLoaded("AWWayofTime")) {

            log.info("+++ - Found Blood Magic!");

            ModBloodMagic.init();
        }

        if (Loader.isModLoaded("Metallurgy")) {

            log.info("+++ - Found Metallurgy!");
            ModMetallurgy.init();
        }

        if (Loader.isModLoaded("arsmagica2")) {

            log.info("+++ - Found Ars Magica!");
            ModArsMagica.init();
        }

        if (Loader.isModLoaded("BigReactors")) {

            log.info("+++ - Found BigReactors!");
            ModBigReactors.init();
        }

        if (Loader.isModLoaded("Natura")) {
            log.info("+++ - Found Natura!");
            ModNatura.init();
        }

        if (Loader.isModLoaded("chisel")) {
            log.info("+++ - Found Chisel!");
            ModChisel.init();
        }

        if (Loader.isModLoaded("Botania")) {
            log.info("+++ - Found Botania!");
            ModBotania.init();
        }

        if (Loader.isModLoaded("DraconicEvolution")) {
            log.info("+++ - Found DraconicEvolution");
            ModDraconicEvolution.init();
        }

        if (Loader.isModLoaded("witchery")) {
            log.info("+++ - Found Witchery");
            ModWitchery.init();
        }
    }
}
