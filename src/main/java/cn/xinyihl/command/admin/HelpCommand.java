package cn.xinyihl.command.admin;

import cn.handyplus.lib.command.IHandyCommandEvent;
import cn.handyplus.lib.util.BaseUtil;
import cn.xinyihl.util.ConfigUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import java.util.List;

public class HelpCommand implements IHandyCommandEvent {

    @Override
    public String command() {
        return "help";
    }

    @Override
    public String permission() {
        return "BSEnhanced.help";
    }

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> helps = ConfigUtil.LANG_CONFIG.getStringList("helps");

        for (String help : helps) {
            sender.sendMessage(BaseUtil.replaceChatColor(help));

        }

    }
}
