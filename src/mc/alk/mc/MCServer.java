package mc.alk.mc;


public abstract class MCServer {
	private static MCServer INSTANCE;

	public static void setInstance(MCServer api){
		if (INSTANCE == null){
			INSTANCE = api;
		}
	}

	public static MCLocation getLocation(String world, int x, int y, int z){
		return INSTANCE.getMCLocation(world,x,y,z);
	}

	public static MCWorld getWorld(String world){
		return INSTANCE.getMCWorld(world);
	}

	public static long scheduleSyncDelayedTask(MCPlugin plugin, Runnable runnable){
		return INSTANCE.scheduleSyncTask(plugin, runnable);
	}

	public abstract MCLocation getMCLocation(String world, int x, int y, int z);

	public abstract MCWorld getMCWorld(String world);

	public abstract long scheduleSyncTask(MCPlugin plugin, Runnable runnable);
}
