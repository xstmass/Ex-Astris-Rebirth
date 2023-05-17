package kr.loveholy.exastrisrebirth.compatibility;

import exnihilo.registries.ColorRegistry;
import exnihilo.registries.CompostRegistry;
import exnihilo.registries.helpers.Color;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import powercrystals.minefactoryreloaded.setup.MFRThings;

public class ModMineFactoryReloaded {
    public static void init() {
        addColorRegistry();
        if (ExAstrisRebirthData.allowMFRCompost) {
            addCompostRegistry();
        }
    }

    public static void addColorRegistry() {
        ColorRegistry.register("rubberwood", new Color("29410A"));
    }

    public static void addCompostRegistry() {

        CompostRegistry.register(MFRThings.rubberSaplingItem, 0, 0.125F, ColorRegistry.color("rubberwood"));
        CompostRegistry.register(MFRThings.rubberSaplingItem, 1, 0.125F, ColorRegistry.color("rubberwood"));
        CompostRegistry.register(MFRThings.rubberLeavesItem, 0, 0.125F, ColorRegistry.color("rubberwood"));
        CompostRegistry.register(MFRThings.rubberLeavesItem, 1, 0.125F, ColorRegistry.color("rubberwood"));

    }
}
