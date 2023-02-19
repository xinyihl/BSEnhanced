package cn.xinyihl.util;

import cn.handyplus.lib.InitApi;
import cn.handyplus.lib.api.MessageApi;
import cn.handyplus.lib.util.BaseUtil;
import cn.handyplus.lib.util.TextUtil;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class CheckVersion {

    public static void checkVersion(Player player, String url) {
        if (player != null && !player.isOp()) {
            return;
        }
        Bukkit.getScheduler().runTaskAsynchronously(InitApi.PLUGIN, () -> {
            String version = InitApi.PLUGIN.getDescription().getVersion();
            String tagName = BaseUtil.getOfficialVersion(url);
            if (tagName != null && BaseUtil.convertVersion(tagName) > BaseUtil.convertVersion(version)) {
                String oneMsg = ChatColor.GRAY + "&f[&3" + InitApi.PLUGIN.getDescription().getName() + ChatColor.GRAY + "&f]" + " &a最新版本:&d" + tagName + "&a当前版本:&d" + version;
                TextComponent message = TextUtil.getInstance().init(oneMsg).build();
                String twoMsg =" &a点击&d&n此处查看&a更新内容\n";
                message.addExtra(TextUtil.getInstance().init(twoMsg).addClickUrl(InitApi.PLUGIN.getDescription().getWebsite()).build());
                if (player == null) {
                    MessageApi.sendConsoleMessage(twoMsg);
                } else {
                    MessageApi.sendMessage(player, message);
                }
            }
        });
    }

}
