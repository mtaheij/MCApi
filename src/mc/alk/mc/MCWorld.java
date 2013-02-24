package mc.alk.mc;



public interface MCWorld {
	String getName();

	MCBlock getBlockAt(int x, int y, int z);

	MCBlock getBlockAt(MCLocation loc);
}
