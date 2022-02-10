package io.github.lantice3720.listener;

import io.github.lantice3720.Fx;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;
import java.util.Random;

public class ChatEvent extends ListenerAdapter {

    @Override
    public void onMessageReceived(MessageReceivedEvent e){
        if(e.getAuthor().isBot()) return; // 봇일 경우 실행 안함
        if(e.getMessage().getContentDisplay().startsWith("!")){ // 느낌표 명령어인지 확인
            String[] command = e.getMessage().getContentRaw().split(" "); // 띄어쓰기 기준으로 분할
            System.out.println("Received command: "+e.getMessage().getContentRaw()+", "+command.length); // 콘솔에 로그
            Random random = new Random(); // 주사위 굴리기 위한 객체 생성
            StringBuilder replyMessage = new StringBuilder();

            switch (command[0]){
                case "!dice" -> {
                    if (command.length <= 1) { // !dice 만 입력
                        replyMessage.append("d6을 굴립니다.\r\n결과는 **")
                                .append(random.nextInt(6) + 1)
                                .append("**!");
                    } else if (command.length == 2 && Fx.isNumeric(command[1]) && !command[1].equals("0")) { // !dice <eye> 입력
                        replyMessage.append("d")
                                .append(command[1])
                                .append("을 굴립니다.\r\n결과는 **")
                                .append(random.nextInt(Integer.parseInt(command[1])) + 1)
                                .append("**!");
                    } else if (command.length == 3 && Fx.isNumeric(command[1]) && Fx.isNumeric(command[2]) && !command[1].equals("0") && !command[2].equals("0")) { // !dice <eye> <roll> 입력
                        replyMessage.append(command[2])
                                .append("d").append(command[1])
                                .append("을 굴립니다.\r\n결과는 **");
                        for (int i = 0; i < Integer.parseInt(command[2]); i++) { // roll 횟수만큼 결과 출력
                            replyMessage.append(random.nextInt(Integer.parseInt(command[1])) + 1)
                                    .append(" ");
                        }
                        replyMessage.deleteCharAt(replyMessage.length() - 1);
                        replyMessage.append("**!");
                    } else { // 예외처리
                        replyMessage.append("에러 발생: Command length invalid or parameters not numeric."); // 에러 발생
                    }
                    e.getMessage().reply(replyMessage.toString()).mentionRepliedUser(false).queue(); // 답장 송신
                }
                case "!help" -> {
                    EmbedBuilder builder = new EmbedBuilder();

                    builder.setTitle("Bot Info");
                    builder.setDescription("yes, bot info.");

                    builder.setThumbnail("https://raw.githubusercontent.com/lantice3720/lanBot/master/src/main/resources/La57-inverted.png");

                    builder.addField("Field", "hehe", false);
                    builder.addField("Field2", "hehe2", true);
                    builder.addBlankField(false);


                    e.getChannel().sendMessageEmbeds(builder.build()).queue();
                }
                default -> { }
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
