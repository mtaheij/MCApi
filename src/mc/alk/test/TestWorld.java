package mc.alk.test;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import mc.alk.mc.MCBlock;
import mc.alk.mc.MCLocation;
import mc.alk.mc.MCWorld;

public class TestWorld implements MCWorld{
	String name;

	Map<String,MCBlock> blocks = new ConcurrentHashMap<String,MCBlock>();

	public TestWorld(String name){
		this.name = name;
		TestAPI.setWorld(name,this);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public MCBlock getBlockAt(int x, int y, int z) {
		String key = toKey(x,y,z);
		if (blocks.containsKey(key))
			return blocks.get(key);
		else {
			MCBlock b = new TestBlock(new TestLocation(this,x,y,z),0);
			blocks.put(key, b);
			return b;
		}
	}

	@Override
	public MCBlock getBlockAt(MCLocation loc) {
		return getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
	}

	public static String toKey(int x, int y, int z){
		return x+":"+y+":"+z;
	}

	private String toKey(MCLocation location) {
		return toKey(location.getBlockX(),location.getBlockY(), location.getBlockZ());
	}

	public MCBlock addBlock(MCBlock block) {
		return blocks.put(toKey(block.getLocation()), block);
	}

	@Override
	public String toString(){
		return "["+name+":"+hashCode()+"]";
	}
}
