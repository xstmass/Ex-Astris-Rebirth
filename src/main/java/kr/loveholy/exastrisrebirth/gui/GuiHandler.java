package kr.loveholy.exastrisrebirth.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import kr.loveholy.exastrisrebirth.tileentity.TileEntityHammerAutomatic;
import kr.loveholy.exastrisrebirth.tileentity.TileEntitySieveAutomatic;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        if (ID == 0) {

            TileEntitySieveAutomatic sieve = (TileEntitySieveAutomatic) world
                    .getTileEntity(x, y, z);
            return new ContainerSieveAutomatic(player.inventory, sieve);

        }
        if (ID == 1) {
            TileEntityHammerAutomatic hammer = (TileEntityHammerAutomatic) world
                    .getTileEntity(x, y, z);
            return new ContainerHammerAutomatic(player.inventory, hammer);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
                                      int x, int y, int z) {
        if (ID == 0) {

            TileEntitySieveAutomatic sieve = (TileEntitySieveAutomatic) world
                    .getTileEntity(x, y, z);
            return new GuiSieveAutomatic(player.inventory, sieve);

        }
        if (ID == 1) {
            TileEntityHammerAutomatic hammer = (TileEntityHammerAutomatic) world
                    .getTileEntity(x, y, z);
            return new GuiHammerAutomatic(player.inventory, hammer);
        }
        return null;
    }
}
