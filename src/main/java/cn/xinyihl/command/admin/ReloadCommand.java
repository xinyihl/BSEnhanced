package cn.xinyihl.command.admin;

import cn.handyplus.lib.command.IHandyCommandEvent;
import cn.handyplus.lib.util.BaseUtil;
import cn.xinyihl.BSEnhanced;
import cn.xinyihl.util.ConfigUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

public class ReloadCommand implements IHandyCommandEvent {

    @Override
    public String command() {
        return "reload";
    }

    @Override
    public String permission() {
        return "BSEnhanced.reload";
    }

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        new BukkitRunnable() {

            @Override
            public void run() {

                ConfigUtil.init();
                sender.sendMessage(BaseUtil.getLangMsg("reloadMsg"));

            }

        }.runTaskAsynchronously(BSEnhanced.getInstance());

    }
}
