package cn.xinyihl.command;

import cn.handyplus.lib.annotation.HandyCommand;
import cn.handyplus.lib.command.HandyCommandFactory;
import cn.handyplus.lib.util.BaseUtil;
import cn.xinyihl.constants.TabListEnum;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@HandyCommand(name = "BSEnhanced")
public class MainCommand implements TabExecutor {

    private static final String PERMISSION = "BSEnhanced";

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length < 1) {
            return senderrorHelp(sender);
        }

        boolean rst = HandyCommandFactory.getInstance().onCommand(sender, cmd, label, args, BaseUtil.getLangMsg("noPermission"));

        if (!rst) {
            return senderrorHelp(sender);
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> completions = new ArrayList<>();
        List<String> commands = TabListEnum.returnList(args, args.length);

        if (commands == null) {
            return null;
        }

        StringUtil.copyPartialMatches(args[args.length - 1].toLowerCase(), commands, completions);
        Collections.sort(completions);
        return completions;
    }

    private Boolean senderrorHelp(CommandSender sender) {
        sender.sendMessage(BaseUtil.getLangMsg("errorcommand"));
        return true;

    }

}