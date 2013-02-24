package mc.alk.bukkit;

import mc.alk.mc.MCServer;
import mc.alk.mc.MCLocation;
import mc.alk.mc.MCPlugin;
import mc.alk.mc.MCWorld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class BukkitAPI extends MCServer{

	@Override
	public MCLocation getMCLocation(String world, int x, int y, int z) {
		return new BukkitLocation(world,x,y,z);
	}

	@Override
	public MCWorld getMCWorld(String world) {
		return new BukkitWorld(Bukkit.getWorld(world));
	}

	@Override
	public long scheduleSyncTask(MCPlugin plugin, Runnable runnable) {
		return Bukkit.getScheduler().scheduleSyncDelayedTask((JavaPlugin) plugin, runnable);
	}

}
