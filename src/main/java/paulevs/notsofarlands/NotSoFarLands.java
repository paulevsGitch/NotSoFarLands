package paulevs.notsofarlands;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import paulevs.notsofarlands.config.Config;
import paulevs.notsofarlands.config.ConfigEntry;

import java.io.File;

public class NotSoFarLands implements ModInitializer {
	private static final Config CONFIG = new Config(new File(FabricLoader.getInstance().getConfigDir().toString(), "not_so_far_lands.cfg"));
	public static final int WORLD_OFFSET = 12550821 >> 2;
	
	public static final ConfigEntry<Boolean> GEN_OVERWORLD = CONFIG.addEntry(
		"generateInTheOverworld", true, "Should Farlands be generated in the Overworld", "Default value is true"
	);
	public static final ConfigEntry<Integer> OVERWORLD_MIN_X = CONFIG.addEntry(
		"overworldNegX", -8192, "Minimum negative coordinate for Farlands to generate (in blocks) in the Overworld", "Default value is -8192"
	);
	public static final ConfigEntry<Integer> OVERWORLD_MIN_Z = CONFIG.addEntry(
		"overworldNegZ", -8192, "Minimum negative coordinate for Farlands to generate (in blocks) in the Overworld", "Default value is -8192"
	);
	public static final ConfigEntry<Integer> OVERWORLD_MAX_X = CONFIG.addEntry(
		"overworldPosX", 8192, "Minimum positive coordinate for Farlands to generate (in blocks) in the Overworld", "Default value is 8192"
	);
	public static final ConfigEntry<Integer> OVERWORLD_MAX_Z = CONFIG.addEntry(
		"overworldPosZ", 8192, "Minimum positive for Farlands to generate (in blocks) in the Overworld", "Default value is 8192"
	);
	
	public static final ConfigEntry<Boolean> GEN_NETHER = CONFIG.addEntry(
		"generateInTheNether", true, "Should Farlands be generated in the Nether", "Default value is true"
	);
	public static final ConfigEntry<Integer> NETHER_MIN_X = CONFIG.addEntry(
		"netherNegX", -8192, "Minimum negative coordinate for Farlands to generate (in blocks) in the Nether", "Default value is -8192"
	);
	public static final ConfigEntry<Integer> NETHER_MIN_Z = CONFIG.addEntry(
		"netherNegZ", -8192, "Minimum negative coordinate for Farlands to generate (in blocks) in the Nether", "Default value is -8192"
	);
	public static final ConfigEntry<Integer> NETHER_MAX_X = CONFIG.addEntry(
		"netherPosX", 8192, "Minimum positive coordinate for Farlands to generate (in blocks) in the Nether", "Default value is 8192"
	);
	public static final ConfigEntry<Integer> NETHER_MAX_Z = CONFIG.addEntry(
		"netherPosZ", 8192, "Minimum positive for Farlands to generate (in blocks) in the Nether", "Default value is 8192"
	);
	
	@Override
	public void onInitialize() {
		CONFIG.save();
	}
}
