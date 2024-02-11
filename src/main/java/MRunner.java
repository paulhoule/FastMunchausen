import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

import static java.lang.System.out;
import static java.time.Duration.between;
import static java.time.Instant.now;
import static java.util.Objects.isNull;

public class MRunner {
    static float time(NumberSource source) {
        return time(source, 5);
    }
    @SuppressWarnings("SameParameterValue")
    static float time(NumberSource source, int N) {
        float result = 0.0f;
        Set<Integer> matching = new HashSet<>();
        Set<Integer> current = null;
        Consumer<Integer> destination = out::println;
        destination = destination.andThen(matching::add);
        for (int i = 0; i < N; i++) {
            var start = now();
            source.emit(destination);
            var finish = now();
            long timeElapsed = between(start, finish).toMillis();
            if(isNull(current)) {
                out.println();
            } else if(!matching.equals(current)) {
                throw new RuntimeException("Got different results on different runs");
            }
            out.println("Pass " + i + " Elapsed time " + timeElapsed + " ms");
            result += timeElapsed;
            current = new HashSet<>();
            destination = current::add;
        }
        return result/N;
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String name=args.length>0 ? args[0] : "DeepLoop";
        var loader = MRunner.class.getClassLoader();
        Class<?> that = loader.loadClass(name);
        var m = (NumberSource) that.getConstructor().newInstance();
        out.println("Benchmarking class "+name);
        var t = time(m);
        out.println();
        out.println("Average elapsed time = "+ t + " ms");
    }
}
