import java.util.function.Consumer;

public class DeepLoop implements NumberSource {
    private final static int[] powers = getPowers();

    private static int[] getPowers()
    {
        int[] cache = new int[10];
        cache[0] = 0;
        for (int i = 1; i <= 9; ++i) {
            cache[i] = (int)Math.pow(i, i);
        }
        return cache;
    }

    public void emit(Consumer<Integer> consumer) {
        var n = 0;
        var sum = 0;
        byte DIGIT=10;
        byte DIGIT8=DIGIT;
        for (int i9 = 0; i9<5; i9++) {
            sum += powers[i9];
            if (i9==4) {
                DIGIT8 = 4;
            }
            for (int i8 = 0 ;i8<DIGIT8; i8++) {
                sum += powers[i8];
                for (int i7 = 0; i7 < DIGIT; i7++) {
                    sum += powers[i7];
                    for (int i6 = 0; i6 < DIGIT; i6++) {
                        sum += powers[i6];
                        for (int i5 = 0; i5 < DIGIT; i5++) {
                            sum += powers[i5];
                            for (int i4 = 0; i4 < DIGIT; i4++) {
                                sum += powers[i4];
                                for (int i3 = 0; i3 < DIGIT; i3++) {
                                    sum += powers[i3];
                                    for (int i2 = 0; i2 < DIGIT; i2++) {
                                        sum += powers[i2];
                                        for (int i1 = 0; i1 < DIGIT; i1++) {
                                            sum += powers[i1];
                                            if (sum == n) {
                                                consumer.accept(n);
                                            }
                                            sum -= powers[i1];
                                            n++;
                                        }
                                        sum -= powers[i2];
                                    }
                                    sum -= powers[i3];
                                }
                                sum -= powers[i4];
                            }
                            sum -= powers[i5];
                        }
                        sum -= powers[i6];
                    }
                    sum -= powers[i7];
                }
                sum -= powers[i8];
            }
            sum -= powers[i9];
        }
    }

    public static void main(String[] args)
    {
        DeepLoop m = new DeepLoop();
        m.emit(System.out::println);
    }
}
