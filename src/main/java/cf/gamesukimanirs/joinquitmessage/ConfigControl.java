package cf.gamesukimanirs.joinquitmessage;

/*
 * referenced from:
 * https://github.com/HimaJyun/BukkitPluginDevelopment/blob/master/Part0-9/Part7/src/main/java/jp/jyn/part7/Config.java
 */

import org.bukkit.plugin.Plugin;
import org.bukkit.configuration.file.FileConfiguration;


public class ConfigControl {

	private Plugin mc;
	private FileConfiguration cfg = null;

	public ConfigControl(Plugin pl) {
		this.mc = pl;
		load();
	}

	public void load() {
		mc.saveConfig();
		if(cfg != null) {
			mc.reloadConfig();
		}
		cfg = mc.getConfig();
	}

	public String get(String value) {
		switch(value) {
		case "jmsg":
			return cfg.getString("joinmessage", "§f{name}§e が世界にやってきました");
		case "qmsg":
			return cfg.getString("quitmessage", "§f{name}§e が世界を去りました");
		case "opjmsg":
			return cfg.getString("opjoinmessage", "§a{name}§e(OP) が世界にやってきました");
		case "opqmsg":
			return cfg.getString("opquitmessage", "§a{name}§e(OP) が世界を去りました");
		}
		return null;
	}

	public boolean set(String key, String value) {
		if(key == null) {
			return false;
		}else if(value == null) {
			return false;
		}
		cfg.set(key, value);
		mc.saveConfig();
		return true;
	}
}
