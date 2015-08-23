package mc.alk.bukkit;

import mc.alk.mc.MCBlock;
import mc.alk.mc.MCLocation;
import mc.alk.mc.MCWorld;

import org.bukkit.block.Block;

public class BukkitBlock implements MCBlock{
	Block block;

	public BukkitBlock(Block block) {
		this.block = block;
	}

	@Override
	public MCWorld getWorld() {
		return new BukkitWorld(block.getWorld());
	}

	@Override
	public MCLocation getLocation() {
		return new BukkitLocation(block.getLocation());
	}

	@Override
	public int getX() {
		return block.getX();
	}

	@Override
	public int getY() {
		return block.getY();
	}

	@Override
	public int getZ() {
		return block.getZ();
	}

	@Override
	public int getType() {
		return block.getTypeId();
	}

	@Override
	public void update(boolean b) {
		block.getState().update();
	}

	@Override
	public BukkitBlock clone(){
		return new BukkitBlock(block);
	}

	public Block getBlock() {
		return block;
	}

}
