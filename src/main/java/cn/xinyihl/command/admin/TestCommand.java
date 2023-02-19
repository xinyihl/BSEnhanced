package cn.xinyihl.command.admin;

import cn.handyplus.lib.command.IHandyCommandEvent;
import cn.handyplus.lib.util.AssertUtil;
import cn.handyplus.lib.util.BaseUtil;
import cn.xinyihl.ticktimer.AutoBanPlayer;
import cn.xinyihl.util.GetSkinPermission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommand implements IHandyCommandEvent {

    @Override
    public String command() {
        return "test";
    }

    @Override
    public String permission() {
        return "BSEnhanced.test";
    }

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args[1].equals("me")) {

            AssertUtil.notPlayer(sender, BaseUtil.getLangMsg("noPlayerFailureMsg"));
            sender.sendMessage(BaseUtil.replaceChatColor(GetSkinPermission.pers((Player) sender, true)));

        } else if(args[1].equals("timer")) {
            if(args[2].equals("on")){
                sender.sendMessage(AutoBanPlayer.MyTimerTask(true));
            }else if(args[2].equals("off")){
                sender.sendMessage(AutoBanPlayer.MyTimerTask(false));
            }else {
                sender.sendMessage(BaseUtil.getLangMsg("paramFailureMsg"));
            }
        } else {
            sender.sendMessage(BaseUtil.getLangMsg("errorcommand"));
        }


    }
}