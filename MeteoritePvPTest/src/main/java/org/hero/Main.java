package org.hero;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.command.DefaultCommand;
import org.hero.commands.Colors;
import org.hero.commands.Remove;

import java.util.List;

@DefaultCommand
public class Main extends MeteoritePlugin {

    @Override
    public void onRegisterCommands(String... aliases){
        super.onRegisterCommands("c");
        super.onRegisterCommands("colors");
    }
    @Override
    public void onInit(){
        super.onInit();
        registerCommandClass(Colors.class);
        registerCommandClass(Remove.class);
    }

    @Override
    public void onEnable(){
        super.onEnable();
        registerPlaceholderParameter("color", (sender -> getNames()));
    }

    public List<String> getNames(){
        return List.of("BLACK", "DARK_BLUE", "DARK_GREEN", "DARK_AQUA",
                "DARK_RED", "DARK_PURPLE",
                "GOLD", "GRAY", "DARK_GRAY", "BLUE", "GREEN",
                "AQUA", "RED", "LIGHT_PURPLE", "YELLOW", "WHITE");
    }
}