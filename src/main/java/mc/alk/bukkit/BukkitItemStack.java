package mc.alk.bukkit;

import java.util.HashMap;
import java.util.Map;

import mc.alk.bukkit.util.BukkitInventoryUtil;
import mc.alk.mc.MCItemStack;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class BukkitItemStack implements MCItemStack{
	ItemStack itemStack;

	public BukkitItemStack(ItemStack itemStack) {
		this.itemStack = itemStack == null ? new ItemStack(0): itemStack;
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
	public void setQuantity(int quantity) {
		itemStack.setAmount(quantity);
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

	@Override
	public boolean hasMetaData() {
		return itemStack.hasItemMeta();
	}

	@Override
	public String getCommonName() {
		return BukkitInventoryUtil.getCommonName(itemStack);
	}

	@Override
	public MCItemStack clone(){
		return new BukkitItemStack(itemStack.clone());
	}

	public ItemStack getItem() {
		return itemStack;
	}

	@Override
	public String toString(){
		return itemStack != null ? "["+ itemStack.getType() +":"+itemStack.getDurability() + " q="+
				getQuantity()+"]" : "null";
	}

	@Override
	public void addEnchantment(int id, int level) {
		itemStack.addEnchantment(Enchantment.getById(id), level);
	}

	public void addEnchantment(Enchantment enc, int level) {
		itemStack.addEnchantment(enc, level);
	}

	@Override
	public int isSpecial() {
		int special = 0;
//		ItemMeta im = itemStack.getItemMeta();
//		Map<Enchantment,Integer> map = itemStack.getEnchantments();
//		if (map != null){
//			for (Entry<Enchantment,Integer> entry : map.entrySet()){
////				entry.getKey().getId()
//			}
//		}

		return special;
	}

}
