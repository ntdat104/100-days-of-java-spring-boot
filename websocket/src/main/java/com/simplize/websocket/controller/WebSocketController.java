package com.simplize.websocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping("/websocket")
    public String getWebSocketPage() {
        return "websocket"; // Return the HTML page for WebSocket connection
    }
}
