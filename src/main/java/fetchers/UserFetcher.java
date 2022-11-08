package fetchers;

import com.google.gson.Gson;

import dtos.ChuckNorrisDTO;
import dtos.UserDTO;
import utils.HttpUtils;

import java.io.IOException;

public class UserFetcher {
    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
       String personsJoke = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
       ChuckNorrisDTO chuckNorrisDTO =gson.fromJson(personsJoke,ChuckNorrisDTO.class);
        System.out.println(chuckNorrisDTO.getJoke());
        String test = HttpUtils.fetchData("http://localhost:8080/devops_starter_war_exploded/api/xxx");
        UserDTO userDTO = gson.fromJson(test,UserDTO.class);
        System.out.println(userDTO.getUsername());
        System.out.println(userDTO.getUserPass());
        userDTO.setPersonalJoke(chuckNorrisDTO.getJoke());
        System.out.println(userDTO.getPersonalJoke());

    }
}
