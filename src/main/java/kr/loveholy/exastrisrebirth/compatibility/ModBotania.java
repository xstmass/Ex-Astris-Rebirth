package kr.loveholy.exastrisrebirth.compatibility;

import cpw.mods.fml.common.registry.GameRegistry;
import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import kr.loveholy.exastrisrebirth.item.ItemHammerMana;
import net.minecraft.item.Item;

public class ModBotania {
    public static void init() {
        registerColors();
        addCompostables();
    }

    public static void registerColors() {
        if (ExAstrisRebirthData.allowBotaniaComposting) {
            ColorRegistry.register("Botania", new Color("33CC33"));
        }
    }

    public static void addCompostables() {
        if (ExAstrisRebirthData.allowBotaniaComposting) {
            for (int i = 0; i < 16; i++) {
                CompostRegistry.register(GameRegistry.findItem("Botania", "flower"), i, 0.125f, ColorRegistry.color("Botania"));
            }
        }
    }

    public static Item itemHammerMana() {
        return new ItemHammerMana();
    }

}
