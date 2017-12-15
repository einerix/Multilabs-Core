package main.java.io.gomint.plugin.command;

import io.gomint.ChatColor;
import io.gomint.command.Command;
import io.gomint.command.CommandOutput;
import io.gomint.command.annotation.Description;
import io.gomint.command.annotation.Name;
import io.gomint.entity.EntityPlayer;
import io.gomint.math.Vector;

import java.util.Map;

@Name( "velo" )
@Description( "Give custom velocity to player" )

public class CoreCommands extends Command
{

    @Override
    public CommandOutput execute(EntityPlayer entityPlayer, String s, Map<String, Object> map)
    {
        CommandOutput output = new CommandOutput();
        entityPlayer.setVelocity( new Vector( 0, 2, 0 ) );
        output.success(ChatColor.RED + "Velocity");

        return output;
    }
}
