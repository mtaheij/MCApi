package mc.alk.test.blocks;

import mc.alk.mc.MCItemStack;
import mc.alk.mc.MCLocation;
import mc.alk.mc.blocks.MCChest;
import mc.alk.test.TestBlock;

import org.bukkit.Material;

public class TestChest extends TestBlock implements MCChest{
	MCItemStack[] items;
	public TestChest(MCLocation loc, MCItemStack... items) {
		super(loc, Material.CHEST.getId());
		this.items = items;
	}

	@Override
	public MCItemStack[] getItems() {
		return items;
	}
}
