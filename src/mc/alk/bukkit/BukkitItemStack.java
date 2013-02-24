package mc.alk.bukkit;

import java.util.HashMap;
import java.util.Map;

import mc.alk.mc.MCItemStack;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class BukkitItemStack implements MCItemStack{
	ItemStack itemStack;

	public BukkitItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
	}

	@Override
	public void setType(int id) {
		itemStack.setTypeId(id);
	}

	@Override
	public int getType() {
		return itemStack.getTypeId();
	}

	@Override
	public void setDataValue(short value) {
		itemStack.setDurability(value);
	}

	@Override
	public short getDataValue() {
		return itemStack.getDurability();
	}

	@Override
	public int getQuantity() {
		return itemStack.getAmount();
	}

	@Override
	public Map<Integer, Integer> getEnchantments() {
		Map<Integer, Integer> encs = new HashMap<Integer,Integer>();
        for (Map.Entry<Enchantment, Integer> entry : itemStack.getEnchantments().entrySet()) {
            encs.put(entry.getKey().getId(), entry.getValue());}
        return encs;
	}
}
