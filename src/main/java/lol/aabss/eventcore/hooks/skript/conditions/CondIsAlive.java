package lol.aabss.eventcore.hooks.skript.conditions;

import ch.njol.skript.conditions.base.PropertyCondition;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import static lol.aabss.eventcore.EventCore.Alive;

@Name("Is Alive")
@Description("Returns true if the player is alive.")
@Examples({
        "on player use revive:",
        "\tif player is alive:",
        "\t\tadd 1 to rev balance of player"
})
@Since("2.0")
public class CondIsAlive extends PropertyCondition<Player> {

    static {
        register(CondIsAlive.class,
                "(in the event|event alive)",
                "player");
    }

    @Override
    public boolean check(Player player) {
        return Alive.contains(player);
    }

    @Override
    protected @NotNull String getPropertyName() {
        return "event alive";
    }
}
