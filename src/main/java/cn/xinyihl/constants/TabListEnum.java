package cn.xinyihl.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@AllArgsConstructor
public enum TabListEnum {

    FIRST(Arrays.asList("help","reload","setperm","setscore","test"), 0, null, 1),

    SECOND(Arrays.asList("add","remove","set"),  1, "setscore", 3),

    THIRD(Arrays.asList("-1","0","1","2"), 1, "setperm", 3),;

    private final List<String> list;
    private final int befPos;
    private final String bef;
    private final int num;

    public static List<String> returnList(String[] args, int argsLength) {

        List<String> completions = new ArrayList<>();

        for (TabListEnum tabListEnum : TabListEnum.values()) {

            if (tabListEnum.getBefPos() - 1 >= args.length) {
                continue;
            }

            if ((tabListEnum.getBef() == null || tabListEnum.getBef().equalsIgnoreCase(args[tabListEnum.getBefPos() - 1])) && tabListEnum.getNum() == argsLength) {
                completions = tabListEnum.getList();
            }

        }

        return completions;

    }
}
