package app.exseption;

public class MemberNotFoundExseption extends RuntimeException {

    public MemberNotFoundExseption(Long id) {
        super(String.format("Клиент с таким id %d не найден", id));
    }
}
