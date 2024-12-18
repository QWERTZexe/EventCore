package app.qwertz.eventcore.hooks.skript.expressions;

import app.qwertz.eventcore.EventCore;
import ch.njol.skript.Skript;
import ch.njol.skript.doc.Description;
import ch.njol.skript.doc.Examples;
import ch.njol.skript.doc.Name;
import ch.njol.skript.doc.Since;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.ExpressionType;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

@Name("All Alive Players")
@Description("Gets all of the alive players.")
@Examples({
        "all alive players"
})
@Since("1.2")
public class ExprAlive extends SimpleExpression<Player> {

    static {
        Skript.registerExpression(ExprAlive.class, Player.class, ExpressionType.SIMPLE,
                "[all [[of] the]] alive players"
        );
    }

    @Override
    protected Player @NotNull [] get(@NotNull Event e) {
        return EventCore.instance.Alive.toArray(Player[]::new);
    }

    @Override
    public boolean isSingle() {
        return false;
    }

    @Override
    public @NotNull Class<? extends Player> getReturnType() {
        return Player.class;
    }

    @Override
    public @NotNull String toString(@Nullable Event e, boolean debug) {
        return "all alive players";
    }

    @Override
    public boolean init(Expression<?> @NotNull [] exprs, int matchedPattern, @NotNull Kleenean isDelayed, SkriptParser.@NotNull ParseResult parseResult) {
        return true;
    }
}
