package org.pizzaparrot.chatsounds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class CommandHandler implements CommandExecutor
{
	private final Main plugin;
	public CommandHandler(final Main pl)
	{
		this.plugin = pl;
	}
	
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args)
	{
		if (!(sender.hasPermission("chatsounds.reload")))
		{
			sender.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
			return true;
		}
		if (!(args.length == 1) || !(args[0].equalsIgnoreCase("reload"))) 
		{
			sender.sendMessage(ChatColor.AQUA + "/chatsounds reload " + ChatColor.GRAY + "- reloads plugin configuration");
			return true;
		}
		plugin.reloadConfig();
		plugin.loadConfig();
		sender.sendMessage(ChatColor.AQUA + plugin.getName() + ChatColor.GRAY + " version " + ChatColor.WHITE + plugin.getDescription().getVersion() + ChatColor.GRAY + " has been reloaded.");
		
		if (!(sender instanceof ConsoleCommandSender)) 
		{
	    	Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + plugin.getName() + ChatColor.GRAY + " version " + ChatColor.WHITE + plugin.getDescription().getVersion() + ChatColor.GRAY + " has been reloaded.");
		}
		return true;
	}
}