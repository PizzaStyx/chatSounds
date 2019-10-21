package org.pizzaparrot.chatsounds;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
{
	private String sound;
	private double volume;
	private double pitch;
	
	// Default volume = 1.0F, default pitch = 2.0F

	@Override
	public void onEnable()
	{
		loadConfig();
		saveDefaultConfig();
		getCommand("chatsounds").setExecutor(new CommandHandler(this));
		getServer().getPluginManager().registerEvents(new ChatListener(this), this);
	}
    
    public void loadConfig()
    {
		this.sound = getConfig().getString("sound");
		this.volume = getConfig().getDouble("volume");
		this.pitch = getConfig().getDouble("pitch");
    }
	
	public String getSound()
	{
		return this.sound;
	}
	
	public double getVolume()
	{
		return this.volume;
	}
	
	public double getPitch()
	{
		return this.pitch;
	}
}