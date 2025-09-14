package app.exseption;

public class TrainerNotFoundExseption extends RuntimeException {

  public TrainerNotFoundExseption(Long message) {

    super(String.valueOf(message));
  }
}
