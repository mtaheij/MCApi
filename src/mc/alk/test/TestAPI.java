package mc.alk.test;

import java.util.HashMap;
import java.util.Map;

import mc.alk.mc.MCServer;
import mc.alk.mc.MCLocation;
import mc.alk.mc.MCPlugin;
import mc.alk.mc.MCWorld;

public class TestAPI extends MCServer{
	public static Map<String,MCWorld> worlds = new HashMap<String,MCWorld>();
	public static boolean disableThreads = false;

	@Override
	public MCLocation getMCLocation(String world, int x, int y, int z) {
		return new TestLocation(world,x,y,z);
	}

	@Override
	public MCWorld getMCWorld(String world) {
		return worlds.containsKey(world)? worlds.get(world) : new TestWorld(world);
	}

	@Override
	public long scheduleSyncTask(MCPlugin plugin, Runnable runnable) {
		if (disableThreads){
			runnable.run();
			return -1;
		}
		Thread t = new Thread(runnable);
		t.start();
		return t.getId();
	}

	public static void setWorld(String name, MCWorld world) {
		worlds.put(name,world);
	}
	public static void enableThreading(boolean enable){
		disableThreads = !enable;
	}
}
