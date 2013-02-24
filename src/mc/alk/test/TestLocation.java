package mc.alk.test;

import mc.alk.mc.MCLocation;
import mc.alk.mc.MCWorld;

public class TestLocation implements MCLocation{
	MCWorld world;
	int x,y,z;

	public TestLocation(String world, int x,int y, int z) {
		this(TestAPI.getWorld(world),x,y,z);
	}

	public TestLocation(MCWorld world, int x, int y, int z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	@Override
	public MCWorld getWorld() {
		return world;
	}

	@Override
	public int getBlockX() {
		return x;
	}

	@Override
	public int getBlockY() {
		return y;
	}

	@Override
	public int getBlockZ() {
		return z;
	}
	@Override
	public String toString(){
		return "[Loc " + world +" " + x+":"+y+":"+z+"]";
	}
}
