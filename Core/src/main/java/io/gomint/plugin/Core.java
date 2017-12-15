package main.java.io.gomint.plugin;

import io.gomint.ChatColor;
import io.gomint.plugin.Plugin;
import io.gomint.plugin.PluginName;
import io.gomint.plugin.Version;
import main.java.io.gomint.plugin.command.CoreCommands;
import main.java.io.gomint.plugin.listener.LobbyListener;

@PluginName("Core")
@Version(major = 1, minor = 0)
public class Core extends Plugin
{
    @Override
    public void onStartup()
    {
        getLogger().info(ChatColor.RED + this.getName() + this.getVersion() + "wurde geladen");
    }

    @Override
    public void onInstall()
    {
        registerCommand(new CoreCommands());
        registerListener(new LobbyListener() );
    }
}
