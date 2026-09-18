package codeio.hello.world;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    public Todo getTodoById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Todo createTodo(Todo todo) {
        return repository.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo) {
        Todo existingTodo = repository.findById(id).orElse(null);

        if (existingTodo == null) {
            return null;
        }

        existingTodo.setTitle(todo.getTitle());
        existingTodo.setCompleted(todo.isCompleted());

        return repository.save(existingTodo);
    }

    public void deleteTodo(Long id) {
        repository.deleteById(id);
    }
}