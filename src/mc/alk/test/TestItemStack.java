package mc.alk.test;

import mc.alk.bukkit.BukkitItemStack;

import org.bukkit.inventory.ItemStack;

public class TestItemStack extends BukkitItemStack{

	public TestItemStack(int id) {
		super(new ItemStack(id));
	}

}
