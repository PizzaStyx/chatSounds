package org.pizzaparrot.chatsounds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener
{
	private final Main plugin;
	public ChatListener(final Main pl)
	{
		this.plugin = pl;
	}
	
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e)
    {
    	final String sound = plugin.getSound();
    	final float volume = (float) plugin.getVolume();
    	final float pitch = (float) plugin.getPitch();
    	Player p = e.getPlayer();
    	String message = e.getMessage();
        if(message.contains(""))
        {
            try
            {
                p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
            }
            catch (Exception error)
            {
            	//Bukkit.getConsoleSender().sendMessage(ChatColor.RED + error.toString());
            	Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "ERROR: " + ChatColor.AQUA + "ChatSounds " + ChatColor.RED + "cannot play the configured sound!");
            	Bukkit.getConsoleSender().sendMessage(ChatColor.YELLOW + "Please check the config for outdated/misspelt sound names or invalid volume/pitch values!");
            }
        }
    }
}