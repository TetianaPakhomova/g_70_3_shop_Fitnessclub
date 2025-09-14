package app.exseption;

public class TrainerNotFoundExseption extends RuntimeException {

  public TrainerNotFoundExseption(String message) {

    super(String.valueOf(message));
  }
}
