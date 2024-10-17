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

public class UsersService implements Service {

    private GameManager gm = GameManager.getInstance();

    @Override
    public Response handleRequest(Request request) {
        // User creation
        if (request.getMethod() == Method.POST) {
            return registerUser(request);
        } else if (request.getMethod() == Method.GET) {

        }

        return new Response(
                HttpStatus.BAD_REQUEST,
                ContentType.JSON,
                "[]"
        );
    }

    /**
     * Tries to register a new User in the Database
     * @param request
     * @return
     */
    private Response registerUser(Request request){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // Convert JSON string to Map
            Map<String, String> map = objectMapper.readValue(request.getBody(), new TypeReference<Map<String, String>>(){});

            // Check if the Valid Fields are contained, if not throw exception -> catch block -> 400 Bad Request
            if(!(map.containsKey("Username") && map.containsKey("Password"))){
                return new Response(
                        HttpStatus.BAD_REQUEST,
                        ContentType.JSON,
                        "[]"
                );
            }

            // Try to register the user
            if(gm.registerUser(map.get("Username"),map.get("Password"))){
                return new Response(
                        HttpStatus.CREATED,
                        ContentType.JSON,
                        "[]"
                );
            }

            // User is already registered
            return new Response(
                    HttpStatus.CONFLICT,
                    ContentType.JSON,
                    "[]"
            );


        } catch (Exception e) {
            e.printStackTrace();
            return new Response(
                    HttpStatus.BAD_REQUEST,
                    ContentType.JSON,
                    "[]"
            );
        }
    }
}
