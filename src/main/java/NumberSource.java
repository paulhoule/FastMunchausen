import java.util.function.Consumer;

public interface NumberSource {
    void emit(Consumer<Integer> consumer);
}
