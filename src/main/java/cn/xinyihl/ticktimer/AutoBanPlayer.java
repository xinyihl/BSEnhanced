package cn.xinyihl.ticktimer;

import cn.handyplus.lib.api.MessageApi;

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
            }, 0, 1000*10);
            return "true";
        }else {
            AutoBanPlayer.cancel();
            return "false";
        }
    }
}
