package kr.loveholy.exastrisrebirth.compatibility;

import kr.loveholy.exastrisrebirth.item.ItemCrookRF;
import kr.loveholy.exastrisrebirth.item.ItemHammerRF;
import net.minecraft.item.Item;

public class ModRedstoneArsenal {
    public static void init() {

    }

    public static Item itemHammerRF() {
        return new ItemHammerRF();
    }

    public static Item itemCrookRF() {
        return new ItemCrookRF();
    }
}
