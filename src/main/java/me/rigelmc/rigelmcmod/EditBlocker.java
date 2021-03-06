package me.rigelmc.rigelmcmod;

import me.rigelmc.rigelmcmod.player.FPlayer;
import me.rigelmc.rigelmcmod.util.FSync;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class EditBlocker extends FreedomService
{

    public EditBlocker(RigelMCMod plugin)
    {
        super(plugin);
    }

    @Override
    protected void onStart()
    {
    }

    @Override
    protected void onStop()
    {
    }

    @EventHandler(priority = EventPriority.LOW)
    public void BlockPlaceEvent(BlockPlaceEvent event)
    {
        FPlayer fPlayer = plugin.pl.getPlayerSync(event.getPlayer());
        if (!fPlayer.isEditBlock())
        {
            return;
        }

        if (plugin.al.isAdminSync(event.getPlayer()))
        {
            fPlayer.setEditBlocked(false);
            return;
        }

        FSync.playerMsg(event.getPlayer(), ChatColor.RED + "Your ability to place blocks has been disabled!");
        event.setCancelled(true);
    }

    @EventHandler(priority = EventPriority.LOW)
    public void BlockBreakEvent(BlockBreakEvent event)
    {
        FPlayer fPlayer = plugin.pl.getPlayerSync(event.getPlayer());
        if (!fPlayer.isEditBlock())
        {
            return;
        }

        if (plugin.al.isAdminSync(event.getPlayer()))
        {
            fPlayer.setEditBlocked(false);
            return;
        }

        FSync.playerMsg(event.getPlayer(), ChatColor.RED + "Your ability to destroy blocks has been disabled!");
        event.setCancelled(true);
    }

}
