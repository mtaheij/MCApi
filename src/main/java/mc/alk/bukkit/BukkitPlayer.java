package mc.alk.bukkit;

import mc.alk.mc.MCInventory;
import mc.alk.mc.MCPlayer;
import mc.alk.mc.MCWorld;

import org.bukkit.entity.Player;

public class BukkitPlayer extends BukkitCommandSender implements MCPlayer{
	final Player player;
	final String name;

	public BukkitPlayer(Player player){
		super(player);
		this.player = player;
		this.name = player.getName();
	}

	@Override
	public MCWorld getWorld() {
		return new BukkitWorld(player.getWorld());
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDiplayName() {
		return player.getDisplayName();
	}

	@Override
	public boolean hasPermission(String node) {
		return player.hasPermission(node);
	}

	public Player getPlayer() {
		return player;
	}

	@Override
	public MCInventory getInventory() {
		return new BukkitPlayerInventory(player.getInventory());
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateInventory() {
		player.updateInventory();
	}
}
