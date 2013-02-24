package mc.alk.bukkit;

import mc.alk.mc.MCBlock;
import mc.alk.mc.MCLocation;
import mc.alk.mc.MCWorld;

import org.bukkit.World;

public class BukkitWorld implements MCWorld{
	World world;
	public BukkitWorld(World world){
		this.world = world;
	}

	@Override
	public String getName() {
		return world.getName();
	}

	@Override
	public MCBlock getBlockAt(int x, int y, int z) {
		return new BukkitBlock(world.getBlockAt(x, y, z));
	}

	@Override
	public MCBlock getBlockAt(MCLocation loc) {
		return getBlockAt(loc.getBlockX(),loc.getBlockY(),loc.getBlockZ());
	}

}
