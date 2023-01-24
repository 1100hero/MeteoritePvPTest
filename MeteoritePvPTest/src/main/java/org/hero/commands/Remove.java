package org.hero.commands;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.Command;
import com.meteoritepvp.api.command.CommandClass;
import com.meteoritepvp.api.utils.CC;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.hero.enums.Color;
import org.hero.gui.Gui;

public class Remove implements CommandClass {

    @Command(name = "color", description = "Remvoe a color from the list", args = {"remove"}, params = "@color")
    public void onRemove(CommandSender sender, String[] params){
        if(!(sender instanceof Player player)){
            sender.sendMessage(CC.format("&cYou must be a player to execute this command."));
            return;
        }
        if(params.length != 0){
            sender.sendMessage(CC.format("&cWrong command."));
            return;
        }
        new Gui(new MeteoritePlugin()).removeElements(Color.getColor(params[0].toUpperCase()));
    }
}
