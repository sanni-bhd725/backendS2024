package week2.friend_list.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import week2.friend_list.domain.Friend;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FriendController {

    List<Friend> friends = new ArrayList<>();

    @GetMapping("friendlist")
    public String showFriends(Model model) {

        model.addAttribute("friends", friends);

        return "friendlist";
    }

    // Add a new friend
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addFriend(Model model) {
        model.addAttribute("friend", new Friend());
        return "add";
    }

    // Save a new adding
    @RequestMapping(value = "/adding", method = RequestMethod.POST)
    public String saveFriend(Friend friend, Model model) {
        friends.add(friend);
        return "redirect:/friendlist";
    }

    // List and adding on the same page:
    @RequestMapping(value = "/listandadd", method = { RequestMethod.GET, RequestMethod.POST })
    public String showAndAdd(Model model, Friend friend) {
        model.addAttribute("friends", friends);
        model.addAttribute("friend", new Friend());
        friends.add(friend);
        return "listandadd";
    }
}
