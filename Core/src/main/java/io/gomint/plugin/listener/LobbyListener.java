package main.java.io.gomint.plugin.listener;


import io.gomint.ChatColor;
import io.gomint.entity.EntityPlayer;
import io.gomint.event.EventHandler;
import io.gomint.event.player.*;
import io.gomint.event.world.BlockPlaceEvent;
import io.gomint.inventory.PlayerInventory;
import io.gomint.inventory.item.*;
import io.gomint.world.Gamemode;
import io.gomint.world.block.Block;

import java.util.EventListener;

public class LobbyListener implements EventListener, io.gomint.event.EventListener
{

    public String prefix = ChatColor.GRAY + "[" + ChatColor.AQUA + "Multilabs" + ChatColor.GRAY + "] " + ChatColor.WHITE;

    @EventHandler
    public void LobbyItems(EntityPlayer event)
    {
        event.getInventory().clear();
        ItemCompass compass = ItemCompass.create(1);
        ItemBlazeRod rod = ItemBlazeRod.create(1);
        ItemChest gadgets = ItemChest.create(1);
        ItemBook book = ItemBook.create(1);
        ItemPumpkin friend = ItemPumpkin.create(1);
        compass.setCustomName(ChatColor.RED + "Kompass");
        rod.setCustomName(ChatColor.YELLOW + "Spieler verstecken");
        gadgets.setCustomName(ChatColor.BLUE + "Items");
        friend.setCustomName(ChatColor.AQUA + "Freunde");
        event.getInventory().setItem(0, compass);
        event.getInventory().setItem(2, rod);
        event.getInventory().setItem(4, gadgets);
        event.getInventory().setItem(6, book);
        event.getInventory().setItem(8, friend);
    }

    @EventHandler
    public void KompassItems(EntityPlayer event)
    {
        event.getInventory().clear();
        ItemStoneSword qsg = ItemStoneSword.create(1);
        ItemBed bedw = ItemBed.create(1);
        ItemDirt sw = ItemDirt.create(1);
        ItemSlimeball back = ItemSlimeball.create(1);
        qsg.setCustomName(ChatColor.AQUA + "QSG");
        bedw.setCustomName(ChatColor.RED + "Bedwars");
        sw.setCustomName(ChatColor.DARK_GREEN + "Skywars");
        back.setCustomName(ChatColor.RED + "Bäääck");
        event.getInventory().setItem(0, qsg);
        event.getInventory().setItem(2, bedw);
        event.getInventory().setItem(4, sw);
        event.getInventory().setItem(8, back);
    }

    @EventHandler
    public void blckplace(BlockPlaceEvent event)
    {
        event.setCancelled(true);
    }

    @EventHandler
    public void GadgetItems(EntityPlayer event)
    {
        event.getInventory().clear();
        ItemFeather fly = ItemFeather.create(1);
        ItemDiamondBoots bootsdia = ItemDiamondBoots.create(1);
        ItemSlimeball back = ItemSlimeball.create(1);
        back.setCustomName(ChatColor.RED + "Bäääck");
        fly.setCustomName(ChatColor.AQUA + "Fliegen" + ChatColor.BLUE + "ON" + ChatColor.WHITE + "/" + ChatColor.RED + "OFF");
        bootsdia.setCustomName(ChatColor.DARK_BLUE + "Partikel");
        event.getInventory().setItem(0, fly);
        event.getInventory().setItem(1, bootsdia);
        event.getInventory().setItem(8, back);

    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event)
    {
        event.getPlayer().getInventory().clear();
        LobbyItems(event.getPlayer());
        event.getPlayer().setGamemode(Gamemode.ADVENTURE);
        event.getPlayer().sendMessage(this.prefix + ChatColor.AQUA + "Willkommen");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event)
    {
        event.getPlayer().setHealth(12);
        this.LobbyItems(event.getPlayer());
    }

    @EventHandler
    public void onRespawn(PlayerRespawnEvent event)
    {
        this.LobbyItems(event.getPlayer());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event)
    {
        ItemStack item = event.getPlayer().getInventory().getItemInHand();
        if (item instanceof ItemCompass)
        {
            this.KompassItems(event.getPlayer());
        }
        if (item instanceof ItemChest)
        {
            this.GadgetItems(event.getPlayer());
        }
        if (item instanceof ItemBook)
        {
            event.getPlayer().sendMessage(this.prefix + "nutze /velo" + "/fly");
        }
        if (item instanceof ItemSlimeball)
        {
            this.LobbyItems(event.getPlayer());
        }
        if (item instanceof Block)
        {
            //Block place off?
        }
        if (item instanceof ItemFeather)
        {
            if (event.getPlayer().getAllowFlight()) {
                event.getPlayer().setAllowFlight(false);
                event.getPlayer().setFlying(false);
                event.getPlayer().sendMessage(ChatColor.RED + "Fly off");
            } else {
                event.getPlayer().setAllowFlight(true);
                event.getPlayer().sendMessage(ChatColor.AQUA + "Fly on");
            }

        }

    }
}