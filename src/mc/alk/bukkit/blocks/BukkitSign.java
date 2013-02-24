package mc.alk.bukkit.blocks;

import mc.alk.bukkit.BukkitBlock;
import mc.alk.mc.blocks.MCSign;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;

public class BukkitSign extends BukkitBlock implements MCSign{
	Sign sign;
	public BukkitSign(Block block) {
		super(block);
		sign = (Sign)block.getState();
	}

	@Override
	public void setLine(int index, String line) {
		sign.setLine(index, line);
	}

	@Override
	public String getLine(int index) {
		return sign.getLine(index);
	}

	@Override
	public String[] getLines() {
		return sign.getLines();
	}

	@Override
	public void update(boolean b) {
		sign.update(b);
	}
}
