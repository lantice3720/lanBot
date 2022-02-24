package io.github.lantice3720.Command;

import io.github.lantice3720.Main;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;

import java.awt.*;

public class Help {
    public static EmbedBuilder help(String command[], Boolean shortened){
        EmbedBuilder builder = new EmbedBuilder(); // 엠베드 빌더
        if(command.length == 2){
            if(!Main.commands.contains(command[1])) { // !help후에 알 수 없는 명령어
                builder.setTitle("ERROR!");
                builder.setDescription("\"" + command[1] + "\" 명령어를 찾을 수 없습니다.");
                builder.setImage("https://cdn.discordapp.com/avatars/931158875913191434/1f004cc46dd236e54c38d4991081ee71.webp");
                return builder;
            }

            builder.setTitle("Command: " + command[1]);
            switch (command[1]) {
                case "도움말", "help", "명령어", "command" -> {
                    builder.setDescription("기본적인 봇의 정보를 알려줍니다.");
                    builder.addField("사용법", "!" + command[1] + " [<명령어>]", false);
                }
                case "주사위", "dice" -> {
                    builder.setDescription("주사위를 굴립니다.");
                    builder.addField("사용법", "!" + command[1] + " [<눈 수>] [<굴릴 횟수>] \r\n눈 수가 없다면 6으로 설정돼고, 굴릴 횟수가 없다면 1로 설정돼요.", false);
                }
                default -> {
                    builder.setDescription("어라? 어딘가 문제가 생겼어요. 란타넘한테 가서 \"에러났어요 빼애액!\"과 함께 이 설명을 던져주세요: Command list check error");
                }
            }

            return builder;
        }
        if(!shortened) {
            builder.setTitle("Bot Info");
            builder.setDescription("란타봇! 잡다한 기능들을 가지고 있어요. 명령어 목록만 보려면 !command 를 입력해 주세요.");

            builder.setThumbnail("https://cdn.discordapp.com/avatars/931158875913191434/1f004cc46dd236e54c38d4991081ee71.webp");

            builder.addBlankField(false);
        }else{
            builder.setTitle("Bot Commands");
        }
        builder.setColor(Color.gray);

        builder.addField("자세한 설명을 보려면 !help <명령어> 또는 !command <명령어> 를 입력하세요.", "`<>` 안에 들어 있는 건 쓰여있는 의미에 맞게 적고, `|` 로 나누어져 있는 건 개중에 골라 적으면 됩니다. `[]` 안에 들어 있는 건 적지 않아도 괜찮다는 뜻이에요.", false);

        builder.addBlankField(false);
        builder.addField(":game_die: 놀이", "`dice`", false).
                addField(":hammer_pick: 관리", "준비중", false).
                addField(":guitar: 기타", "`help`, `command`", false);

        return builder;
    }
}
