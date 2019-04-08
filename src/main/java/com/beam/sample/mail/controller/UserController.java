package com.beam.sample.mail.controller;

import com.beam.sample.mail.dto.Response;
import com.beam.sample.mail.model.Constants;
import com.beam.sample.mail.model.Mail;
import com.beam.sample.mail.model.User;
import com.beam.sample.mail.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.beam.sample.mail.model.Constants.SESSION_USER;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> list(HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            return userService.list();
        } else
            return null;
    }

    @PostMapping("add")
    public User add(@RequestBody User user, HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            return userService.add(user);
        } else
            return null;
    }

    @DeleteMapping
    public void remove(@RequestParam("id") String id) {

        userService.removeById(id);
    }

    @PostMapping("authentication")
    public Response authenticateUser(@RequestParam("name") String name, @RequestParam("password") String password, HttpSession session) {
        User user = userService.authenticateUser(name, password);
        if (user != null) {
            session.setAttribute(SESSION_USER, user);
            return new Response()
                    .setCode(0)
                    .setMessage("success")
                    .setData(user);
        } else {
            return new Response()
                    .setCode(1);
        }

    }

    @GetMapping("{id}")
    public User getUser(@PathVariable("id") String id, HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            return userService.getUser(id);
        } else
            return null;
    }

    @PostMapping("mail-list")
    public List<Mail> getMailList(HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            User currentUser = (User) session.getAttribute(SESSION_USER);
            return userService.getMailList(currentUser);
        } else
            return null;
    }

    @PostMapping("get-by-name")
    public User getUserByName(@RequestParam("receiver") String receiver, HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            return userService.getUserByName(receiver);
        } else
            return null;
    }

    @PostMapping("get-by-nameL")
    public User getUserByNameL(@RequestParam("receiver") String receiver, HttpSession session) {

        return userService.getUserByName(receiver);
    }

    @PostMapping("change-password")
    public void changePassword(@RequestBody User user, HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            User curr = (User) session.getAttribute(SESSION_USER);
            user.setId(curr.getId());
            user.setName(curr.getName());
            userService.update(user);
        }
    }
    @PostMapping("change-passwordL")
    public void changePasswordL(@RequestBody User user) {

        userService.update(user);

    }

    @PostMapping("change-question")
    public void changeQuestion(@RequestBody User user, HttpSession session) {
        if (session.getAttribute(SESSION_USER) != null) {
            User cur = (User) session.getAttribute(SESSION_USER);
            user.setId(cur.getId());
            user.setName(cur.getName());
            user.setPassword(cur.getPassword());
            userService.update(user);
        }


    }
}
