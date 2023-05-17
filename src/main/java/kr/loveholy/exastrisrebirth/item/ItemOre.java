package kr.loveholy.exastrisrebirth.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import kr.loveholy.exastrisrebirth.ExAstrisRebirth;
import kr.loveholy.exastrisrebirth.ExAstrisRebirthData;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import java.util.List;

public class ItemOre extends Item {

    public String name;
    @SideOnly(Side.CLIENT)
    private IIcon[] icon;
    //private String name = this.getUnlocalizedName().substring(5);

    public ItemOre(String name) {
        super();
        setHasSubtypes(true);
        setCreativeTab(ExAstrisRebirth.TAB);
        this.name = name;
    }

    @Override
    public String getUnlocalizedName(ItemStack item) {
        return this.getUnlocalizedName() + ExAstrisRebirthData.oreType[item.getItemDamage()];
    }


    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public void registerIcons(IIconRegister register) {
        icon = new IIcon[3];

        for (int i = 0; i < icon.length; i++) {
            icon[i] = register.registerIcon(ExAstrisRebirthData.MODID + ":" + ExAstrisRebirthData.oreType[i] + "/" + name + ExAstrisRebirthData.oreType[i]);
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta) {
        return icon[meta];
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @SideOnly(Side.CLIENT)
    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List subItems) {
        for (int i = 0; i < 3; i++) {
            subItems.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    public String getUnlocalizedName() {
        return ExAstrisRebirthData.MODID + "." + name;
    }
}