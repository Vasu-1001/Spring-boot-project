package codeio.hello.world;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToolsController {

    @GetMapping("/get")
    String getTodo() {
        return "Hii todo";
    }

    @GetMapping("/get2")
    String getTodo2() {
        return "Todo";
    }

    @GetMapping("/{id}")
    String getTodoById(@PathVariable long id) {
        return "Todo with id " + id;
    }

    @GetMapping("/create")
    String createUser(
            @RequestParam String userid,
            @RequestParam String password) {

        return "todo with username " + userid +
                " password " + password;
    }

    @PostMapping("/create1")
    String createPass(@RequestBody String body) {
        return body;
    }

    @PutMapping("/{id}")
    String updateTodo(@PathVariable long id) {
        return "Update Todo with id " + id;
    }

    @DeleteMapping("/{id}")
    String deleteTodo(@PathVariable long id) {
        return "Delete Todo with id " + id;
    }
}