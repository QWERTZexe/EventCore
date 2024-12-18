package app.qwertz.eventcore.commands.dead;

import app.qwertz.eventcore.EventCore;
import app.qwertz.eventcore.util.Config;
import app.qwertz.eventcore.util.SimplePlayerCommand;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.jetbrains.annotations.Nullable;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TpDead extends SimplePlayerCommand {

    public TpDead(@NotNull String name, @Nullable String description, @Nullable String... aliases) {
        super(name, description, aliases);
    }

    @Override
    protected LiteralArgumentBuilder<CommandSourceStack> run(LiteralArgumentBuilder<CommandSourceStack> argumentBuilder) {
        return argumentBuilder
                .executes(context -> {
                    CommandSender sender = context.getSource().getSender();
                    for (Player player: EventCore.instance.Dead) {
                        player.teleport(((Player) sender).getLocation());
                    }
                    Bukkit.broadcast(Config.msg("tpdead.teleport-broadcast")
                            .replaceText(builder -> builder.matchLiteral("%sender%").replacement(sender.getName())));
                    return 1;
                });
    }

}
