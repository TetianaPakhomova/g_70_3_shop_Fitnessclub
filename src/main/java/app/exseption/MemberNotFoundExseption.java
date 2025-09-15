package app.exseption;

public class MemberNotFoundExseption extends RuntimeException {

    public MemberNotFoundExseption(String id) {
        super(String.format("Клиент с таким id %d не найден", id));
    }
}
