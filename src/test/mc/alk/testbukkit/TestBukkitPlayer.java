package mc.alk.testbukkit;

import java.net.InetSocketAddress;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Achievement;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.conversations.Conversation;
import org.bukkit.conversations.ConversationAbandonedEvent;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Snowball;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.InventoryView.Property;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.map.MapView;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class TestBukkitPlayer implements Player{
	static int count = 0;

	int health = 20;
	int maxHealth = 20;
	Location location;
	int id = count++;


	Player killer = null;
	String name;
	float exp = 0;
	boolean banned = false;
	boolean whitelisted = true;
	boolean op = true;
	boolean online = true;
	int lvl = 0;

	GameMode gamemode = GameMode.SURVIVAL;

	public TestBukkitPlayer(String name) {
		this.name= name;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public PlayerInventory getInventory() {
		return null;
	}

	@Override
	public Inventory getEnderChest() {
		return null;
	}

	@Override
	public boolean setWindowProperty(Property prop, int value) {
		return false;
	}

	@Override
	public InventoryView getOpenInventory() {
		return null;
	}

	@Override
	public InventoryView openInventory(Inventory inventory) {
		return null;
	}

	@Override
	public InventoryView openWorkbench(Location location, boolean force) {
		return null;
	}

	@Override
	public InventoryView openEnchanting(Location location, boolean force) {

		return null;
	}

	@Override
	public void openInventory(InventoryView inventory) {


	}

	@Override
	public void closeInventory() {


	}

	@Override
	public ItemStack getItemInHand() {

		return null;
	}

	@Override
	public void setItemInHand(ItemStack item) {}

	@Override
	public ItemStack getItemOnCursor() {return new ItemStack(Material.AIR);}

	@Override
	public void setItemOnCursor(ItemStack item) {}

	@Override
	public boolean isSleeping() { return false;}

	@Override
	public int getSleepTicks() { return 0;}

	@Override
	public GameMode getGameMode() {return gamemode; }

	@Override
	public void setGameMode(GameMode mode) {this.gamemode = mode;}

	@Override
	public boolean isBlocking() { return false;}

	@Override
	public int getExpToLevel() { return 0; }

	@Override
	public int getHealth() {return health;}

	@Override
	public int getMaxHealth() { return maxHealth;}

	@Override
	public Location getEyeLocation() {
		Location l = location.clone();
		l.setY(l.getY() +1);
		return l;
	}

	@Override
	public List<Block> getLineOfSight(HashSet<Byte> transparent, int maxDistance) {

		return null;
	}

	@Override
	public List<Block> getLastTwoTargetBlocks(HashSet<Byte> transparent,
			int maxDistance) {

		return null;
	}

	@Override
	public int getRemainingAir() {

		return 0;
	}

	@Override
	public int getMaximumAir() {

		return 0;
	}

	@Override
	public void damage(int amount) {
		health = Math.max(health-amount, 0);
	}

	@Override
	public void damage(int amount, Entity source) {
		health = Math.max(health-amount, 0);
		if (source instanceof Player)
			killer = (Player)source;
	}

	@Override
	public int getMaximumNoDamageTicks() {
		return 0;
	}

	@Override
	public int getLastDamage() {
		return 0;
	}

	@Override
	public int getNoDamageTicks() {
		return 0;
	}

	@Override
	public Player getKiller() {
		return killer;
	}

	@Override
	public boolean addPotionEffect(PotionEffect effect) {return false;}

	@Override
	public boolean addPotionEffect(PotionEffect effect, boolean force) { return false;}

	@Override
	public boolean addPotionEffects(Collection<PotionEffect> effects) { return false;}

	@Override
	public Collection<PotionEffect> getActivePotionEffects() {
		return null;
	}

	@Override
	public boolean getCanPickupItems() { return false;}

	@Override
	public EntityEquipment getEquipment() { return null; }

	@Override
	public double getEyeHeight() {
		return location.getY()+1;
	}

	@Override
	public double getEyeHeight(boolean ignoreSneaking) { return location.getY()+1;}

	@Override
	public boolean getRemoveWhenFarAway() {

		return false;
	}

	@Override
	public Block getTargetBlock(HashSet<Byte> transparent, int maxDistance) {

		return null;
	}

	@Override
	public <T extends Projectile> T launchProjectile(
			Class<? extends T> projectile) {

		return null;
	}

	@Override
	public boolean hasPotionEffect(PotionEffectType type) {

		return false;
	}

	@Override
	public void removePotionEffect(PotionEffectType type) {


	}

	@Override
	public boolean hasLineOfSight(Entity other) {

		return false;
	}

	@Override
	public void setCanPickupItems(boolean arg0) {


	}

	@Override
	public void setHealth(int health) {this.health = health; }

	@Override
	public void setRemainingAir(int ticks) {


	}

	@Override
	public void setMaximumAir(int ticks) {


	}

	@Override
	public void setMaximumNoDamageTicks(int ticks) {


	}

	@Override
	public void setLastDamage(int damage) {


	}

	@Override
	public void setNoDamageTicks(int ticks) {


	}

	@Override
	public void setRemoveWhenFarAway(boolean arg0) {


	}

	@Override
	@Deprecated
	public Egg throwEgg() {

		return null;
	}

	@Override
	@Deprecated
	public Snowball throwSnowball() {

		return null;
	}

	@Override
	@Deprecated
	public Arrow shootArrow() {

		return null;
	}

	@Override
	public Location getLocation() {

		return null;
	}

	@Override
	public void setVelocity(Vector velocity) {


	}

	@Override
	public Vector getVelocity() {
		return new Vector(0,0,0);
	}

	@Override
	public World getWorld() {
		return location.getWorld();
	}

	@Override
	public boolean teleport(Location location) {
		this.location =location.clone();
		return true;
	}

	@Override
	public boolean teleport(Location location, TeleportCause cause) {
		this.location =location.clone();
		return true;
	}

	@Override
	public boolean teleport(Entity destination) {
		this.location =destination.getLocation().clone();
		return true;
	}

	@Override
	public boolean teleport(Entity destination, TeleportCause cause) {
		this.location =destination.getLocation().clone();
		return true;
	}

	@Override
	public List<Entity> getNearbyEntities(double x, double y, double z) {

		return null;
	}

	@Override
	public int getEntityId() { return id;}

	@Override
	public int getFireTicks() {

		return 0;
	}

	@Override
	public void setFireTicks(int ticks) {


	}

	@Override
	public void remove() {


	}

	@Override
	public boolean isDead() { return health <= 0; }

	@Override
	public boolean isValid() {
		return true;
	}

	@Override
	public Server getServer() {
		return null;
	}

	@Override
	public Entity getPassenger() {

		return null;
	}

	@Override
	public boolean setPassenger(Entity passenger) {

		return false;
	}

	@Override
	public boolean isEmpty() {

		return false;
	}

	@Override
	public boolean eject() {

		return false;
	}

	@Override
	public float getFallDistance() {

		return 0;
	}

	@Override
	public void setFallDistance(float distance) {


	}

	@Override
	public void setLastDamageCause(EntityDamageEvent event) {


	}

	@Override
	public EntityDamageEvent getLastDamageCause() {

		return null;
	}

	@Override
	public Location getLocation(Location arg0) {

		return location;
	}

	@Override
	public int getMaxFireTicks() {

		return 0;
	}

	@Override
	public UUID getUniqueId() {

		return null;
	}

	@Override
	public int getTicksLived() {

		return 0;
	}

	@Override
	public void setTicksLived(int value) {


	}

	@Override
	public void playEffect(EntityEffect type) {


	}

	@Override
	public EntityType getType() {

		return null;
	}

	@Override
	public boolean isInsideVehicle() {

		return false;
	}

	@Override
	public boolean leaveVehicle() {

		return false;
	}

	@Override
	public Entity getVehicle() {

		return null;
	}

	@Override
	public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {


	}

	@Override
	public List<MetadataValue> getMetadata(String metadataKey) {

		return null;
	}

	@Override
	public boolean hasMetadata(String metadataKey) {

		return false;
	}

	@Override
	public void removeMetadata(String metadataKey, Plugin owningPlugin) {


	}

	@Override
	public boolean isPermissionSet(String name) {

		return false;
	}

	@Override
	public boolean isPermissionSet(Permission perm) {
		return false;
	}

	@Override
	public boolean hasPermission(String name) {
		return op;
	}

	@Override
	public boolean hasPermission(Permission perm) {
		return op;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value) {

		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin) {

		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, String name,
			boolean value, int ticks) {

		return null;
	}

	@Override
	public PermissionAttachment addAttachment(Plugin plugin, int ticks) {

		return null;
	}

	@Override
	public void removeAttachment(PermissionAttachment attachment) {


	}

	@Override
	public void recalculatePermissions() {


	}

	@Override
	public Set<PermissionAttachmentInfo> getEffectivePermissions() {

		return null;
	}

	@Override
	public boolean isOp() {

		return false;
	}

	@Override
	public void setOp(boolean value) {


	}

	@Override
	public boolean isConversing() {

		return false;
	}

	@Override
	public void acceptConversationInput(String input) {


	}

	@Override
	public boolean beginConversation(Conversation conversation) {

		return false;
	}

	@Override
	public void abandonConversation(Conversation conversation) {


	}

	@Override
	public void abandonConversation(Conversation conversation,
			ConversationAbandonedEvent details) {


	}

	@Override
	public void sendMessage(String message) {
		System.out.println("[" + name+"] getting message '"+ message+"'");
	}

	@Override
	public void sendMessage(String[] messages) {
		for (String message: messages)
			System.out.println("[" + name+"] getting message '"+ message+"'");
	}

	@Override
	public boolean isOnline() {
		return online;
	}

	@Override
	public boolean isBanned() { return banned;}

	@Override
	public void setBanned(boolean banned) { this.banned = banned;}

	@Override
	public boolean isWhitelisted() { return whitelisted;}

	@Override
	public void setWhitelisted(boolean value) { whitelisted = value;}

	@Override
	public Player getPlayer() { return this;}

	@Override
	public long getFirstPlayed() { return 0; }

	@Override
	public long getLastPlayed() { return 0; }

	@Override
	public boolean hasPlayedBefore() {return true;}

	@Override
	public Map<String, Object> serialize() {
		return null;
	}

	@Override
	public void sendPluginMessage(Plugin source, String channel, byte[] message) {
		System.out.println("[" + name+"] send plugin message channel="+channel+" msg='"+ message+"'");
	}

	@Override
	public Set<String> getListeningPluginChannels() {
		return null;
	}

	@Override
	public String getDisplayName() {
		return name;
	}

	@Override
	public String getPlayerListName() {
		return name;
	}

	@Override
	public Location getCompassTarget() {
		return null;
	}

	@Override
	public InetSocketAddress getAddress() {
		return null;
	}

	@Override
	public void sendRawMessage(String message) {
		System.out.println("[" + name+"] getting raw message '"+ message+"'");
	}

	@Override
	public void kickPlayer(String message) {

	}

	@Override
	public void chat(String message) {
		System.out.println("[" + name+"] getting chat message '"+ message+"'");
	}

	@Override
	public boolean performCommand(String command) {
		return false;
	}

	@Override
	public boolean isSneaking() {
		return false;
	}

	@Override
	public boolean isSprinting() {
		return false;
	}

	@Override
	public void saveData() {


	}

	@Override
	public void loadData() {


	}

	@Override
	public boolean isSleepingIgnored() {

		return false;
	}

	@Override
	public void playNote(Location loc, byte instrument, byte note) { }

	@Override
	public void playNote(Location loc, Instrument instrument, Note note) { }

	@Override
	public void playSound(Location location, Sound sound, float volume,
			float pitch) {


	}

	@Override
	public void playEffect(Location loc, Effect effect, int data) {}

	@Override
	public <T> void playEffect(Location loc, Effect effect, T data) {}

	@Override
	public void sendBlockChange(Location loc, Material material, byte data) { }

	@Override
	public boolean sendChunkChange(Location loc, int sx, int sy, int sz,
			byte[] data) {

		return false;
	}

	@Override
	public void sendBlockChange(Location loc, int material, byte data) {}

	@Override
	public void sendMap(MapView map) {}

	@Override
	public void awardAchievement(Achievement achievement) {}

	@Override
	public void incrementStatistic(Statistic statistic, Material material) {}

	@Override
	public void incrementStatistic(Statistic statistic, Material material, int amount) {}

	@Override
	public long getPlayerTime() {
		return 0;
	}

	@Override
	public long getPlayerTimeOffset() {

		return 0;
	}

	@Override
	public boolean isPlayerTimeRelative() {

		return false;
	}

	@Override
	public void resetPlayerTime() {


	}

	@Override
	public void giveExp(int amount) { exp+=amount;}

	@Override
	public float getExp() {return exp;}

	@Override
	public int getLevel() { return lvl;}

	@Override
	public int getTotalExperience() {return (int) exp;}

	@Override
	public float getExhaustion() {

		return 0;
	}

	@Override
	public float getSaturation() {

		return 0;
	}

	@Override
	public int getFoodLevel() {

		return 0;
	}

	@Override
	public Location getBedSpawnLocation() {

		return null;
	}

	@Override
	public void setBedSpawnLocation(Location location) {


	}

	@Override
	public boolean getAllowFlight() {

		return false;
	}

	@Override
	public void setAllowFlight(boolean flight) {


	}

	@Override
	public boolean canSee(Player player) {

		return false;
	}

	@Override
	public boolean isFlying() {

		return false;
	}

	@Override
	public float getFlySpeed() {

		return 0;
	}

	@Override
	public float getWalkSpeed() {

		return 0;
	}

	@Override
	public void giveExpLevels(int arg0) {


	}

	@Override
	public void incrementStatistic(Statistic statistic) {


	}

	@Override
	public void incrementStatistic(Statistic statistic, int amount) {


	}

	@Override
	public void hidePlayer(Player player) {


	}

	@Override
	public void setBedSpawnLocation(Location arg0, boolean arg1) {


	}

	@Override
	public void setDisplayName(String name) {


	}

	@Override
	public void setPlayerListName(String name) {


	}

	@Override
	public void setCompassTarget(Location loc) {


	}

	@Override
	public void setSneaking(boolean sneak) {


	}

	@Override
	public void setSprinting(boolean sprinting) {


	}

	@Override
	public void setSleepingIgnored(boolean isSleeping) {


	}

	@Override
	@Deprecated
	public void updateInventory() {


	}

	@Override
	public void setPlayerTime(long time, boolean relative) {


	}

	@Override
	public void setExp(float exp) {


	}

	@Override
	public void setLevel(int level) {


	}

	@Override
	public void setTotalExperience(int exp) { this.exp = exp;}

	@Override
	public void setExhaustion(float value) {


	}

	@Override
	public void setSaturation(float value) {


	}

	@Override
	public void setFoodLevel(int value) {


	}

	@Override
	public void showPlayer(Player player) {


	}

	@Override
	public void setFlying(boolean value) {


	}

	@Override
	public void setFlySpeed(float value) throws IllegalArgumentException {


	}

	@Override
	public void setWalkSpeed(float value) throws IllegalArgumentException {


	}

	@Override
	public void resetMaxHealth() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setMaxHealth(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setTexturePack(String arg0) {
		// TODO Auto-generated method stub

	}
}
