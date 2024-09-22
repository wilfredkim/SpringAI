package io.github.wilfred.springai;

import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FunctionController {
    @Autowired
    ChatModel chatModel;

    public String promptMessage(@RequestParam(value = "message", defaultValue = "What is your name?") String message) {
        UserMessage userMessage = new UserMessage(message);
        ChatResponse chatResponse = chatModel.call(new Prompt(List.of(userMessage),
                OpenAiChatOptions.builder().withFunction("getWeather")
                        .build()));
        return chatResponse.getResult().getOutput().getContent();

    }
}
