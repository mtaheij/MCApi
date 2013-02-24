package mc.alk.mc;

import java.util.Map;

public interface MCItemStack {
	public void setType(int id);
	public int getType();
	public void setDataValue(short value);
	public short getDataValue();
	public int getQuantity();

	public Map<Integer, Integer> getEnchantments();
}
