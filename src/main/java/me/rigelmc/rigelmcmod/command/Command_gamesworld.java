package me.rigelmc.rigelmcmod.command;

import me.rigelmc.rigelmcmod.config.ConfigEntry;
import me.rigelmc.rigelmcmod.rank.Rank;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = Rank.NON_OP, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "Goto the gamesworld.", usage = "/<command>")
public class Command_gamesworld extends FreedomCommand
{

    @Override
    public boolean run(CommandSender sender, Player playerSender, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (ConfigEntry.FLATLANDS_GENERATE.getBoolean())
        {
            plugin.wm.gw.sendToWorld(playerSender);
        }
        else
        {
            msg("GamesWorld is currently disabled.");
        }
        return true;
    }
}
