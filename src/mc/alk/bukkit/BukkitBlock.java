package mc.alk.bukkit;

import mc.alk.mc.MCBlock;
import mc.alk.mc.MCLocation;
import mc.alk.mc.MCWorld;

import org.bukkit.block.Block;

public class BukkitBlock implements MCBlock{
	Block b;

	public BukkitBlock(Block block) {
		this.b = block;
	}

	@Override
	public MCWorld getWorld() {
		return new BukkitWorld(b.getWorld());
	}

	@Override
	public MCLocation getLocation() {
		return new BukkitLocation(b.getLocation());
	}

	@Override
	public int getX() {
		return b.getX();
	}

	@Override
	public int getY() {
		return b.getY();
	}

	@Override
	public int getZ() {
		return b.getZ();
	}

	@Override
	public int getType() {
		return b.getTypeId();
	}

}
