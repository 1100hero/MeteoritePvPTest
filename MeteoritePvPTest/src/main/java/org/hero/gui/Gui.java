package org.hero.gui;

import com.meteoritepvp.api.MeteoritePlugin;
import com.meteoritepvp.api.inventory.MeteoriteInventory;
import com.meteoritepvp.api.inventory.presets.BasicInventory;
import com.meteoritepvp.api.utils.CC;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.hero.enums.Color;

import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Gui {

    private final MeteoriteInventory inventory;

    public Gui(MeteoritePlugin plugin) {
        inventory = new MeteoriteInventory(plugin, CC.GREEN + "COLORS INVENTORY", 9,4,false);
    }
    public void addElements(Color color){
        BasicInventory page = new BasicInventory();
        OptionalInt index = IntStream.range(0, inventory.getInventory().getSize())
                        .filter(i -> inventory.getInventory().getContents()[i] == null)
                                .findFirst();
        if(index.isEmpty()) return;
        page.setItem(index.getAsInt(), Material.valueOf(color.name().concat("_WOOL")));
        page.update();
        inventory.applyPage(page);
    }
    public void openGui(Player player){
        inventory.show(player);
    }
    public void removeElements(Color color){
        OptionalInt index = IntStream.range(0, inventory.getInventory().getSize())
                .filter(i -> inventory.getInventory().getContents()[i].getType() == Material.valueOf(color.name().concat("_WOOL")))
                .findFirst();
        if(index.isEmpty()) return;
        inventory.getInventory().remove(Material.valueOf(color.name().concat("_WOOL")));
    }
}
