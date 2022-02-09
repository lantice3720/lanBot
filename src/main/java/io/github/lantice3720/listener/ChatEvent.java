package io.github.lantice3720.listener;

import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Random;

public class ChatEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return;
        if(e.getMessage().getContentDisplay().startsWith("!")){
            String[] command = e.getMessage().getContentRaw().split(" ");
            System.out.println("Received command: "+e.getMessage().getContentRaw()+", "+command.length);
            if(command.length <= 1) {
                return;
            }else if(command.length == 2){
                Random random = new Random();
                e.getMessage().reply(String.valueOf(random.nextInt(6)+1));
                e.getChannel().sendMessage("asd");
                System.out.println("asdd");
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
