package cn.xinyihl.command.admin;

import cn.handyplus.lib.command.IHandyCommandEvent;
import cn.handyplus.lib.util.BaseUtil;
import cn.handyplus.lib.util.HttpUtil;
import cn.xinyihl.util.GetSkinScore;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_TOKEN;
import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_URL;

public class SetScoreCommand implements IHandyCommandEvent {

    @Override
    public String command() {
        return "setscore";
    }

    @Override
    public String permission() {
        return "BSEnhanced.setscore";
    }

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length > 3){

            if (args[2].equals("add")||args[2].equals("remove")||args[2].equals("set")){

                httpget(args[1],args[2],args[3]);
                sender.sendMessage(args[1] + "'s score: " + GetSkinScore.scor((Player) sender));

            }else {
                sender.sendMessage(BaseUtil.getLangMsg("paramFailureMsg"));
            }

        }else{
            sender.sendMessage(BaseUtil.getLangMsg("setscore-help"));
        }
    }
    @SneakyThrows
    public void httpget(String player,String type,String b){

        HttpUtil.get(PLUGIN_API_URL + "modify/userscore?player=" + player + "&token=" + PLUGIN_API_TOKEN + "&type=" + type + "&b=" + b);

    }
}