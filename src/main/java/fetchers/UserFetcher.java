package fetchers;

import com.google.gson.Gson;

import dtos.UserDTO;
import utils.HttpUtils;

import java.io.IOException;

public class UserFetcher {
    public static void main(String[] args) throws IOException {

        // TODO: 08-11-2022: needs more.
        Gson gson = new Gson();
        String getPeople = HttpUtils.fetchData("https://api.chucknorris.io/jokes/random");
        System.out.println(getPeople);

       // UserDTO userDTO = gson.fromJson(getPeople,UserDTO.class);

    }
}
