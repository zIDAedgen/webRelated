package life.majiang.community.community.controller;


import life.majiang.community.community.dto.AccessTokenDTO;
import life.majiang.community.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {


    @Autowired
    private GithubProvider githubProvider;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code, @RequestParam(name = "state") String state) {
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("d15cc7c0ff452f29ab77");
        accessTokenDTO.setClient_secret("5ee4589b6763ac87efac36d70d1900068e7bb107");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDTO.setState(state);
        System.out.println(state);
                githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
