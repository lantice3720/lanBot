package io.github.lantice3720.Listener;

import io.github.lantice3720.Command.Dice;
import io.github.lantice3720.Command.Help;
import io.github.lantice3720.Fx;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.Command;

import java.awt.*;
import java.util.Random;

public class ChatEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return; // 봇일 경우 실행 안함
        if(e.getMessage().getContentDisplay().startsWith("!")){ // 느낌표 명령어인지 확인
            String[] command = e.getMessage().getContentRaw().split(" "); // 띄어쓰기 기준으로 분할
            System.out.println("Received command: "+e.getMessage().getContentRaw()+", "+command.length); // 콘솔에 로그

            switch (command[0]){
                case "!주사위":
                case "!dice":
                    e.getMessage().reply(Dice.dice(command)).mentionRepliedUser(false).queue(); // 답장 송신
                case "!도움말":
                case "!help":
                    e.getChannel().sendMessageEmbeds(Help.help(command, false).build()).queue();
                    break;
                case "!명령어":
                case "!commands":
                    e.getChannel().sendMessageEmbeds(Help.help(command, true).build()).queue();
                    break;
                default:
                    break;
            }
        }
    }

//    public void onCommand(SlashCommandInteractionEvent e){
//        if(e.getName().equals("dice")){
//            Random random = new Random();
//            String replyMessage = "asd ";
//            replyMessage += random.nextInt(6)+1;
//
//            e.reply(replyMessage);
//        }
//    }
}
