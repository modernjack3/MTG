package at.fhtw.mtg.service.users;

import at.fhtw.httpserver.http.ContentType;
import at.fhtw.httpserver.http.HttpStatus;
import at.fhtw.httpserver.http.Method;
import at.fhtw.httpserver.server.Request;
import at.fhtw.httpserver.server.Response;
import at.fhtw.httpserver.server.Service;
import at.fhtw.mtg.controller.GameManager;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class SessionService implements Service {

    private GameManager gm = GameManager.getInstance();

    @Override
    public Response handleRequest(Request request) {
        ObjectMapper objectMapper = new ObjectMapper();

        if (request.getMethod() == Method.POST) {
            try{
                Map<String, String> map = objectMapper.readValue(request.getBody(), new TypeReference<Map<String, String>>(){});

                // Check if the Valid Fields are contained, if not throw exception -> catch block -> 400 Bad Request
                if(!(map.containsKey("Username") && map.containsKey("Password"))){
                    return new Response(
                            HttpStatus.BAD_REQUEST,
                            ContentType.JSON,
                            "[]"
                    );
                }

                String token = gm.loginUser(map.get("Username"), map.get("Password"));

                if(token != null){
                    return new Response(
                            HttpStatus.OK,
                            ContentType.JSON,
                            token
                    );
                }

            }catch (Exception e){
                return new Response(
                        HttpStatus.BAD_REQUEST,
                        ContentType.JSON,
                        "[]"
                );
            }

            return new Response(
                    HttpStatus.UNAUTHORIZED,
                    ContentType.JSON,
                    "Wrong username or password."
            );

        }

        return new Response(
                HttpStatus.BAD_REQUEST,
                ContentType.JSON,
                "[]"
        );
    }
}
