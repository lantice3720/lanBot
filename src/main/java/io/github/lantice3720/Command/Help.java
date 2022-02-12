package io.github.lantice3720.Command;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;

public class Help {
    public static EmbedBuilder help(String command[], Boolean shortened){
        EmbedBuilder builder = new EmbedBuilder(); // 엠베드 빌더
        if(command.length == 2){

            return builder;
        }
        if(!shortened) {
            builder.setTitle("Bot Info");
            builder.setDescription("란타봇! 잡다한 기능들을 가지고 있어요. 명령어 목록만 보려면 !commands 를 입력해 주세요.");

            builder.setThumbnail("https://raw.githubusercontent.com/lantice3720/lanBot/master/src/main/resources/La57-inverted-circle.png");

            builder.addBlankField(false);
        }else{
            builder.setTitle("Bot Commands");
        }
        builder.setColor(Color.gray);

        builder.addField("자세한 설명을 보려면 !help <명령어> 또는 !commands <명령어> 를 입력하세요.", "`<>` 안에 들어 있는 건 쓰여있는 의미에 맞게 적고, `|` 로 나누어져 있는 건 개중에 골라 적으면 됩니다. `[]` 안에 들어 있는 건 적지 않아도 괜찮다는 뜻이에요.", false);

        builder.addBlankField(false);
        builder.addField(":game_die: 놀이", "`dice`", false).
                addField(":hammer_pick: 관리", "준비중", false).
                addField(":guitar: 기타", "`help`, `commands`", false);

        return builder;
    }
}
