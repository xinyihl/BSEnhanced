package cn.xinyihl.command.admin;

import cn.handyplus.lib.command.IHandyCommandEvent;
import cn.handyplus.lib.util.AssertUtil;
import cn.handyplus.lib.util.BaseUtil;
import cn.handyplus.lib.util.HttpUtil;
import cn.xinyihl.util.GetSkinPermission;
import lombok.SneakyThrows;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_TOKEN;
import static cn.xinyihl.constants.PluginConstants.PLUGIN_API_URL;

public class SetSkinPermission implements IHandyCommandEvent {

    @Override
    public String command() {
        return "setskinpermission";
    }

    @Override
    public String permission() {
        return "BSEnhanced.setskinpermission";
    }

    @Override
    public void onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length > 2){

            if (args[2].equals("-1") || args[2].equals("0") || args[2].equals("1") || args[2].equals("2")) {

                httpget(args[1],args[2]);
                sender.sendMessage("set:" + args[1] + "(" + GetSkinPermission.pers((Player) sender,true) + ")");

            }else{

                sender.sendMessage(BaseUtil.getLangMsg("paramFailureMsg"));

            }

        }else{

            sender.sendMessage(BaseUtil.getLangMsg("setskinpermission-help"));

        }
    }
    @SneakyThrows
    public void httpget(String player,String b){

        HttpUtil.get(PLUGIN_API_URL + "modify/permission?player=" + player + "&token=" + PLUGIN_API_TOKEN + "&b=" + b);

    }
}