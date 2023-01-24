package org.hero.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.command.DefaultCommand;
import com.meteoritepvp.api.utils.CC;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hero.enums.Color;
import org.hero.gui.Gui;

@DefaultCommand
@Command(name = "colors", description = "Colors command.")
public class Colors implements CommandClass {

    private final Gui gui = new Gui(new MeteoritePlugin());

    @Command(description = "Display all the colors added in the GUI.")
    public void onColors(CommandSender sender){
        if(!(sender instanceof Player player)){
            sender.sendMessage(CC.format("&cYou must be a player to see colors."));
            return;
        }
        gui.openGui(player);
    }

    @Command(name = "add", description = "Add colors into the GUI.", params = "@color")
    public void onAdd(CommandSender sender, String params[]){
        if(!(sender instanceof Player player)){
            sender.sendMessage(CC.format("&cYou must be a player to add colors."));
            return;
        }
        if(params.length != 0){
            sender.sendMessage(CC.format("&cWrong command."));
            return;
        }
        gui.addElements(Color.getColor(params[0].toUpperCase()));
    }
}
