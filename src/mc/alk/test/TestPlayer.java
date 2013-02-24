package mc.alk.test;

import mc.alk.mc.MCLocation;
import mc.alk.mc.MCPlayer;
import mc.alk.mc.MCWorld;

public class TestPlayer implements MCPlayer {
	String name;
	String displayName;
	MCLocation loc;

	public TestPlayer(String name, MCLocation loc){
		this.name = name;
		this.loc = loc;
	}

	@Override
	public MCWorld getWorld() {
		return loc.getWorld();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDiplayName() {
		return displayName == null ? name : displayName;
	}

}
