package cn.xinyihl.ticktimer;

import cn.handyplus.lib.api.MessageApi;
import cn.xinyihl.util.ConfigUtil;
import org.bukkit.BanList;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Timer;
import java.util.TimerTask;

public class AutoBanPlayer {

    public static String MyTimerTask(Boolean type) {
        Timer AutoBanPlayer = new Timer();
        if(type) {
            AutoBanPlayer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    // Your code here
                    MessageApi.sendConsoleMessage("§atest！");
                }
            }, 0, 1000*60);
            return "true";
        }else {
            AutoBanPlayer.cancel();
            return "false";
        }
    }

    public static void TimerAutoBan(Player player,Boolean type){

        BanList banList = Bukkit.getBanList(BanList.Type.NAME);

        if (player != null && type) {
            banList.addBan(player.getName(), ConfigUtil.CONFIG.getString("bannedauto"), null, "AutoBanned");
        } else if (player != null){
            banList.pardon(player.getName());
        }

    }


}
