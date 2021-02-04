package cf.gamesukimanirs.joinquitmessage;

//event
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

//command
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

//base
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class Main extends JavaPlugin implements Listener{

	private String PluginName = "JoinQuitMessage";
	private String version = "1.0.0";
	private ConfigControl cfg;

	@Override
	public void onEnable(){
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info(PluginName + "-v" + version + "を読み込みました。作者:gamesukimanIRS");
    	getLogger().warning("製作者偽りと二次配布、友人用を除いた他人用の改造、改造配布、プラグインの横流し、悪用等はおやめ下さい。");
    	getLogger().warning("また、このプラグインを使用して発生した如何なる問題に対しての責任は負いかねます。");
    	getLogger().info("このプラグインを使用する際はどこかにプラグイン名「" + PluginName + "」と作者名「gamesukimanIRS」を記載して頂けると光栄です。");
    	saveDefaultConfig();
    	cfg = new ConfigControl(this);
	}

	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		if(e.getPlayer().isOp()) {
			String msg = cfg.get("opjmsg");
			msg = msg.replaceAll("\\{name\\}", e.getPlayer().getName());
			e.setJoinMessage(msg);
		}else {
			String msg = cfg.get("jmsg");
			msg = msg.replaceAll("\\{name\\}", e.getPlayer().getName());
			e.setJoinMessage(msg);
		}
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		if(e.getPlayer().isOp()) {
			String msg = cfg.get("opqmsg");
			msg = msg.replaceAll("\\{name\\}", e.getPlayer().getName());
			e.setQuitMessage(msg);
		}else {
			String msg = cfg.get("qmsg");
			msg = msg.replaceAll("\\{name\\}", e.getPlayer().getName());
			e.setQuitMessage(msg);
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!sender.isOp()) {
			sender.sendMessage("§a[JoinQuitMessage]§cエラー:001 OP権限がありません");
			return true;
		}
		try {
			if(!(args[0] instanceof String)) {
				sender.sendMessage("§a[JoinQuitMessage]§cエラー:002 メッセージ内容を入力してください。");
				return false;
			}
			switch (cmd.getName()) {
				case "setmsgjoinop" :
					String msgjo = String.join(" ",args);
					cfg.set("opjoinmessage",msgjo);
					getLogger().info(sender.getName()+"によってOPログイン時のメッセージが「"+msgjo+"」に変更されました");
					sender.sendMessage("§a[JoinQuitMessage]§bOPログイン時のメッセージを設定しました。");
					return true;
				case "setmsgquitop" :
					String msgqo = String.join(" ",args);
					cfg.set("opquitmessage",msgqo);
					getLogger().info(sender.getName()+"によってOPログアウト時のメッセージが「"+msgqo+"」に変更されました");
					sender.sendMessage("§a[JoinQuitMessage]§bOPログアウト時のメッセージを設定しました。");
					return true;
				case "setmsgjoin" :
					String msgj = String.join(" ",args);
					cfg.set("joinmessage",msgj);
					getLogger().info(sender.getName()+"によってログイン時のメッセージが「"+msgj+"」に変更されました");
					sender.sendMessage("§a[JoinQuitMessage]§bログイン時のメッセージを設定しました。");
					return true;
				case "setmsgquit" :
					String msgq = String.join(" ",args);
					cfg.set("quitmessage",msgq);
					getLogger().info(sender.getName()+"によってログアウト時のメッセージが「"+msgq+"」に変更されました");
					sender.sendMessage("§a[JoinQuitMessage]§bログアウト時のメッセージを設定しました。");
					return true;
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			sender.sendMessage("§a[JoinQuitMessage]§cエラー:002 メッセージ内容を入力してください。");
			return false;
		}
		return true;
	}

}
